package Acceso_Datos;

import Entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAL {

    // RECIBE UN OBJETO Y LO REGISTRA EN LA DB:
    public static int Crear(Empleado empleado) {
        try (Connection conn = DBConexion.obtenerConexion()) {
            // Comando sql Para Crear:
            String sql = "INSERT INTO Empleados (Nombre, Apellido, Cargo, Salario, FechaContratacion) VALUES (?, ?, ?, ?, ?)";

            // Colocando Datos Al Comando sql:
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, empleado.getNombre());
                statement.setString(2, empleado.getApellido());
                statement.setString(3, empleado.getCargo());
                statement.setDouble(4, empleado.getSalario());

                java.util.Date fechaContratacionUtil = empleado.getFechaContratacion();
                java.sql.Date fechaContratacionSql = new java.sql.Date(fechaContratacionUtil.getTime());
                statement.setDate(5, fechaContratacionSql);

                // Ejecuto El Comando en La DB:
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } 
            catch (SQLException e) 
            {
                throw new RuntimeException("Error al crear el Empleado", e);
            }
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    
    // RECIBE UN OBJETO Y LO MODIFICA EN LA DB:
    public static int Editar(Empleado empleado) 
    {
        try (Connection conn = DBConexion.obtenerConexion()) 
        {
            // Comando sql Para Modificar:
            String sql = "UPDATE Empleados SET Nombre=?, Apellido=?, Cargo=?, Salario=?, FechaContratacion=? WHERE EmpleadoID=?";
           
            // Colocando Datos Al Comando sql:
            try (PreparedStatement statement = conn.prepareStatement(sql)) 
            {
                statement.setString(1, empleado.getNombre());
                statement.setString(2, empleado.getApellido());
                statement.setString(3, empleado.getCargo());
                statement.setDouble(4, empleado.getSalario());
                
                java.util.Date fechaContratacionUtil = empleado.getFechaContratacion();
                java.sql.Date fechaContratacionSql = new java.sql.Date(fechaContratacionUtil.getTime());
                statement.setDate(5, fechaContratacionSql);
                
                statement.setInt(6, empleado.getEmpleadoID());
                
                // Ejecuto El Comando en La DB:
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } 
            catch (SQLException e) 
            {
                throw new RuntimeException("Error al Editar el Empleado", e);
            }
        }
        catch (SQLException e) 
        {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    
    // RECIBE UN OBJETO Y LO ELIMINA DE LA DB:
    public static int Eliminar(Empleado empleado) 
    {
        try (Connection conn = DBConexion.obtenerConexion()) 
        {
            // Comando sql Para Eliminar:
            String sql = "DELETE FROM Empleados WHERE EmpleadoID=?";
            
            // Colocando Datos Al Comando sql:
            try (PreparedStatement statement = conn.prepareStatement(sql)) 
            {
                statement.setInt(1, empleado.getEmpleadoID());
                
                // Ejecuto El Comando en La DB:
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } 
            catch (SQLException e) 
            {
                throw new RuntimeException("Error al Eliminar el Empleado", e);
            }
        }
        catch (SQLException e) 
        {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    
    // RECIBE UN OBJETO LO BUSCA EN LA DB Y RETORNA TODOS LOS REGUISTRO IGUALES:
    public static ArrayList<Empleado> Buscar(Empleado empleado)
    {
        // Lista De Registros:
        ArrayList<Empleado> Lista_Empleados = new ArrayList<>();
        
        try (Connection conn = DBConexion.obtenerConexion()) 
        {
            // Comando sql Para Buscar:
            String sql = "SELECT p.EmpleadoID, p.Nombre, p.Apellido, p.Cargo, p.Salario, p.FechaContratacion FROM Empleados p";            
            sql+=" WHERE p.Nombre LIKE ? ";
            
            // Colocando Datos Al Comando sql:
            try (PreparedStatement statement = conn.prepareStatement(sql)) 
            {
                statement.setString(1, "%" + empleado.getNombre() + "%");
                
                // Registros Obtenidos:
                try (ResultSet resultSet = statement.executeQuery()) 
                {
                    while (resultSet.next()) 
                    {
                        // Objeto:
                        Empleado Objeto_Empleado = new Empleado();
                        
                        // Agregando Inf a los atributos:
                        Objeto_Empleado.setEmpleadoID(resultSet.getInt("EmpleadoID"));
                        Objeto_Empleado.setNombre(resultSet.getString("Nombre"));
                        Objeto_Empleado.setApellido(resultSet.getString("Apellido"));
                        Objeto_Empleado.setCargo(resultSet.getString("Cargo"));
                        Objeto_Empleado.setSalario(resultSet.getDouble("Salario"));                       
                        Objeto_Empleado.setFechaContratacion(resultSet.getDate("FechaContratacion"));
                                               
                        
                        // Agregando el Objeto A La Lista De Registros:
                        Lista_Empleados.add(Objeto_Empleado);
                    }
                }
            } 
            catch (SQLException e) 
            {
                throw new RuntimeException("Error al buscar Empleado", e);
            }
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        
        // Mandando al Form Los Refistros:
        return Lista_Empleados;
    }
    
    
    // OBTIENE TODOS LOS REGISTROS DE LA DB Y LOS RETORNA:
    public static ArrayList<Empleado> ObtenerTodos() 
    {
        // Lista De Registro De La DB:
        ArrayList<Empleado> Objetos_Obtenidos = new ArrayList<>();
        
        try (Connection conn = DBConexion.obtenerConexion()) 
        {
            // Comando Para Obtener Registros:
            String sql = "SELECT EmpleadoID, Nombre FROM Empleados";   
            
            try (PreparedStatement statement = conn.prepareStatement(sql)) 
            {            
                
                try (ResultSet resultSet = statement.executeQuery()) 
                {
                    while (resultSet.next()) 
                    {
                        // Obtenemos Los Atributos Del Registro Obtenido:
                        int empleadoID = resultSet.getInt("EmpleadoID");
                        String nombre = resultSet.getString("Nombre");
                          
                        
                        // Objeto Con los Atributos Obtenidos:
                        Empleado empleado = new Empleado();
                        empleado.setEmpleadoID(empleadoID);
                        empleado.setNombre(nombre);
                        
                        
                        // Agregamos a la Lista:
                        Objetos_Obtenidos.add(empleado);
                    }
                }
            } 
            catch (SQLException e) 
            {
                throw new RuntimeException("Error Al Obtener Los Empleados", e);
            }
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        
        // Mandamos Los Registros:
        return Objetos_Obtenidos;
    }
}
