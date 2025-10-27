package Controllers;

import Model.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import DAO.GenericDAOImpl;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicoController extends GenericDAOImpl<Medico, Integer> {
    
    public Medico _Model = new Medico();
    
    public MedicoController()
    {
        
    }
    
    
    public void Load(Medico Medico)
    {
        
        _Model.setId(Medico.getId());
        _Model.setNombre(Medico.getNombre());
        _Model.setApellido(Medico.getApellido());
        _Model.setNro_Documento(Medico.getNro_Documento());
        _Model.setTelefono(Medico.getTelefono());
        _Model.setEmail(Medico.getEmail());
        _Model.setEsPecialidad(Medico.getEspecialidad());
        _Model.setHorario_Desde(Medico.getHorario_Desde());
        _Model.setHorario_Hasta(Medico.getHorario_Hasta());
    }
    @Override
    protected String getTableName() {
        return "Medico";
    }
    
    
  /*  @Override
    protected String getInsertSQL() {
        return "INSERT INTO Medico (Nombre, Apellido, Nro_Documento, Telefono, Email, Especialidad, Horario_Desde, Horario_Hasta) " +
               "VALUES ("+_Model.getNombre() +", "+_Model.getApellido() +","+_Model.getNro_Documento()+", "+_Model.getTelefono() +", "+_Model.getEmail() +", "+_Model.getEspecialidad() +", "+_Model.getHorario_Desde() +", "+_Model.getHorario_Hasta() +")";
    }*/
    
      @Override
         protected String getInsertSQL() {
        return "INSERT INTO Medico (Nombre, Apellido, Nro_Documento, Telefono, Email, Especialidad, Horario_Desde, Horario_Hasta) VALUES ('"+_Model.getNombre()+"','"+_Model.getApellido()+"','"+_Model.getNro_Documento()+"','"+_Model.getTelefono()+"','"+_Model.getEmail()+"','"+_Model.getEspecialidad()+"','"+_Model.getHorario_Desde()+"','"+_Model.getHorario_Hasta()+"')";
    }
    /*protected String getInsertSQL() {
        return "INSERT INTO Medico VALUES ('"+_Model.getNombre()+"','"+_Model.getApellido()+"','"+_Model.getNro_Documento()+"','"+_Model.getTelefono()+"','"+_Model.getEmail()+"','"+_Model.getEspecialidad()+"','"+_Model.getHorario_Desde()+"','"+_Model.getHorario_Hasta()+"')";
    }*/
    
    
    @Override
    protected String getUpdateSQL() {
        return "UPDATE Medico SET Nombre = '"+_Model.getNombre()+"', Apellido = '"+_Model.getApellido()+"', Nro_Documento = '"+_Model.getNro_Documento()+"', " +
               "Telefono = '"+_Model.getTelefono()+"', Email = '"+_Model.getEmail()+"', Especialidad = '"+_Model.getEspecialidad()+"', Horario_Desde = '"+_Model.getHorario_Desde()+"', Horario_Hasta = '"+_Model.getHorario_Hasta()+"' WHERE Id = "+_Model.getId()+"";
    }
    
    @Override
    protected void setInsertParameters(PreparedStatement stmt, Medico medico) throws SQLException {
        stmt.setString(1, medico.getNombre());
        stmt.setString(2, medico.getApellido());
        stmt.setString(3, medico.getNro_Documento());
        stmt.setString(4, medico.getTelefono());
        stmt.setString(5, medico.getEmail());
        stmt.setString(6, medico.getEspecialidad());
        stmt.setString(7, medico.getHorario_Desde());
        stmt.setString(8, medico.getHorario_Hasta());
    }
    
    @Override
    protected void setUpdateParameters(PreparedStatement stmt, Medico medico) throws SQLException {
        setInsertParameters(stmt, medico);
        stmt.setInt(9, medico.getId());
    }
    
    @Override
    protected Medico mapResultSetToEntity(ResultSet rs) throws SQLException {
        Medico medico = new Medico();
        medico.setId(rs.getInt("Id"));
        medico.setNombre(rs.getString("Nombre"));
        medico.setApellido(rs.getString("Apellido"));
        medico.setNro_Documento(rs.getString("Nro_Documento"));
        medico.setTelefono(rs.getString("Telefono"));
        medico.setEmail(rs.getString("Email"));
        medico.setEsPecialidad(rs.getString("Especialidad"));
        medico.setHorario_Desde(rs.getString("Horario_Desde"));
        medico.setHorario_Hasta(rs.getString("Horario_Hasta"));
        
        return medico;
    }
    
    @Override
    protected Integer getEntityId(Medico medico) {
        return medico.getId();
    }
    
    public Medico GetModel(){
        
        return _Model;
    }

   
    
    
}