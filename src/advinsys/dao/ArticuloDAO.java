/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advinsys.dao;

import advinsys.control.GestionInventario;
import advinsys.entidad.Articulo;
import advinsys.vista.UIAdminInventario;
import advinsys.vista.UIAdminInventarioDespachar;
import advinsys.vista.UIAdminInventarioModificar;
import advinsys.vista.UIInventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ArticuloDAO {

    private Connection conexion = null;
    private Statement st = null;
    private ResultSet rs = null;
    private GestionInventario gestionInventario;

    public ArticuloDAO() {
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

    public List<Articulo> getArticulos() {
        List<Articulo> listaArticulos = new ArrayList<>();
        String sql = "SELECT * FROM articulo";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Articulo a = new Articulo();
                a.setIdArticulo(rs.getString("id_articulo"));
                a.setDescripcion(rs.getString("descripcion"));
                a.setIdProveedor(rs.getString("id_proveedor"));
                a.setPrecio(rs.getDouble("precio"));
                a.setCantidad(rs.getInt("cantidad"));

                listaArticulos.add(a);

            }
            return listaArticulos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean comprobarArticulos() {
        UIAdminInventario i = new UIAdminInventario(new javax.swing.JFrame(), true);
        String sql = "SELECT id_articulo FROM articulo WHERE id_articulo='" + i.getIdProducto() + "'";
        if (consultaSQL(sql)) {
            try {

                return true;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;

    }

    public boolean registrar() {
        UIAdminInventario i = new UIAdminInventario(new javax.swing.JFrame(), true);
        PreparedStatement ps = null;
        String sql = "INSERT INTO articulo (id_articulo,descripcion,id_proveedor,precio,cantidad) VALUES (?,?,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);

            if (comprobarArticulos()) {
                JOptionPane.showMessageDialog(null, "ERROR,EL ID YA EXISTE");

            } else {
                ps.setString(1, i.getIdProducto());
                ps.setString(2, i.getDescripcion());
                ps.setString(3, i.getProveedor());
                ps.setDouble(4, i.getPrecio());
                ps.setInt(5, i.getCantidad());
                ps.execute();
                JOptionPane.showMessageDialog(null, "REGISTRADO EXITOSAMENTE");
                gestionInventario = new GestionInventario();
                return true;

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

    public boolean modificar() {
        UIAdminInventarioModificar ai = new UIAdminInventarioModificar(new javax.swing.JFrame(), true);
        PreparedStatement ps;
        String sql = "UPDATE articulo SET descripcion=?,id_proveedor=?,precio=? WHERE id_articulo='" + UIInventario.getDato() + "'";
        try {

            ps = conexion.prepareStatement(sql);

            ps.setString(1, ai.getDescripcion());
            ps.setString(2, ai.getProveedor());
            ps.setDouble(3, ai.getPrecio());
            ps.execute();
            JOptionPane.showMessageDialog(null, "MODIFICADO EXITOSAMENTE");
            gestionInventario = new GestionInventario();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

    public boolean eliminar() {
        PreparedStatement ps = null;
        String sql = "DELETE FROM articulo WHERE id_articulo='" + UIInventario.getDato3() + "'";
        try {
            ps = conexion.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "ELIMINADO EXITOSAMENTE");
            gestionInventario = new GestionInventario();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean despacho() {
        UIAdminInventarioDespachar ad = new UIAdminInventarioDespachar(new javax.swing.JFrame(), true);
        PreparedStatement ps;
        String sql = "UPDATE articulo SET cantidad=? WHERE id_articulo='" + UIInventario.getDato4() + "'";
        try {

            ps = conexion.prepareStatement(sql);

            ps.setInt(1, ad.getCantidad3());
            ps.execute();
            JOptionPane.showMessageDialog(null, "DESPACHADO EXITOSAMENTE");
            gestionInventario = new GestionInventario();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

    public boolean agrega() {
        PreparedStatement ps;
        String sql = "UPDATE articulo SET cantidad=? WHERE id_articulo='" + UIInventario.getDato6() + "'";
        try {

            ps = conexion.prepareStatement(sql);

            ps.setInt(1, UIInventario.getCantidad3());
            ps.execute();
            JOptionPane.showMessageDialog(null, "AGREGADO EXITOSAMENTE");
            gestionInventario = new GestionInventario();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

}
