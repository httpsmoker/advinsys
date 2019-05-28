
package advinsys.control;

import advinsys.vista.UIBienvenida;
import advinsys.vista.UIReportes;
import java.awt.FlowLayout;

/**
 *
 * @author PC
 */
public class GestionReportes {
    private UIReportes uiReportes;
    private UIBienvenida uiBienvenida;

    
    public GestionReportes() {

        uiBienvenida = new UIBienvenida();
        uiReportes = new UIReportes();
        
        
        GestionMain.uiPrincipal.getPanel().removeAll();
        GestionMain.uiPrincipal.getPanel().setLayout(new FlowLayout());
        GestionMain.uiPrincipal.getPanel().add(uiReportes);
        GestionMain.uiPrincipal.getPanel().updateUI();
        //Nombre del objeto --> ventana principal
        //Clse --> La clase que lo contenga.
    }
    
}
