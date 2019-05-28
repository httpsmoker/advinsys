package advinsys.dao;

import advinsys.entidad.Despachos;
import advinsys.vista.UIAdminInventarioDespachar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DespachosDAO {

    private Connection conexion = null;
    private Statement st = null;
    private ResultSet rs = null;

    public DespachosDAO() {
        conexion = UConnection.getConnection();
        try {
            st = conexion.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean consultaSQL(String sql) {
        try {
            conexion = UConnection.getConnection();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            return rs.first();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Despachos> getDespachos() {
        List<Despachos> listaDespachos = new ArrayList<>();
        String sql = "SELECT * FROM despachos";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Despachos d = new Despachos();
                d.setIdArticulo(rs.getString("id_articulo"));
                d.setIdEmpleado(rs.getString("id_empleado"));
                d.setCantidadDespacho(rs.getInt("cantidad_despachada"));
                d.setFechaDespacho(rs.getString("fecha_despacho"));

                listaDespachos.add(d);

            }
            return listaDespachos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean nuevo() {
        UIAdminInventarioDespachar ad = new UIAdminInventarioDespachar(new javax.swing.JFrame(), true);
        PreparedStatement ps;
        String sql = "INSERT INTO despachos (id_articulo,id_empleado,cantidad_despachada,fecha_despacho) VALUES (?,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);


                ps.setString(1, ad.getIdProducto());
                ps.setString(2, ad.getEmpleado());
                ps.setInt(3, ad.getCantidad());
                ps.setString(4, ad.getFecha());
                ps.execute();
                return true;


        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

}
