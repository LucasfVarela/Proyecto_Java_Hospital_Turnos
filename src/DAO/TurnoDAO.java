package DAO;

import Model.Turno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Data Access Object para la entidad Turno.
 * Implementa operaciones CRUD específicas para turnos.
 * @author lautaro
 */

public class TurnoDAO extends GenericDAOImpl<Turno, Integer> {

  @Override
  protected String getTableName(){
    return "turnos";
  }

  @Override 
  protected String getIdColumnName(){
    return "id";
  }

  @Override
  protected String getInsertSQL(){
    return "INSERT INTO turnos (nombre, apellido, numeroDocumento, telefono, especialidad, observaciones)" + "VALUES (?, ?, ?, ?, ?, ?)";
  }

  @Override 
  protected String getUpdateSQL(){
    return "UPDATE turnos SET nombre = ?, apellido = ?, numeroDocumento = ?, " +"telefono = ?, especialidad = ?, observaciones = ? WHERE id = ?";
  }

  @Override
  protected void setInsertParameters(PreparedStatement stmt, Turno entity) throws SQLException {
    stmt.setString(1, entity.getNombre());
    stmt.setString(2, entity.getApellido());
    stmt.setString(3, entity.getNumeroDocumento());
    stmt.setString(4, entity.getTelefono());
    stmt.setString(5, entity.getEspecialidad());
    stmt.setString(6, entity.getObservaciones());
  }
    
  @Override
  protected void setUpdateParameters(PreparedStatement stmt, Turno entity) throws SQLException {
    stmt.setString(1, entity.getNombre());
    stmt.setString(2, entity.getApellido());
    stmt.setString(3, entity.getNumeroDocumento());
    stmt.setString(4, entity.getTelefono());
    stmt.setString(5, entity.getEspecialidad());
    stmt.setString(6, entity.getObservaciones());
    stmt.setInt(7, entity.getId());
  }
    
  @Override
  protected Turno mapResultSetToEntity(ResultSet rs) throws SQLException {
    Turno turno = new Turno();
    turno.setId(rs.getInt("id"));
    turno.setNombre(rs.getString("nombre"));
    turno.setApellido(rs.getString("apellido"));
    turno.setNumeroDocumento(rs.getString("numeroDocumento"));
    turno.setTelefono(rs.getString("telefono"));
    turno.setEspecialidad(rs.getString("especialidad"));
    turno.setObservaciones(rs.getString("observaciones"));
    return turno;
  }
    
  @Override
  protected Integer getEntityId(Turno entity) {
    return entity.getId();
  }
    
  /**
  * Busca turnos por especialidad
  * @param especialidad La especialidad a buscar
  * @return Lista de turnos con esa especialidad
  * @throws Exception si hay error en la BD
  */
  public List<Turno> findByEspecialidad(String especialidad) throws Exception {
     String sql = "SELECT * FROM turnos WHERE especialidad = ?";
     return executeQuery(sql, especialidad);
  }
    
  /**
  * Busca turnos por número de documento del paciente
  * @param numeroDocumento El número de documento
  * @return Lista de turnos del paciente
  * @throws Exception si hay error en la BD
  */
  public List<Turno> findByNumeroDocumento(String numeroDocumento) throws Exception {
    String sql = "SELECT * FROM turnos WHERE numeroDocumento = ?";
    return executeQuery(sql, numeroDocumento);
  }
    
  /**
  * Busca turnos por apellido del paciente
  * @param apellido El apellido del paciente
  * @return Lista de turnos del paciente
  * @throws Exception si hay error en la BD
  */
  public List<Turno> findByApellido(String apellido) throws Exception {
    String sql = "SELECT * FROM turnos WHERE apellido = ?";
    return executeQuery(sql, apellido);
  }
}

