package Acceso_Datos;

import Entidades.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProyectoDAL 
{
    // RECIBE UN OBJETO Y LO REGISTRA EN LA DB:
    public static int Crear(Proyecto proyecto) 
    {
        
        try (Connection conn = DBConexion.obtenerConexion()) 
        {
            // Comando sql Para Crear:
            String sql = "INSERT INTO Proyectos (Nombre, Descripcion, FechaInicio, FechaFin, EmpleadoID) VALUES (?, ?, ?, ?, ?)";

            // Colocando Datos Al Comando sql:
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, proyecto.getNombre());
                statement.setString(2, proyecto.getDescripcion());
                
                java.util.Date fechaInicioUtil = proyecto.getFechaInicio();
                java.sql.Date fechaInicioSql = new java.sql.Date(fechaInicioUtil.getTime());
                statement.setDate(3, fechaInicioSql);
                
                java.util.Date fechaFinUtil = proyecto.getFechaFin();
                java.sql.Date fechaFinSql = new java.sql.Date(fechaFinUtil.getTime());
                statement.setDate(4, fechaFinSql);
                
                statement.setInt(5, proyecto.getEmpledoID());

                // Ejecuto El Comando en La DB:
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } 
            catch (SQLException e) 
            {
                throw new RuntimeException("Error al crear el Proyecto", e);
            }
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    
}
