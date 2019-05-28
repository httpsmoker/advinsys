/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advinsys.control;

import advinsys.entidad.Empleados;
import java.util.List;

/**
 *
 * @author PC
 */
public interface InterfaceEmpleados {
    
    public List<Empleados> getListarEmpleados();
    public void inicio();
    public void recibeIdEmpleado(String texto);
    public void recibeSeleccion(String texto);
    
}
