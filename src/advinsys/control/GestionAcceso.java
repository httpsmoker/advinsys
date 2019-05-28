package advinsys.control;

import advinsys.dao.EmpleadoDAO;
import advinsys.entidad.Empleados;
import advinsys.vista.UIAcceso;
import advinsys.vista.UIBienvenida;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class GestionAcceso implements InterfaceAcceso {

    private UIAcceso uiAcceso;
    private UIBienvenida uiBienvenida;
    private Empleados empleados;
    private EmpleadoDAO empleadoDAO;

    public GestionAcceso() {
        empleadoDAO = new EmpleadoDAO();
        uiAcceso = new UIAcceso(this);
        uiBienvenida = new UIBienvenida();
        empleados = new Empleados();

        GestionMain.uiPrincipal.getPanel().removeAll();
        GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
        GestionMain.uiPrincipal.getPanel().add(uiAcceso);
        GestionMain.uiPrincipal.bloquear();
        GestionMain.uiPrincipal.getPanel().updateUI();
        //Nombre del objeto --> ventana principal
        //Clse --> La clase que lo contenga.
    }

    @Override
    public List<Empleados> getListarEmpleados() {
        return empleadoDAO.getEmpleados();
    }

    @Override
    public void recibeEmpleados(String texto) {
        if (texto.length() > 0) {
            empleados.setIdEmpleado(texto);

        }

    }

    @Override
    public void recibirContrasenia(String texto) {
        if (texto.length() > 0) {
            empleados.setPassword(texto);

        }
    }

    @Override
    public void entrar() {
        if (!empleados.getIdEmpleado().equals("Sin Seleccionar")) {
            if (empleadoDAO.comprobarEmpleado(empleados)) {
                if (empleadoDAO.comprobarPermisos(empleados)) {
                    GestionMain.uiPrincipal.getPanel().removeAll();
                    GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
                    GestionMain.uiPrincipal.getPanel().add(uiBienvenida);
                    GestionMain.uiPrincipal.desbloquear2();
                    GestionMain.uiPrincipal.getPanel().updateUI();

                } else {
                    GestionMain.uiPrincipal.getPanel().removeAll();
                    GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
                    GestionMain.uiPrincipal.getPanel().add(uiBienvenida);
                    GestionMain.uiPrincipal.desbloquear1();
                    GestionMain.uiPrincipal.getPanel().updateUI();

                }

            } else {
                JOptionPane.showMessageDialog(null, "ERROR,DATOS INCORRECTOS");

            }

        }

    }

}
