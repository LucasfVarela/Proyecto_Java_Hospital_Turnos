package Controllers;

import Model.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import DAO.GenericDAOImpl;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacienteController extends GenericDAOImpl<Paciente, Integer> {
    
    public Paciente _Model = new Paciente();
    
    public PacienteController()
    {
        
    }
    
    
    public void Load(Paciente Paciente)
    {
        
        _Model.setId(Paciente.getId());
        _Model.setNombre(Paciente.getNombre());
        _Model.setApellido(Paciente.getApellido());
        _Model.setNumeroDocumento(Paciente.getNumeroDocumento());
        _Model.setTelefono(Paciente.getTelefono());
        _Model.setEmail(Paciente.getEmail());
        _Model.setFechaNacimiento(Paciente.getFechaNacimiento());
        _Model.setSexo(Paciente.getSexo());
    }
    @Override
    protected String getTableName() {
        return "Paciente";
    }
    
    
  /*  @Override
    protected String getInsertSQL() {
        return "INSERT INTO Paciente (Nombre, Apellido, Nro_Documento, Telefono, Email, Fecha_Nacimiento) " +
               "VALUES ("+_Model.getNombre() +", "+_Model.getApellido() +","+_Model.getNumeroDocumento()+", "+_Model.getTelefono() +", "+_Model.getEmail() +", "+_Model.getFechaNacimiento() +")";
    }*/
    
      @Override
         protected String getInsertSQL() {
        return "INSERT INTO Paciente (Nombre, Apellido, Nro_Documento, Telefono, Email,Fecha_Nacimiento,Sexo)  VALUES ('"+_Model.getNombre()+"','"+_Model.getApellido()+"','"+_Model.getNumeroDocumento()+"','"+_Model.getTelefono()+"','"+_Model.getEmail()+"',CONVERT(DATE,'"+_Model.getFechaNacimiento()+"',103),'"+_Model.getSexo()+"')";
    }
    /*protected String getInsertSQL() {
        return "INSERT INTO Paciente VALUES ('"+_Model.getNombre()+"','"+_Model.getApellido()+"','"+_Model.getNumeroDocumento()+"','"+_Model.getTelefono()+"','"+_Model.getEmail()+"',"+_Model.getFechaNacimiento()+",'"+ _Model.getSexo()+"')";
    }*/
    
    
    @Override
    protected String getUpdateSQL() {
        return "UPDATE Paciente SET Nombre = '"+_Model.getNombre()+"', Apellido = '"+_Model.getApellido()+"', Nro_Documento = '"+_Model.getNumeroDocumento()+"', " +
               "Telefono = '"+_Model.getTelefono()+"', Email = '"+_Model.getEmail()+"', Fecha_Nacimiento = CONVERT(DATE,'"+_Model.getFechaNacimiento()+"',103) ,Sexo = '"+_Model.getSexo()+"' WHERE Id = "+_Model.getId()+"";
    }
    
    @Override
    protected void setInsertParameters(PreparedStatement stmt, Paciente paciente) throws SQLException {
        stmt.setString(1, paciente.getNombre());
        stmt.setString(2, paciente.getApellido());
        stmt.setString(3, paciente.getNumeroDocumento());
        stmt.setString(4, paciente.getTelefono());
        stmt.setString(5, paciente.getEmail());
        
        // Convertir LocalDate a java.sql.Date
        if (paciente.getFechaNacimiento() != null) {
            stmt.setDate(6, Date.valueOf(paciente.getFechaNacimiento()));
        } else {
            stmt.setNull(6, java.sql.Types.DATE);
        }
    }
    
    @Override
    protected void setUpdateParameters(PreparedStatement stmt, Paciente paciente) throws SQLException {
        setInsertParameters(stmt, paciente);
        stmt.setInt(7, paciente.getId());
    }
    
    @Override
    protected Paciente mapResultSetToEntity(ResultSet rs) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setId(rs.getInt("Id"));
        paciente.setNombre(rs.getString("Nombre"));
        paciente.setApellido(rs.getString("Apellido"));
        paciente.setNumeroDocumento(rs.getString("Nro_Documento"));
        paciente.setTelefono(rs.getString("Telefono"));
        paciente.setEmail(rs.getString("Email"));
        paciente.setSexo(rs.getString("Sexo"));
        
        // Convertir java.sql.Date a LocalDate
        Date fechaSQL = rs.getDate("Fecha_Nacimiento");
        if (fechaSQL != null) {
            paciente.setFechaNacimiento(fechaSQL.toString());
        }
        
        return paciente;
    }
    
    @Override
    protected Integer getEntityId(Paciente paciente) {
        return paciente.getId();
    }
    
    public Paciente GetModel(){
        
        return _Model;
    }

   
    
    public Paciente finbyId(int id ) throws Exception {
        return super.findById(id);
    }

    @Override
    public boolean existsById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}