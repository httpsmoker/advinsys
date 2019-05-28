package advinsys.control;

import advinsys.dao.ArticuloDAO;
import advinsys.entidad.Articulo;
import advinsys.vista.UIBienvenida;
import advinsys.vista.UIInventario;
import java.awt.FlowLayout;
import java.util.List;

/**
 *
 * @author PC
 */
public class GestionInventario implements InterfaceInventario {

    private UIInventario uiInventario;
    private UIBienvenida uiBienvenida;
    private Articulo articulo;
    private ArticuloDAO articuloDAO;

    public GestionInventario() {
        articuloDAO = new ArticuloDAO();
        uiBienvenida = new UIBienvenida();
        uiInventario = new UIInventario(this);
        articulo = new Articulo();

        GestionMain.uiPrincipal.getPanel().removeAll();
        GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
        GestionMain.uiPrincipal.getPanel().add(uiInventario);
        GestionMain.uiPrincipal.getPanel().updateUI();
        //Nombre del objeto --> ventana principal
        //Clse --> La clase que lo contenga.
    }

    @Override
    public List<Articulo> getListarArticulos() {
        return articuloDAO.getArticulos();
    }

    public void inicio() {
        GestionMain.uiPrincipal.getPanel().removeAll();
        GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
        GestionMain.uiPrincipal.getPanel().add(uiBienvenida);
        GestionMain.uiPrincipal.getPanel().updateUI();

    }

}
