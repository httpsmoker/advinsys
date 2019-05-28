/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advinsys.vista;

import advinsys.control.GestionDespachos;
import advinsys.control.InterfaceDespachos;
import advinsys.entidad.Despachos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class UIDespachos extends javax.swing.JPanel {

    private InterfaceDespachos interDespachos;

    public UIDespachos(InterfaceDespachos interDespachos) {
        initComponents();
        this.interDespachos = interDespachos;
        cargarTabla();


    }


    public void mostrarR() {
        List<String> list = new ArrayList<>();

        for (int row = 0; row < tablaDespachos.getRowCount(); row++) {
            for (int column = 0; column < tablaDespachos.getColumnCount(); column++) {
                list.add((String) tablaDespachos.getValueAt(0, 0));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("" + list.get(i));

        }

    }



    public void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaDespachos.getModel();
        List<Despachos> listaDespachos = interDespachos.getListarDespachos();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < listaDespachos.size(); i++) {
            fila[0] = listaDespachos.get(i).getIdArticulo();
            fila[1] = listaDespachos.get(i).getIdEmpleado();
            fila[2] = listaDespachos.get(i).getCantidadDespacho();
            fila[3] = listaDespachos.get(i).getFechaDespacho();

            modelo.addRow(fila);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDespachos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1130, 675));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 520, 728, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("DESPACHOS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 43, -1, -1));

        tablaDespachos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PRODUCTO", "ID EMPLEADO", "CANTIDAD", "FECHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaDespachos);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 92, 1050, 468));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/espalda.png"))); // NOI18N
        jButton3.setText("INICIO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 600, 728, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        interDespachos.inicio();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tablaDespachos;
    // End of variables declaration//GEN-END:variables
}
