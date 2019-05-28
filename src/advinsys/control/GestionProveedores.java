package advinsys.control;

import advinsys.dao.ProveedorDAO;
import advinsys.entidad.Proveedor;
import advinsys.vista.UIBienvenida;
import advinsys.vista.UIProveedores;
import java.awt.FlowLayout;
import java.util.List;

/**
 *
 * @author PC
 */
public class GestionProveedores implements InterfaceProveedores {

    private UIProveedores uiProveedores;
    private UIBienvenida uiBienvenida;
    private Proveedor proveedor;
    private ProveedorDAO proveedorDAO;

    @Override
    public List<Proveedor> getListarProveedores() {
        return proveedorDAO.getProveedores();
    }

    @Override
    public void recibeProveedores(String texto) {
        if (texto.length() > 0) {
            proveedor.setIdProveedor(texto);

        }

    }

    public GestionProveedores() {
        proveedorDAO = new ProveedorDAO();
        uiBienvenida = new UIBienvenida();
        uiProveedores = new UIProveedores(this);
        proveedor = new Proveedor();

        GestionMain.uiPrincipal.getPanel().removeAll();
        GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
        GestionMain.uiPrincipal.getPanel().add(uiProveedores);
        GestionMain.uiPrincipal.getPanel().updateUI();
        //Nombre del objeto --> ventana principal
        //Clse --> La clase que lo contenga.
    }

    public void inicio() {
        GestionMain.uiPrincipal.getPanel().removeAll();
        GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
        GestionMain.uiPrincipal.getPanel().add(uiBienvenida);
        GestionMain.uiPrincipal.getPanel().updateUI();

    }

}
