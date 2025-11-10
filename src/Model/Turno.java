/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author lautisape
 */
public class Turno {
    private Integer id;
    private Integer id_Paciente;
    private Integer id_Medico;
    private LocalDate Fecha;
    private LocalTime Hora;
    private int Duracion;
    private String Estado;
    
    //[NotMapped]
    private String Paciente;
    //[NotMapped]
    private String Medico;
    
    public Turno(){
        
    }
    
    public Turno(Integer id, Integer id_Paciente , Integer id_Medico,LocalDate Fecha ,LocalTime Hora, int Duracion, String Estado){
        this.id = id;
        this.id_Paciente = id_Paciente;
        this.id_Medico = id_Medico;
        this.Fecha = Fecha;
        this.Hora= Hora;
        this.Duracion = Duracion;
        this.Estado = Estado;
    }
    
    public Integer getId() { return id;  }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getId_Paciente() { return id_Paciente;  }
    public void setId_Paciente(Integer id) { this.id_Paciente = id;   }
    
    public Integer getId_Medico() { return id_Medico;  }
    public void setId_Medico(Integer id) { this.id_Medico = id;  }

    public LocalDate getFecha(){  return Fecha;   }
    public void setFecha(LocalDate Fecha){ this.Fecha = Fecha;   }
    
    public LocalTime getHora(){ return Hora;  }
    public void setHora(LocalTime Horario){  this.Hora = Horario;  }
    
    public int getDuracion(){   return Duracion;  }
    public void setDuracion(int Duracion){ this.Duracion = Duracion; }
    
    public String getEstado() { return Estado;  }
    public void setEstado(String Estado) {   this.Estado = Estado;   }
    
    public String getPaciente() { return Paciente; }
    public void setPaciente(String paciente) { this.Paciente = paciente; }
       
    public String getMedico() { return Medico; }
    public void setMedico(String medico) { this.Medico = medico; }
    
        @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", Id_Paciente='" + id_Paciente + '\'' +
                ", id_Medico='" + id_Medico + '\'' +
                ", Fecha='" + Fecha + '\'' +
                ", Hora='" + Hora + '\'' +
                ", Duracion='" + Duracion + '\'' +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
