
package advinsys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 *
 * @author PC
 */
public class UConnection {
    private static Connection con = null;
    
    /**
     * Metodo estatico que sirve para realizar la conexion con la BD
     * @return devuelve la conexion
     */
    public static Connection getConnection(){
        try {
            if( con == null ){
                //con esto determinamos cuando finalice el programa
                Runtime.getRuntime().addShutdownHook( new MiShDwnHook() );
                
                ResourceBundle rb = ResourceBundle.getBundle( "jdbc" );
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String pwd = rb.getString("pwd");
                String usr = rb.getString("usr");
                
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, "");
            }
            
            return con;
            
        } catch ( Exception error ) {
            error.printStackTrace();
            throw new RuntimeException( "Error al crear la conexion" );
        }
    }
    
    /**
     * Metodo que sirve para finalizar con la conexion a la BD.
     */
    static class MiShDwnHook extends Thread {
        //justo antes de finalizar el programa la JVM invocará a este
        //método donde podemos cerrar la conexión
        public void run() {
            try {
                Connection con = UConnection.getConnection();
                con.close();
                System.err.println("YA TERMINE LA CONEXION CON LA BD");
            }
            catch ( Exception error ) {
                error.printStackTrace();
                throw new RuntimeException( error );
            }
        }
    }
    
}
