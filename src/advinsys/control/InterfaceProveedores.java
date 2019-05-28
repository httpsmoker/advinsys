package advinsys.control;

import advinsys.entidad.Proveedor;
import java.util.List;

/**
 *
 * @author PC
 */
public interface InterfaceProveedores {

    public List<Proveedor> getListarProveedores();

    public void inicio();

    public void recibeProveedores(String texto);


}
