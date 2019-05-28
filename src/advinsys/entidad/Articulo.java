
package advinsys.entidad;

/**
 *
 * @author PC
 */
public class Articulo {
    private String idArticulo;
    private String descripcion;
    private String idProveedor;
    private double precio;
    private int cantidad;
    
    public Articulo(){
        
    }

    public Articulo(String idArticulo, String descripcion, String idProveedor, double precio, int cantidad) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.idProveedor = idProveedor;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Articulo{" + "idArticulo=" + idArticulo + ", descripcion=" + descripcion + ", idProveedor=" + idProveedor + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }
    
    public String[] toArrayString(){
        return new String []{
            idArticulo,
            descripcion,
            "$" + String.valueOf(precio),
            String.valueOf(cantidad)
        };
    }
}
