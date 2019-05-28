package advinsys.entidad;

/**
 *
 * @author PC
 */
public class Empleados {

    private String idEmpleado;
    private String nombreEmpleado;
    private String apellidos;
    private String direccion;
    private String fechaNac;
    private String fechaIngreso;
    private String telefono;
    private String funcion;
    private String password;

    public Empleados() {

    }

    public Empleados(String idEmpleado, String nombreEmpleado, String apellidos, String direccion, String fechaNac, String fechaIngreso, String telefono, String funcion, String password) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaNac = fechaNac;
        this.fechaIngreso = fechaIngreso;
        this.telefono = telefono;
        this.funcion = funcion;
        this.password = password;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Empleados{" + "idEmpleado=" + idEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", apellidos=" + apellidos + ", direccion=" + direccion + ", fechaNac=" + fechaNac + ", fechaIngreso=" + fechaIngreso + ", telefono=" + telefono + ", funcion=" + funcion + ", password=" + password + '}';
    }

    public String[] toArrayString() {
        return new String[]{
            idEmpleado,
            nombreEmpleado,
            apellidos,
            direccion,
            fechaNac,
            fechaIngreso,
            String.valueOf(telefono),
            funcion,
            password,
        };
    }

}
