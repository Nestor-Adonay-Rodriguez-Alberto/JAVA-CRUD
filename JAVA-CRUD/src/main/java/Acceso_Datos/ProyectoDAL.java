package Acceso_Datos;

import Entidades.Empleado;
import Entidades.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProyectoDAL {

    // RECIBE UN OBJETO Y LO REGISTRA EN LA DB:
    public static int Crear(Proyecto proyecto) {

        try (Connection conn = DBConexion.obtenerConexion()) {
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
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el Proyecto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    // RECIBE UN OBJETO Y LO ELIMINA DE LA DB:
    public static int Eliminar(Proyecto proyecto) 
    {
        try (Connection conn = DBConexion.obtenerConexion()) 
        {
            // Comando sql Para Eliminar:
            String sql = "DELETE FROM Proyectos WHERE ProyectoID=?";
            
            // Colocando Datos Al Comando sql:
            try (PreparedStatement statement = conn.prepareStatement(sql)) 
            {
                statement.setInt(1, proyecto.getProyectoID());
                
                // Ejecuto El Comando en La DB:
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } 
            catch (SQLException e) 
            {
                throw new RuntimeException("Error al Eliminar el Proyecto", e);
            }
        }
        catch (SQLException e) 
        {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    
    // RECIBE UN OBJETO LO BUSCA EN LA DB Y RETORNA TODOS LOS REGUISTRO IGUALES:
    public static ArrayList<Proyecto> Buscar(Proyecto proyecto) {
        // Lista De Registros:
        ArrayList<Proyecto> Objetos_Obtenidos = new ArrayList<>();

        try (Connection conn = DBConexion.obtenerConexion()) {
            // Comando sql Para Buscar:
            String sql = "SELECT p.ProyectoID, p.Nombre, p.Descripcion, p.FechaInicio, p.FechaFin, p.EmpleadoID, c.Nombre AS NombreEmpleado, c.Apellido AS ApellidoEmpleado FROM Proyectos p";
            sql += " INNER JOIN Empleados c ON c.EmpleadoID= p.EmpleadoID  ";
            sql += " WHERE p.Nombre LIKE ? ";

            // Colocando Datos Al Comando sql:
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, "%" + proyecto.getNombre() + "%");

                // Registros Obtenidos:
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        // Objeto:
                        Proyecto Objeto_Proyecto = new Proyecto();

                        // Agregando Inf a los atributos:
                        Objeto_Proyecto.setProyectoID(resultSet.getInt("ProyectoID"));
                        Objeto_Proyecto.setNombre(resultSet.getString("Nombre"));
                        Objeto_Proyecto.setDescripcion(resultSet.getString("Descripcion"));
                        Objeto_Proyecto.setFechaInicio(resultSet.getDate("FechaInicio"));
                        Objeto_Proyecto.setFechaFin(resultSet.getDate("FechaFin"));
                        Objeto_Proyecto.setEmpledoID(resultSet.getInt("EmpleadoID"));
                        
                        Empleado empleado = new Empleado();
                        empleado.setNombre(resultSet.getString("NombreEmpleado"));
                        empleado.setApellido(resultSet.getString("ApellidoEmpleado"));
                        Objeto_Proyecto.setObjeto_Empledo(empleado);

                        // Agregando el Objeto A La Lista De Registros:
                        Objetos_Obtenidos.add(Objeto_Proyecto);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al buscar El Proyecto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }

        // Mandando al Form Los Refistros:
        return Objetos_Obtenidos;
    }
}
