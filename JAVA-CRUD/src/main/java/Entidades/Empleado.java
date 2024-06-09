package Entidades;

import java.util.Date;


public class Empleado 
{
    // ATRIBUTOS:
    private int EmpleadoID;
    private String Nombre;
    private String Apellido;
    private String Cargo;
    private Double Salario;
    private Date FechaContratacion;

    // ACCESORS:
    
    public int getEmpleadoID() {
        return EmpleadoID;
    }

    
    public void setEmpleadoID(int EmpleadoID) {
        this.EmpleadoID = EmpleadoID;
    }

    
    public String getNombre() {
        return Nombre;
    }

    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    
    public String getApellido() {
        return Apellido;
    }

    
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    
    public String getCargo() {
        return Cargo;
    }

    
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    
    public Double getSalario() {
        return Salario;
    }

    
    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }

    
    public Date getFechaContratacion() {
        return FechaContratacion;
    }

    
    public void setFechaContratacion(Date FechaContratacion) {
        this.FechaContratacion = FechaContratacion;
    }
    
    // CONSTRUCTOR:
    public Empleado()
    {
        
    }
    
    // CONSTRUCTOR:
    public  Empleado(String nombre, String apellido, String cargo, Double salario, Date fechacontratacion)
    {
        Nombre=nombre;
        Apellido=apellido;
        Cargo=cargo;
        Salario=salario;
        FechaContratacion=fechacontratacion;
    }
    
    // PARA COMBO
    @Override
    public String toString() {
        return Nombre;
    }
}
