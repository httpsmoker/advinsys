
package advinsys.control;

import advinsys.entidad.Articulo;
import java.util.List;

/**
 *
 * @author PC
 */
public interface InterfaceInventario {
    public List<Articulo> getListarArticulos();
    public void inicio();
    
}
