package advinsys.control;

import advinsys.dao.DespachosDAO;
import advinsys.entidad.Despachos;
import advinsys.vista.UIBienvenida;
import advinsys.vista.UIDespachos;
import java.awt.FlowLayout;
import java.util.List;

/**
 *
 * @author PC
 */
public class GestionDespachos implements InterfaceDespachos {

    private UIDespachos uiDespachos;
    private UIBienvenida uiBienvenida;
    private Despachos despachos;
    private DespachosDAO despachosDAO;

    public GestionDespachos() {
        despachosDAO = new DespachosDAO();
        uiBienvenida = new UIBienvenida();
        uiDespachos = new UIDespachos(this);
        despachos = new Despachos();

        GestionMain.uiPrincipal.getPanel().removeAll();
        GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
        GestionMain.uiPrincipal.getPanel().add(uiDespachos);
        GestionMain.uiPrincipal.getPanel().updateUI();
        //Nombre del objeto --> ventana principal
        //Clse --> La clase que lo contenga.
    }

    @Override
    public List<Despachos> getListarDespachos() {
        return despachosDAO.getDespachos();
    }

    @Override
    public void inicio() {

        GestionMain.uiPrincipal.getPanel().removeAll();
        GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
        GestionMain.uiPrincipal.getPanel().add(uiBienvenida);
        GestionMain.uiPrincipal.getPanel().updateUI();

    }

}
