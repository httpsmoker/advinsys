package advinsys.vista;

import advinsys.control.GestionDespachos;
import advinsys.control.GestionEmpleado;
import advinsys.control.GestionInventario;
import advinsys.control.GestionProveedores;
import advinsys.control.GestionReportes;
import advinsys.control.ReporteEmpleados;
import advinsys.control.ReporteProductos;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class UIPrincipal extends javax.swing.JFrame {

    private GestionEmpleado gestionEmpleado;
    private GestionProveedores gestionProveedores;
    private GestionDespachos gestionDespachos;
    private GestionReportes gestionReportes;
    private GestionInventario gestionInventario;

    public UIPrincipal() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        bloquear();

    }

    public JPanel getPanel() {
        return this.panelPrincipal;
    }

    public void setPanel(JPanel panel) {
        this.panelPrincipal = panel;

    }

    public void desbloquear1() {
        itemInventario.setEnabled(true);
        itemProveedores.setEnabled(true);
    }

    public void desbloquear2() {
        itemEmpleados.setEnabled(true);
        itemInventario.setEnabled(true);
        itemProveedores.setEnabled(true);
        itemVentas.setEnabled(true);
        itemRePro.setEnabled(true);
        itemReporteProducto.setEnabled(true);

    }

    public void bloquear() {
        itemEmpleados.setEnabled(false);
        itemInventario.setEnabled(false);
        itemProveedores.setEnabled(false);
        itemVentas.setEnabled(false);
        itemRePro.setEnabled(false);
        itemReporteProducto.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        panelPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        itemAcercaDe = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();
        menuFunciones = new javax.swing.JMenu();
        itemEmpleados = new javax.swing.JMenuItem();
        itemProveedores = new javax.swing.JMenuItem();
        itemInventario = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        itemVentas = new javax.swing.JMenuItem();
        itemRePro = new javax.swing.JMenuItem();
        itemReporteProducto = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 650));

        jMenu2.setText("ADVINSYS");
        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        itemAcercaDe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/informacion.png"))); // NOI18N
        itemAcercaDe.setText("Acerca de");
        itemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAcercaDeActionPerformed(evt);
            }
        });
        jMenu2.add(itemAcercaDe);

        itemSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/logout.png"))); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        jMenu2.add(itemSalir);

        jMenuBar1.add(jMenu2);

        menuFunciones.setText("FUNCIONES");
        menuFunciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        itemEmpleados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/grupo.png"))); // NOI18N
        itemEmpleados.setText("ADMINISTRAR EMPLEADOS");
        itemEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEmpleadosActionPerformed(evt);
            }
        });
        menuFunciones.add(itemEmpleados);

        itemProveedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/grupo.png"))); // NOI18N
        itemProveedores.setText("ADMINISTRAR PROVEEDORES");
        itemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProveedoresActionPerformed(evt);
            }
        });
        menuFunciones.add(itemProveedores);

        itemInventario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/administrar.png"))); // NOI18N
        itemInventario.setText("ADMINISTRAR INVENTARIO");
        itemInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInventarioActionPerformed(evt);
            }
        });
        menuFunciones.add(itemInventario);

        jMenuBar1.add(menuFunciones);

        menuReportes.setText("REPORTES");
        menuReportes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        itemVentas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/administrar.png"))); // NOI18N
        itemVentas.setText("VER DESPACHOS");
        itemVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVentasActionPerformed(evt);
            }
        });
        menuReportes.add(itemVentas);

        itemRePro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemRePro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/analytics.png"))); // NOI18N
        itemRePro.setText("REPORTES EMPLEADOS");
        itemRePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReProActionPerformed(evt);
            }
        });
        menuReportes.add(itemRePro);

        itemReporteProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemReporteProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/analytics.png"))); // NOI18N
        itemReporteProducto.setText("REPORTE PRODUCTOS");
        itemReporteProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReporteProductoActionPerformed(evt);
            }
        });
        menuReportes.add(itemReporteProducto);

        jMenuBar1.add(menuReportes);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInventarioActionPerformed

        gestionInventario = new GestionInventario();
        

    }//GEN-LAST:event_itemInventarioActionPerformed

    private void itemEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEmpleadosActionPerformed
        gestionEmpleado = new GestionEmpleado();
    }//GEN-LAST:event_itemEmpleadosActionPerformed

    private void itemVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVentasActionPerformed
        gestionDespachos = new GestionDespachos();
    }//GEN-LAST:event_itemVentasActionPerformed

    private void itemProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProveedoresActionPerformed
        gestionProveedores = new GestionProveedores();
    }//GEN-LAST:event_itemProveedoresActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?");
        if (opcion == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAcercaDeActionPerformed
        String informacion = "Sistema de inventario computadores y suministros\n";
        informacion += "                         ADVINSYS 2.0\n";
        informacion += "               Copyright ADVINSYS 2019\n";
        JOptionPane.showMessageDialog(null, informacion);
    }//GEN-LAST:event_itemAcercaDeActionPerformed

    private void itemReProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReProActionPerformed
        ReporteEmpleados e = new ReporteEmpleados();
        e.grafica();

    }//GEN-LAST:event_itemReProActionPerformed

    private void itemReporteProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReporteProductoActionPerformed
        ReporteProductos p = new ReporteProductos();
        p.grafica();
    }//GEN-LAST:event_itemReporteProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAcercaDe;
    private javax.swing.JMenuItem itemEmpleados;
    private javax.swing.JMenuItem itemInventario;
    private javax.swing.JMenuItem itemProveedores;
    private javax.swing.JMenuItem itemRePro;
    private javax.swing.JMenuItem itemReporteProducto;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemVentas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menuFunciones;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
