// ============================================================================
// PacienteDAO.java
// ============================================================================

package DAO;

import Model.Paciente;
import Exceptions.DatabaseException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PacienteDAO extends GenericDAOImpl<Paciente, Integer>{

  @Override
  protected String getTableName(){
    return "pacientes";
  }

  @Override
  protected String getIdColumnName(){
    return "id";
  }

  @Override
  protected String getInsertSQL() {
    return "INSERT INTO pacientes (nombre, apellido, numeroDocumento, telefono, email, fechaNacimiento) " + "VALUES (?, ?, ?, ?, ?, ?)";
    }
    
  @Override
  protected String getUpdateSQL() {
   return "UPDATE pacientes SET nombre = ?, apellido = ?, numeroDocumento = ?, " + "telefono = ?, email = ?, fechaNacimiento = ?  WHERE id = ?";  
   }


  @Override
  protected void setInsertParameters(PreparedStatement stmt, Paciente entity) throws SQLException {
    stmt.setString(1, entity.getNombre());
    stmt.setString(2, entity.getApellido());
    stmt.setString(3, entity.getNumeroDocumento());
    stmt.setString(4, entity.getTelefono());
    stmt.setString(5, entity.getEmail());
    stmt.setObject(6, entity.getFechaNacimiento());
  }
    
  @Override
  protected void setUpdateParameters(PreparedStatement stmt, Paciente entity) throws SQLException {
    stmt.setString(1, entity.getNombre());
    stmt.setString(2, entity.getApellido());
    stmt.setString(3, entity.getNumeroDocumento());
    stmt.setString(4, entity.getTelefono());
    stmt.setString(5, entity.getEmail());
    stmt.setObject(6, entity.getFechaNacimiento());
    stmt.setInt(7, entity.getId());
  }
    
  @Override
  protected Paciente mapResultSetToEntity(ResultSet rs) throws SQLException {
    Paciente paciente = new Paciente();
    paciente.setId(rs.getInt("id"));
    paciente.setNombre(rs.getString("nombre"));
    paciente.setApellido(rs.getString("apellido"));
    paciente.setNumeroDocumento(rs.getString("numeroDocumento"));
    paciente.setTelefono(rs.getString("telefono"));
    paciente.setEmail(rs.getString("email"));
    paciente.setFechaNacimiento(rs.getObject("fechaNacimiento", LocalDate.class));
    return paciente;
  }
    
  @Override
  protected Integer getEntityId(Paciente entity) {
    return entity.getId();
  }
    
  /**
  * Busca pacientes por número de documento
  * @param numeroDocumento El número de documento
  * @return Lista de pacientes encontrados
  * @throws Exception si hay error en la BD
  */
  public List<Paciente> findByNumeroDocumento(String numeroDocumento) throws Exception {
    String sql = "SELECT * FROM pacientes WHERE numeroDocumento = ?";
    return executeQuery(sql, numeroDocumento);
  }
    
  /**
   * Busca pacientes por apellido
   * @param apellido El apellido del paciente
   * @return Lista de pacientes encontrados
   * @throws Exception si hay error en la BD
   */
  public List<Paciente> findByApellido(String apellido) throws Exception {
    String sql = "SELECT * FROM pacientes WHERE apellido = ?";
    return executeQuery(sql, apellido);
  }
    
  /**
  * Busca pacientes por email
  * @param email El email del paciente
  * @return Lista de pacientes encontrados
  * @throws Exception si hay error en la BD
  */
  public List<Paciente> findByEmail(String email) throws Exception {
    String sql = "SELECT * FROM pacientes WHERE email = ?";
    return executeQuery(sql, email);
  }
}

