package Controllers;

import Model.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import DAO.GenericDAOImpl;

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
    }
    @Override
    protected String getTableName() {
        return "pacientes";
    }
    
    @Override
    protected String getIdColumnName() {
        return "id";
    }
    
    @Override
    protected String getInsertSQL() {
        return "INSERT INTO pacientes (nombre, apellido, numero_documento, telefono, email, fecha_nacimiento) " +
               "VALUES (?, ?, ?, ?, ?, ?)";
    }
    
    @Override
    protected String getUpdateSQL() {
        return "UPDATE pacientes SET nombre = ?, apellido = ?, numero_documento = ?, " +
               "telefono = ?, email = ?, fecha_nacimiento = ? WHERE id = ?";
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
        paciente.setId(rs.getInt("id"));
        paciente.setNombre(rs.getString("nombre"));
        paciente.setApellido(rs.getString("apellido"));
        paciente.setNumeroDocumento(rs.getString("numero_documento"));
        paciente.setTelefono(rs.getString("telefono"));
        paciente.setEmail(rs.getString("email"));
        
        // Convertir java.sql.Date a LocalDate
        Date fechaSQL = rs.getDate("fecha_nacimiento");
        if (fechaSQL != null) {
            paciente.setFechaNacimiento(fechaSQL.toLocalDate());
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
}