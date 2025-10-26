/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lautisape
 */
public class Turno {
    private Integer id;
    private Integer id_Paciente;
    private Integer id_Medico;
    private String Fecha;
    private String Horario_Inicio;
    private String Horario_Fin;
    private String Observaciones;
    
    public Turno(){
        
    }
    
    public Turno(Integer id, Integer id_Paciente , Integer id_Medico,String Fecha ,String Horario_Inicio, String Horario_Fin, String observaciones){
        this.id = id;
        this.id_Paciente = id_Paciente;
        this.id_Medico = id_Medico;
        this.Fecha = Fecha;
        this.Horario_Inicio = Horario_Inicio;
        this.Horario_Fin = Horario_Fin;
        this.Observaciones = observaciones;
    }
    
        public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
        public Integer getId_Paciente() {
        return id_Paciente;
    }

    public void setId_Paciente(Integer id) {
        this.id = id_Paciente;
    }
    
        public Integer getId_Medico() {
        return id_Paciente;
    }

    public void setId_Medico(Integer id) {
        this.id = id_Medico;
    }

    public String getFecha(){
      return Fecha;
    }
    
    public void setFecha(String Fecha){
        this.Fecha = Fecha;
    }
    
    public String getHorario_Inicio(){
      return Horario_Inicio;
    }
    
    public void setHorario_Inicio(String Horario){
        this.Horario_Inicio = Horario;
    }
    
    
    public String getHorario_Fin(){
      return Horario_Fin;
    }
    
    public void setHorario_Fin(String Horario){
        this.Horario_Fin = Horario;
    }
    


    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.Observaciones = observaciones;
    }
    
        @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", Id_Paciente='" + id_Paciente + '\'' +
                ", id_Medico='" + id_Medico + '\'' +
                ", Fecha='" + Fecha + '\'' +
                ", Horario_Inicio='" + Horario_Inicio + '\'' +
                ", Horario_Fin='" + Horario_Fin + '\'' +
                ", observaciones='" + Observaciones + '\'' +
                '}';
    }
}
