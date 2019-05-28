/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advinsys.dao;

import advinsys.control.GestionProveedores;
import advinsys.entidad.Proveedor;
import advinsys.vista.UIAdminProveedores;
import advinsys.vista.UIAdminProveedoresModificar;
import advinsys.vista.UIProveedores;
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
public class ProveedorDAO {

    private Connection conexion = null;
    private Statement st = null;
    private ResultSet rs = null;
    private GestionProveedores gestionProveedores;

    public ProveedorDAO() {
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

    public List<Proveedor> getProveedores() {
        List<Proveedor> listaProveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setIdProveedor(rs.getString("id_proveedor"));
                p.setNombreProveedor(rs.getString("nombre_proveedor"));
                p.setNit(rs.getString("nit"));
                p.setTelefono(rs.getString("telefono"));
                p.setDireccion(rs.getString("direccion"));
                listaProveedores.add(p);

            }
            return listaProveedores;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean comprobarProveedor() {
        UIAdminProveedores p = new UIAdminProveedores(new javax.swing.JFrame(), true);
        String sql = "SELECT id_proveedor FROM proveedor WHERE id_proveedor='" + p.getIdProveedor() + "'";
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
        UIAdminProveedores p = new UIAdminProveedores(new javax.swing.JFrame(), true);
        PreparedStatement ps = null;
        String sql = "INSERT INTO proveedor (id_proveedor,nombre_proveedor,nit,telefono,direccion) VALUES (?,?,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);

            if (comprobarProveedor()) {
                JOptionPane.showMessageDialog(null, "ERROR,EL ID YA EXISTE");

            } else {
                ps.setString(1, p.getIdProveedor());
                ps.setString(2, p.getNombreP());
                ps.setString(3, p.getNit());
                ps.setDouble(4, p.getTelefono());
                ps.setString(5, p.getDireccion());
                ps.execute();
                JOptionPane.showMessageDialog(null, "REGISTRADO EXITOSAMENTE");
                gestionProveedores = new GestionProveedores();
                return true;

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

    public boolean modificar() {
        UIAdminProveedoresModificar ap = new UIAdminProveedoresModificar(new javax.swing.JFrame(), true);
        PreparedStatement ps;
        String sql = "UPDATE proveedor SET nombre_proveedor=?,nit=?,telefono=?,direccion=? WHERE id_proveedor='" + UIProveedores.getDato() + "'";
        try {

            ps = conexion.prepareStatement(sql);

            ps.setString(1, ap.getNombreP());
            ps.setString(2, ap.getNit());
            ps.setDouble(3, ap.getTelefono());
            ps.setString(4, ap.getDireccion());
            ps.execute();
            JOptionPane.showMessageDialog(null, "MODIFICADO EXITOSAMENTE");
            gestionProveedores = new GestionProveedores();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }
    
        public boolean eliminar() {
        PreparedStatement ps = null;
        String sql = "DELETE FROM proveedor WHERE id_proveedor='" + UIProveedores.getDato3() + "'";
        try {
            ps = conexion.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "ELIMINADO EXITOSAMENTE");
            gestionProveedores = new GestionProveedores();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
