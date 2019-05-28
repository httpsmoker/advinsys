
package advinsys.entidad;

/**
 *
 * @author PC
 */
public class Despachos {
    private String idArticulo;
    private String idEmpleado;
    private int cantidadDespacho;
    private String fechaDespacho;

    
    public Despachos(){
        
    }

    public Despachos(String idArticulo, String idEmpleado, int cantidadDespacho, String fechaDespacho) {
        this.idArticulo = idArticulo;
        this.idEmpleado = idEmpleado;
        this.cantidadDespacho = cantidadDespacho;
        this.fechaDespacho = fechaDespacho;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getCantidadDespacho() {
        return cantidadDespacho;
    }

    public void setCantidadDespacho(int cantidadDespacho) {
        this.cantidadDespacho = cantidadDespacho;
    }

    public String getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(String fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    @Override
    public String toString() {
        return "Despachos{" + "idArticulo=" + idArticulo + ", idEmpleado=" + idEmpleado + ", cantidadDespacho=" + cantidadDespacho + ", fechaDespacho=" + fechaDespacho + '}';
    }
    
        public String[] toArrayString() {
        return new String[]{
            idArticulo,
            idEmpleado,
            String.valueOf(cantidadDespacho),
            fechaDespacho
        };
    }
    
}
