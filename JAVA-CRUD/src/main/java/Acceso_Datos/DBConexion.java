package Acceso_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConexion
{
     // CADENA DE CONEXION
    static String connectionUrl = "jdbc:sqlserver://localhost:1433;"
            + "database=JAVA_CRUD;"
            + "user=JAVA-CRUD;"
            + "password=12345;"
            + "loginTimeout=30;encrypt=false;trustServerCertificate=false";
    
    
    // DEBUELVE LA COEXION ABIERTA:
     public static Connection obtenerConexion() throws SQLException 
     {
        
        // Registra Driver Para Que Lo Reconozca El Servidor Wed
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        
        // Abre Conexion Con DB
        Connection connection = DriverManager.getConnection(connectionUrl); 
        return connection; // Conexion DB
    }
     
}
