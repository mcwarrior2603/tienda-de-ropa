package BaseDeDatos;

import Utilidades.ManejoDeErrores;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class SQLConnection {

    /**
     * Referencia que almacena la conexión a la base de datos,
     * si es que ya se a creado una
     */
    private volatile static Connection conexion = null;
    
    
    /**
     * Dirección del servidor al que se conectará
     */
    private static String host;
    /**
     * Puerto através del cual se conecta a la DB
     */
    private static String port;
    /**
     * Nombre de la base de datos en que se almacena la información
     */
    private static String dbName;    
    /**
     * Nombre de usuario con que se accede a la base de datos
     */
    private static String user = "tdr";
    /**
     * Contraseña con que se identifica el usuario para acceder a la DB
     */
    private static String password = "tdrFenixoft";
                      
    /**
     * No se podrán construir instancias de esta clase
     */
    private SQLConnection(){}
            
    /**
     * Método que carga la configuración de conexión al servidor (dirección
     * del servidor, puerto y nombre de la base de datos) desde el archivo 
     * en que se encuentra.
     * @return true si fue posible cargar la información sin ninún fallo,
     * false en caso contrario.
     */
    private static boolean cargarConfiguracion(){
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new FileReader("archivos/database.txt"));
            
            host = reader.readLine();
            port = reader.readLine();
            dbName = reader.readLine();
            
            return true;           
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se encuentra el archivo de información\n "
                            + "del servidor",
                    "Archivo de servidor: inexistente",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "El archivo de configuración de servidor no es válido", 
                    "Archivo de servidor: no válido", 
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    private static synchronized boolean conectar(){
        if(conexion != null)        
            return true;
        try {
            cargarConfiguracion();
            Class.forName("com.mysql.jdbc.Driver");
            conexion = conexion = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbName + 
                        "?user=" + user + "&password=" + password);
            System.out.println("Conexion establecida");
            return true;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se ha podido establecer la conexion a la base de datos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se ha podido establecer la conexion a la base de datos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            ManejoDeErrores.reportarError(ex);
        }
        return false;        
    }            
    
    public static boolean update(String sql){
        try {
            if(!conectar())
                return false;
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se pudieron insertar los datos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            ManejoDeErrores.reportarError(ex, sql);
        }
        return false;
    }
    
    public static ResultSet select(String sql) throws NullPointerException{
        try {
            if(!conectar())
                throw new NullPointerException();
            
            Statement st = conexion.createStatement();
            ResultSet result = st.executeQuery(sql);
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Error al realizar la consulta.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            ManejoDeErrores.reportarError(ex, sql);
        }
        throw new NullPointerException();
    }    
    
    public static void startTransaction(){
        try {
            if(!conectar())
                return;
            conexion.setAutoCommit(false);
        } catch (SQLException ex) {
            ManejoDeErrores.reportarError(ex);
        }
    }
    
    public static void commit(){
        try {
            if(!conectar())
                return;
            conexion.commit();
            conexion.setAutoCommit(true);
        } catch (SQLException ex) {
            ManejoDeErrores.reportarError(ex);
        }
    }
    
    public static void rollback(){
        try {
            if(!conectar())
                return;
            conexion.rollback();
            conexion.setAutoCommit(true);
        } catch (SQLException ex) {
            ManejoDeErrores.reportarError(ex);
        }
    }
}