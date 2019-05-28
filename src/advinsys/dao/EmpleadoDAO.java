package advinsys.dao;

import advinsys.control.GestionEmpleado;
import advinsys.control.InterfaceEmpleados;
import advinsys.entidad.Empleados;
import advinsys.vista.UIAdminEmpleado;
import advinsys.vista.UIAdminEmpleadoModificar;
import advinsys.vista.UIEmpleados;
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
public class EmpleadoDAO {

    private Connection conexion = null;
    private Statement st = null;
    private ResultSet rs = null;
    private GestionEmpleado gestionEmpleado;
    private Empleados empleados;

    public EmpleadoDAO() {
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

    public boolean comprobarPermisos(Empleados empleados) {
        String sql = "SELECT funcion FROM empleados WHERE id_empleado='" + empleados.getIdEmpleado() + "'";
        if (consultaSQL(sql)) {
            try {

                if (rs.getString("funcion").equals("Administrador")) {
                    return true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;

    }

    public boolean comprobarEmpleado(Empleados empleados) {
        String sql = "SELECT password FROM empleados WHERE id_empleado='" + empleados.getIdEmpleado() + "'";
        if (consultaSQL(sql)) {
            try {
                String passwordEmpleadoObtenida = empleados.getPassword();
                String passwordEmpleadoReal = rs.getString("password");
                if (passwordEmpleadoObtenida.equals(passwordEmpleadoReal)) {
                    return true;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;

    }

    public boolean comprobarEmpleados() {
        UIAdminEmpleado ad = new UIAdminEmpleado(new javax.swing.JFrame(), true);
        String sql = "SELECT id_empleado FROM empleados WHERE id_empleado='" + ad.getId() + "'";
        if (consultaSQL(sql)) {
            try {

                return true;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;

    }

    public List<Empleados> getEmpleados() {
        List<Empleados> listaEmpleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Empleados e = new Empleados();
                e.setIdEmpleado(rs.getString("id_empleado"));
                e.setNombreEmpleado(rs.getString("nombre_empleado"));
                e.setApellidos(rs.getString("apellidos"));
                e.setDireccion(rs.getString("direccion"));
                e.setFechaNac(rs.getString("fecha_nac"));
                e.setFechaIngreso(rs.getString("fecha_ingreso"));
                e.setTelefono(rs.getString("telefono"));
                e.setFuncion(rs.getString("funcion"));
                e.setPassword(rs.getString("password"));
                listaEmpleados.add(e);

            }
            return listaEmpleados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean registrar() {
        UIAdminEmpleado ad = new UIAdminEmpleado(new javax.swing.JFrame(), true);
        PreparedStatement ps;
        String sql = "INSERT INTO empleados (id_empleado,nombre_empleado,apellidos,direccion,fecha_nac,fecha_ingreso,telefono,funcion,password) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);

            if (comprobarEmpleados()) {
                JOptionPane.showMessageDialog(null, "ERROR,EL ID YA EXISTE");

            } else {
                ps.setString(1, ad.getId());
                ps.setString(2, ad.getNombre());
                ps.setString(3, ad.getApellido());
                ps.setString(4, ad.getDireccion());
                ps.setString(5, ad.getFechaN());
                ps.setString(6, ad.getFechaI());
                ps.setDouble(7, ad.getTelefono());
                ps.setString(8, ad.getFuncion());
                ps.setString(9, ad.getContra());
                ps.execute();
                JOptionPane.showMessageDialog(null, "REGISTRADO EXITOSAMENTE");
                gestionEmpleado = new GestionEmpleado();
                return true;

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

    public boolean modificar() {
        UIAdminEmpleadoModificar ad = new UIAdminEmpleadoModificar(new javax.swing.JFrame(), true);
        PreparedStatement ps;
        String sql = "UPDATE empleados SET nombre_empleado=?,apellidos=?,direccion=?,fecha_nac=?,fecha_ingreso=?,telefono=?,funcion=?,password=? WHERE id_empleado='" + UIEmpleados.getDato() + "'";
        try {

            ps = conexion.prepareStatement(sql);

            ps.setString(1, ad.getNombre());
            ps.setString(2, ad.getApellido());
            ps.setString(3, ad.getDireccion());
            ps.setString(4, ad.getFechaN());
            ps.setString(5, ad.getFechaI());
            ps.setDouble(6, ad.getTelefono());
            ps.setString(7, ad.getFuncion());
            ps.setString(8, ad.getContra());
            ps.execute();
            JOptionPane.showMessageDialog(null, "MODIFICADO EXITOSAMENTE");
            gestionEmpleado = new GestionEmpleado();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

    public boolean eliminar() {
        PreparedStatement ps = null;
        String sql = "DELETE FROM empleados WHERE id_empleado='" + UIEmpleados.getDato3() + "'";
        try {
            ps = conexion.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "ELIMINADO EXITOSAMENTE");
            gestionEmpleado = new GestionEmpleado();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
