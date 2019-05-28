/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advinsys.vista;

import advinsys.control.InterfaceAcceso;
import advinsys.entidad.Empleados;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class UIAcceso extends javax.swing.JPanel {

    private InterfaceAcceso interAcceso;
    private static String datoId;

    public UIAcceso(InterfaceAcceso interAcceso) {
        initComponents();
        this.interAcceso = interAcceso;
        cargarEmpleados();
    }

    public void cargarEmpleados() {
        List<Empleados> listaEmpleados = interAcceso.getListarEmpleados();
        if (listaEmpleados != null) {
            int size = listaEmpleados.size();
            for (int i = 0; i < size; i++) {
                cbUsuario.addItem(listaEmpleados.get(i).getIdEmpleado());

            }

        }
    }
    
    
    
    

    public void seleccionando() {
        if (cbUsuario.getSelectedIndex() != 0) {
            interAcceso.recibeEmpleados("" + cbUsuario.getSelectedItem());

        } else {
            interAcceso.recibeEmpleados("Sin Seleccionar");
        }
    }
    
    public void limpiar(){
        pwdContra.setText("");
        cbUsuario.setSelectedIndex(0);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbUsuario = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        pwdContra = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1130, 675));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("USUARIO:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, -1));

        cbUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin Seleccionar" }));
        cbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUsuarioActionPerformed(evt);
            }
        });
        add(cbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 231, 33));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("CONTRASEÑA:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, -1, -1));

        pwdContra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                pwdContraCaretUpdate(evt);
            }
        });
        pwdContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdContraActionPerformed(evt);
            }
        });
        pwdContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwdContraKeyTyped(evt);
            }
        });
        add(pwdContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 230, 34));

        btnEntrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/entrar.png"))); // NOI18N
        btnEntrar.setText("ENTRAR");
        btnEntrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/entrar (1).png"))); // NOI18N
        btnEntrar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/entrar (1).png"))); // NOI18N
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 550, -1, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/advinsys/imagenes/Sin título-1.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 290, 270));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        String contrasena = new String(pwdContra.getPassword());
        if (cbUsuario.getSelectedIndex() == 0 || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR, INFORMACION DE ACCESO INCOMPLETA");

        } else {
            datoId = cbUsuario.getSelectedItem().toString();
            interAcceso.entrar();
            limpiar();

        }

    }//GEN-LAST:event_btnEntrarActionPerformed

    public static String getDatoId() {
        return datoId;
    }

    private void pwdContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdContraActionPerformed

    private void pwdContraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_pwdContraCaretUpdate
        String contrasena = new String(pwdContra.getPassword());
        interAcceso.recibirContrasenia(contrasena);
    }//GEN-LAST:event_pwdContraCaretUpdate

    private void cbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUsuarioActionPerformed
        seleccionando();
    }//GEN-LAST:event_cbUsuarioActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    private void pwdContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdContraKeyTyped
        char enter = evt.getKeyChar();

        if (enter == KeyEvent.VK_ENTER) {

            btnEntrar.doClick();
        }
    }//GEN-LAST:event_pwdContraKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JComboBox<String> cbUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pwdContra;
    // End of variables declaration//GEN-END:variables
}
