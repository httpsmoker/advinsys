
package advinsys.control;

import advinsys.vista.UIPrincipal;
import javax.swing.UIManager;

/**
 *
 * @author PC
 */
public class GestionMain {
    public static UIPrincipal uiPrincipal;
    private GestionAcceso gestionAcceso;
    
    public GestionMain(){
        uiPrincipal = new UIPrincipal();
        gestionAcceso = new GestionAcceso();
    }
    
    public static void main (String args []){
        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        new GestionMain();
    }
}
