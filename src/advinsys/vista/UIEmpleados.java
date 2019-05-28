/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advinsys.vista;

import advinsys.control.InterfaceEmpleados;
import advinsys.dao.EmpleadoDAO;
import advinsys.entidad.Empleados;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class UIEmpleados extends javax.swing.JPanel {

    private EmpleadoDAO empleadoDAO;
    private InterfaceEmpleados interEmpleados;
    private static String dato, dato3;
    private static int dato2;

    public UIEmpleados(InterfaceEmpleados interEmpleados) {
        initComponents();
        this.interEmpleados = interEmpleados;
        cargarTabla();

    }

    public void modificar() {
        DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();

        if (tablaEmpleados.getSelectedRow() != -1) {

            dato = (String) modelo.getValueAt(tablaEmpleados.getSelectedRow(), 0);
            dato2 = tablaEmpleados.getSelectedRow();
            UIAdminEmpleadoModificar em = new UIAdminEmpleadoModificar(new javax.swing.JFrame(), true);
            em.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un empleado primero");
        }

    }

    public void eliminar() {
        DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
        empleadoDAO = new EmpleadoDAO();

        if (tablaEmpleados.getSelectedRow() != -1) {
            dato3 = (String) modelo.getValueAt(tablaEmpleados.getSelectedRow(), 0);
            empleadoDAO.eliminar();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un empleado primero");
        }

    }

    public static String getDato3() {
        return dato3;
    }

    public void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
        List<Empleados> listaEmpleados = interEmpleados.getListarEmpleados();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < listaEmpleados.size(); i++) {
            fila[0] = listaEmpleados.get(i).getIdEmpleado();
            fila[1] = listaEmpleados.get(i).getNombreEmpleado();
            fila[2] = listaEmpleados.get(i).getApellidos();
            fila[3] = listaEmpleados.get(i).getDireccion();
            fila[4] = listaEmpleados.get(i).getFechaNac();
            fila[5] = listaEmpleados.get(i).getFechaIngreso();
            fila[6] = listaEmpleados.get(i).getTelefono();
            fila[7] = listaEmpleados.get(i).getFuncion();
            fila[8] = listaEmpleados.get(i).getPassword();
            modelo.addRow(fila);

        }
    }

    public static String getDato() {
        return dato;
    }

    public static int getDato2() {
        return dato2;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ADMINISTRADOR DE EMPLEADOS");

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "NOMBRES", "APELLIDOS", "DIRECCION", "FECHA NACIMIENTO", "FECHA INGRESO", "TELEFONO", "FUNCION", "CONTRASEÑAl"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaEmpleados);
        if (tablaEmpleados.getColumnModel().getColumnCount() > 0) {
            tablaEmpleados.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/plus.png"))); // NOI18N
        jButton1.setText("NUEVO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/editar.png"))); // NOI18N
        jButton5.setText("MODIFICAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/boton-x.png"))); // NOI18N
        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/espalda.png"))); // NOI18N
        jButton3.setText("INICIO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(392, 392, 392))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        interEmpleados.inicio();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UIAdminEmpleado e = new UIAdminEmpleado(new javax.swing.JFrame(), true);
        e.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        modificar();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar?");
        if (opcion == JOptionPane.OK_OPTION) {
            eliminar();
        }


    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
