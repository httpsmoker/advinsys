
package advinsys.control;

import advinsys.entidad.Empleados;
import java.util.List;

/**
 *
 * @author PC
 */
public interface InterfaceAcceso {
     
    public List<Empleados> getListarEmpleados();
    
    public void recibeEmpleados(String texto);
    
    public void recibirContrasenia(String texto);
    
    public void entrar();
}
