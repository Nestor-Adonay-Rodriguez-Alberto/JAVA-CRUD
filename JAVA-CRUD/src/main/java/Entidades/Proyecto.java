package Entidades;

import java.util.Date;


public class Proyecto 
{
    // ATRIBUTOS:
    private int ProyectoID;
    private String Nombre;
    private String Descripcion;
    private Date FechaInicio;
    private  Date FechaFin;
    
    // Referencia Tabla Empledo:
    private int EmpledoID;
    private Empleado Objeto_Empledo;
    
    
    // ACCESORS:

    public int getProyectoID() {
        return ProyectoID;
    }

    public void setProyectoID(int proyectoID) {
        this.ProyectoID = proyectoID;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }

    public int getEmpledoID() {
        return EmpledoID;
    }

    public void setEmpledoID(int EmpledoID) {
        this.EmpledoID = EmpledoID;
    }

    public Empleado getObjeto_Empledo() {
        return Objeto_Empledo;
    }

    public void setObjeto_Empledo(Empleado Objeto_Empledo) {
        this.Objeto_Empledo = Objeto_Empledo;
    }
    
    
    // CONSTRUCTOR:
    public Proyecto()
    {
        
    }
    
    // CONSTRUCTOR:
    public Proyecto(String nombre, String descripcion, Date fechainicio, Date fechafin, int empleadoID, Empleado objeto_empleado)
    {
        Nombre=nombre;
        Descripcion=descripcion;
        FechaInicio=fechainicio;
        FechaFin=fechafin;
        EmpledoID=empleadoID;
        Objeto_Empledo=objeto_empleado;
    }
}
