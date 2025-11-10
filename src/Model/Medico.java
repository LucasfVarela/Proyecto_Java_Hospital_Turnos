/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalTime;

/**
 *
 * @author lautaro
 */
public class Medico {
    private Integer Id;
    private String Nombre;
    private String Apellido;
    private String Nro_Documento;
    private String Especialidad;
    private String Telefono;
    private String Email;
    private LocalTime Horario_Desde;
    private LocalTime Horario_Hasta;
    
    
    
    public Medico(){
    }
    
    public Medico(Integer id, String nombre, String apellido, String Nro_Documento,String especialidad, String telefono,String Email, LocalTime Horario_Desde, LocalTime Horario_Hasta){
        this.Id = id;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Nro_Documento = Nro_Documento;
        this.Especialidad = especialidad;
        this.Telefono = telefono;
        this.Email = Email;
        this.Horario_Desde = Horario_Desde;
        this.Horario_Hasta = Horario_Hasta;
    }
    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }
     public String getNro_Documento(){
        return Nro_Documento;
    }
    
    public void setNro_Documento(String Nro_Documento){
        this.Nro_Documento = Nro_Documento;
    }
    public String getEspecialidad(){
        return Especialidad;
    }
    
    public void setEsPecialidad(String especialidad){
        this.Especialidad = especialidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }


    public LocalTime getHorario_Desde() {
        
        return Horario_Desde;
    }

    public void setHorario_Desde(LocalTime horarios) {
        this.Horario_Desde = horarios;
    }
    public LocalTime getHorario_Hasta() {
        return Horario_Hasta;
    }

    public void setHorario_Hasta(LocalTime horarios) {
        this.Horario_Hasta = horarios;
    }
    
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + Id +
                ", nombre='" + Nombre + '\'' +
                ", apellido='" + Apellido + '\'' +
                ", numeroDocumento='" + Nro_Documento + '\'' +
                ", telefono='" + Telefono + '\'' +
                ", Email='" + Email + '\'' +
                ", Horario_Desde='" + Horario_Desde + '\'' +
                ", Horario_Hasta='" + Horario_Hasta + '\'' +
                '}';
    }
}
