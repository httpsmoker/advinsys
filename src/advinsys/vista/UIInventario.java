/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advinsys.vista;

import advinsys.control.GestionInventario;
import advinsys.control.InterfaceInventario;
import advinsys.dao.ArticuloDAO;
import advinsys.entidad.Articulo;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class UIInventario extends javax.swing.JPanel {

    private ArticuloDAO articuloDAO;
    private InterfaceInventario interInventario;
    private static String dato, dato3, dato4, cantidad, dato6;
    private static int dato2, dato5, dato7, cantidad2, cantidad3, cantidad4;

    public UIInventario(InterfaceInventario interInventario) {
        initComponents();
        this.interInventario = interInventario;
        cargarTabla();
        

    }

    public void modificar() {
        DefaultTableModel modelo = (DefaultTableModel) tablaArticulos.getModel();

        if (tablaArticulos.getSelectedRow() != -1) {

            dato = (String) modelo.getValueAt(tablaArticulos.getSelectedRow(), 0);
            dato2 = tablaArticulos.getSelectedRow();
            UIAdminInventarioModificar in = new UIAdminInventarioModificar(new javax.swing.JFrame(), true);
            in.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto primero");
        }

    }
    
    public void comprobar(){
        List<Articulo> listaArticulos = interInventario.getListarArticulos();
        for (int i = 0; i < listaArticulos.size(); i++) {
            if (listaArticulos.get(i).getCantidad()<=10) {
                JOptionPane.showMessageDialog(null,"EL PRODUCTO: "+listaArticulos.get(i).getIdArticulo()+" ESTA POR AGOTAR EXISTENCIAS"
                        + "\n        CANTIDAD: "+listaArticulos.get(i).getCantidad());
                
            }
            
        }
        
    }

    public void despachar() {
        DefaultTableModel modelo = (DefaultTableModel) tablaArticulos.getModel();

        if (tablaArticulos.getSelectedRow() != -1) {

            dato4 = (String) modelo.getValueAt(tablaArticulos.getSelectedRow(), 0);
            dato5 = tablaArticulos.getSelectedRow();
            cargarCantidad2();
            if (cantidad2 == 0) {
                JOptionPane.showMessageDialog(null, "NO HAY UNIDADES EN INVENTARIO");

            } else {
                UIAdminInventarioDespachar in = new UIAdminInventarioDespachar(new javax.swing.JFrame(), true);
                in.setVisible(true);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto primero");
        }

    }

    public void cargarCantidad() {
        GestionInventario gi = new GestionInventario();
        List<Articulo> listaArticulos = gi.getListarArticulos();
        int i = dato7;
        cantidad2 = listaArticulos.get(i).getCantidad();

    }

    public void cargarCantidad2() {
        GestionInventario gi = new GestionInventario();
        List<Articulo> listaArticulos = gi.getListarArticulos();
        int i = dato5;
        cantidad2 = listaArticulos.get(i).getCantidad();

    }

    public void agrega() {
        DefaultTableModel modelo = (DefaultTableModel) tablaArticulos.getModel();
        articuloDAO = new ArticuloDAO();

        if (tablaArticulos.getSelectedRow() != -1) {

            dato6 = (String) modelo.getValueAt(tablaArticulos.getSelectedRow(), 0);
            dato7 = tablaArticulos.getSelectedRow();
            cantidad = JOptionPane.showInputDialog("CANTIDAD A AGREGAR");
            cargarCantidad();
            if (cantidad == null) {
                JOptionPane.showMessageDialog(null, "OPERACION CANCELADA");

            } else {
                cantidad4 = Integer.parseInt(cantidad);

                if (cantidad4 > 0) {
                    cantidad3 = (cantidad2 + cantidad4);
                    articuloDAO.agrega();

                } else {
                    JOptionPane.showMessageDialog(null, "LA CANTIDAD ES NEGATIVA");

                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto primero");
        }

    }

    public void eliminar() {
        DefaultTableModel modelo = (DefaultTableModel) tablaArticulos.getModel();
        articuloDAO = new ArticuloDAO();

        if (tablaArticulos.getSelectedRow() != -1) {
            dato3 = (String) modelo.getValueAt(tablaArticulos.getSelectedRow(), 0);
            articuloDAO.eliminar();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto primero");
        }

    }

    public void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaArticulos.getModel();
        List<Articulo> listaArticulos = interInventario.getListarArticulos();
        Object[] fila = new Object[modelo.getColumnCount()];

        for (int i = 0; i < listaArticulos.size(); i++) {
            fila[0] = listaArticulos.get(i).getIdArticulo();
            fila[1] = listaArticulos.get(i).getDescripcion();
            fila[2] = listaArticulos.get(i).getIdProveedor();
            fila[3] = listaArticulos.get(i).getPrecio();
            fila[4] = listaArticulos.get(i).getCantidad();

            modelo.addRow(fila);
            

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

    public static String getDato4() {
        return dato4;
    }

    public static int getDato5() {
        return dato5;
    }

    public static String getDato6() {
        return dato6;
    }

    public static int getDato7() {
        return dato7;
    }

    public static int getCantidad3() {
        return cantidad3;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaArticulos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("INVENTARIO");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        tablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "DESCRIPCION", "PROVEEDOR", "PRECIO", "CANTIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaArticulos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaArticulos);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1070, 480));

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

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/bolsa.png"))); // NOI18N
        jButton6.setText("AGREGAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/flecha.png"))); // NOI18N
        jButton2.setText("DESPACHAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/espalda.png"))); // NOI18N
        jButton3.setText("INICIO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 580, 980, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        interInventario.inicio();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UIAdminInventario i = new UIAdminInventario(new javax.swing.JFrame(), true);
        i.setVisible(true);
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        despachar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        agrega();
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaArticulos;
    // End of variables declaration//GEN-END:variables
}
