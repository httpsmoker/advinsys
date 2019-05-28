/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advinsys.vista;

import advinsys.control.InterfaceProveedores;
import advinsys.dao.ProveedorDAO;
import advinsys.entidad.Proveedor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class UIProveedores extends javax.swing.JPanel {

    private ProveedorDAO proveedorDAO;
    private InterfaceProveedores interProveedores;
    private static String dato, dato3;
    private static int dato2;

    public UIProveedores(InterfaceProveedores interProveedores) {
        initComponents();
        this.interProveedores = interProveedores;
        cargarTabla();
    }

    public void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaProveedores.getModel();
        List<Proveedor> listaProveedores = interProveedores.getListarProveedores();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < listaProveedores.size(); i++) {
            fila[0] = listaProveedores.get(i).getIdProveedor();
            fila[1] = listaProveedores.get(i).getNombreProveedor();
            fila[2] = listaProveedores.get(i).getNit();
            fila[3] = listaProveedores.get(i).getTelefono();
            fila[4] = listaProveedores.get(i).getDireccion();

            modelo.addRow(fila);

        }
    }

    public void modificar() {
        DefaultTableModel modelo = (DefaultTableModel) tablaProveedores.getModel();

        if (tablaProveedores.getSelectedRow() != -1) {

            dato = (String) modelo.getValueAt(tablaProveedores.getSelectedRow(), 0);
            dato2 = tablaProveedores.getSelectedRow();
            UIAdminProveedoresModificar mo = new UIAdminProveedoresModificar(new javax.swing.JFrame(), true);
            mo.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor primero");
        }

    }

    public void eliminar() {
        DefaultTableModel modelo = (DefaultTableModel) tablaProveedores.getModel();
        proveedorDAO = new ProveedorDAO();

        if (tablaProveedores.getSelectedRow() != -1) {
            dato3 = (String) modelo.getValueAt(tablaProveedores.getSelectedRow(), 0);
            proveedorDAO.eliminar();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor primero");
        }

    }

    public static String getDato() {
        return dato;
    }

    public static int getDato2() {
        return dato2;
    }

    public static String getDato3() {
        return dato3;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 570, 890, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("PROVEEDORES");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "NIT", "TELEFONO", "DIRECCION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaProveedores);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 1050, 470));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        interProveedores.inicio();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UIAdminProveedores p = new UIAdminProveedores(new javax.swing.JFrame(), true);
        p.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        modificar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        eliminar();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaProveedores;
    // End of variables declaration//GEN-END:variables
}
