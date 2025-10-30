package Controllers;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import DAO.GenericDAOImpl;
import Model.Turno;
import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class TurnosController extends GenericDAOImpl<Turno, Integer> {
    
    public Turno _Model = new Turno();
    
    public  TurnosController()
    {
        
    }
    
    
    public void Load(Turno turno)
    {
        
        _Model.setId(turno.getId());
        _Model.setId_Paciente(turno.getId_Paciente());
        _Model.setId_Medico(turno.getId_Medico());
        _Model.setObservaciones(turno.getObservaciones());
        _Model.setFecha(turno.getFecha());
        _Model.setHorario_Inicio(turno.getHorario_Inicio());
        _Model.setHorario_Fin(turno.getHorario_Fin());
        
    }
    @Override
    protected String getTableName() {
        return "Turno";
    }
    
    
  /*  @Override
    protected String getInsertSQL() {
        return "INSERT INTO Paciente (Nombre, Apellido, Nro_Documento, Telefono, Email, Fecha_Nacimiento) " +
               "VALUES ("+_Model.getNombre() +", "+_Model.getApellido() +","+_Model.getNumeroDocumento()+", "+_Model.getTelefono() +", "+_Model.getEmail() +", "+_Model.getFechaNacimiento() +")";
    }*/
    
      @Override
         protected String getInsertSQL() {
        return "INSERT INTO Turno (Id_Medico, Id_Paciente, Observaciones, Fecha, Horario_Desde,Horario_Hasta)  VALUES ("+_Model.getId_Medico()+",'"+_Model.getId_Paciente()+"','"+_Model.getObservaciones()+"',CONVERT(DATE,'"+_Model.getFecha()+"',103),CONVERT(DATE,'"+_Model.getHorario_Inicio()+"',103),CONVERT(DATE,'"+_Model.getHorario_Fin()+"',103),'";
    }
    /*protected String getInsertSQL() {
        return "INSERT INTO Paciente VALUES ('"+_Model.getNombre()+"','"+_Model.getApellido()+"','"+_Model.getNumeroDocumento()+"','"+_Model.getTelefono()+"','"+_Model.getEmail()+"',"+_Model.getFechaNacimiento()+",'"+ _Model.getSexo()+"')";
    }*/
    
    
    @Override
    protected String getUpdateSQL() {
        return "UPDATE Turno SET Id_Medico = '"+_Model.getId_Medico()+"', Id_Paciente = '"+_Model.getId_Paciente()+"', Fecha =CONVERT(DATE,'"+_Model.getFecha()+"',103), " +
               "Horario_Desde =CONVERT(DATE, '"+_Model.getHorario_Inicio()+"',103), Horario_Hasta = CONVERT(DATE,'"+_Model.getHorario_Fin()+"',103), Observaciones = "+_Model.getObservaciones()+"";
    }
    
    /*@Override
    protected void setInsertParameters(PreparedStatement stmt, Turno turno) throws SQLException {
        stmt.setString(1, turno.getNombre());
        stmt.setString(2, turno.getApellido());
        stmt.setString(3, turno.getNumeroDocumento());
        stmt.setString(4, turno.getTelefono());
        stmt.setString(5, turno.getEmail());
        
        // Convertir LocalDate a java.sql.Date
        if (paciente.getFechaNacimiento() != null) {
            stmt.setDate(6, Date.valueOf(paciente.getFechaNacimiento()));
        } else {
            stmt.setNull(6, java.sql.Types.DATE);
        }
    }*/
    
    @Override
    protected void setUpdateParameters(PreparedStatement stmt, Turno turno) throws SQLException {
        setInsertParameters(stmt, turno);
        stmt.setInt(7, turno.getId());
    }
    
    @Override
    protected Turno mapResultSetToEntity(ResultSet rs) throws SQLException {
        Turno turno = new Turno();
        turno.setId(rs.getInt("Id"));
        turno.setId_Paciente(rs.getInt("Id_Paciente"));
        turno.setId_Medico(rs.getInt("Id_Medico"));
        turno.setObservaciones(rs.getString("Observaciones"));
        turno.setFecha(rs.getString("Fecha").toString());
        turno.setHorario_Inicio(rs.getString("Horario_Inicio").toString());
        turno.setHorario_Fin(rs.getString("Horario_Fin").toString());
        
     
        return turno;
    }
    
    @Override
    protected Integer getEntityId(Turno Turno) {
        return Turno.getId();
    }
    
    public Turno GetModel(){
        
        return _Model;
    }

    @Override
    protected void setInsertParameters(PreparedStatement stmt, Turno entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    

    
}
