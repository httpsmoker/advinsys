package advinsys.control;

import advinsys.dao.EmpleadoDAO;
import advinsys.entidad.Empleados;
import advinsys.vista.UIBienvenida;
import advinsys.vista.UIEmpleados;
import java.awt.FlowLayout;
import java.util.List;

/**
 *
 * @author PC
 */
public class GestionEmpleado implements InterfaceEmpleados {

    private UIEmpleados uiEmpleados;
    private UIBienvenida uiBienvenida;
    private Empleados empleados;
    private EmpleadoDAO empleadoDAO;

    @Override
    public List<Empleados> getListarEmpleados() {
        return empleadoDAO.getEmpleados();
    }

    public GestionEmpleado() {
        empleadoDAO = new EmpleadoDAO();
        uiBienvenida = new UIBienvenida();
        uiEmpleados = new UIEmpleados(this);
        empleados = new Empleados();

        GestionMain.uiPrincipal.getPanel().removeAll();
        GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
        GestionMain.uiPrincipal.getPanel().add(uiEmpleados);
        GestionMain.uiPrincipal.getPanel().updateUI();
        //Nombre del objeto --> ventana principal
        //Clse --> La clase que lo contenga.
    }

    @Override
    public void inicio() {
        GestionMain.uiPrincipal.getPanel().removeAll();
        GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
        GestionMain.uiPrincipal.getPanel().add(uiBienvenida);
        GestionMain.uiPrincipal.getPanel().updateUI();

    }

    @Override
    public void recibeIdEmpleado(String texto) {
        if (texto.length() > 0) {
            empleados.setIdEmpleado(texto);

        }

    }

    @Override
    public void recibeSeleccion(String text) {
        String dato = text;

    }

}
