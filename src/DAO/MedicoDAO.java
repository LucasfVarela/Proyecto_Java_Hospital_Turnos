package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lautisape
 */

import Model.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;


public class MedicoDAO extends GenericDAOImpl<Medico, Integer> {
    
    @Override
    protected String getTableName() {
        return "medicos";
    }
    
    @Override
    protected String getIdColumnName() {
        return "id";
    }
    
    @Override
    protected String getInsertSQL() {
        return "INSERT INTO medicos (nombre, apellido, especialidad, telefono, horarios) " +
               "VALUES (?, ?, ?, ?, ?)";
    }
    
    @Override
    protected String getUpdateSQL() {
        return "UPDATE medicos SET nombre = ?, apellido = ?, especialidad = ?, " +
               "telefono = ?, horarios = ? WHERE id = ?";
    }
    
    @Override
    protected void setInsertParameters(PreparedStatement stmt, Medico entity) throws SQLException {
        stmt.setString(1, entity.getNombre());
        stmt.setString(2, entity.getApellido());
        stmt.setString(3, entity.getEspecialidad());
        stmt.setString(4, entity.getTelefono());
        stmt.setObject(5, entity.getHorarios());
    }
    
    @Override
    protected void setUpdateParameters(PreparedStatement stmt, Medico entity) throws SQLException {
        stmt.setString(1, entity.getNombre());
        stmt.setString(2, entity.getApellido());
        stmt.setString(3, entity.getEspecialidad());
        stmt.setString(4, entity.getTelefono());
        stmt.setObject(5, entity.getHorarios());
        stmt.setInt(6, entity.getId());
    }
    
    @Override
    protected Medico mapResultSetToEntity(ResultSet rs) throws SQLException {
        Medico medico = new Medico();
        medico.setId(rs.getInt("id"));
        medico.setNombre(rs.getString("nombre"));
        medico.setApellido(rs.getString("apellido"));
        medico.setEspecialidad(rs.getString("especialidad"));
        medico.setTelefono(rs.getString("telefono"));
        medico.setHorarios(rs.getObject("horarios", LocalTime.class));
        return medico;
    }
    
    @Override
    protected Integer getEntityId(Medico entity) {
        return entity.getId();
    }
    
    /**
     * Busca médicos por especialidad
     * @param especialidad La especialidad a buscar
     * @return Lista de médicos con esa especialidad
     * @throws Exception si hay error en la BD
     */
    public List<Medico> findByEspecialidad(String especialidad) throws Exception {
        String sql = "SELECT * FROM medicos WHERE especialidad = ?";
        return executeQuery(sql, especialidad);
    }
    
    /**
     * Busca médicos por apellido
     * @param apellido El apellido del médico
     * @return Lista de médicos encontrados
     * @throws Exception si hay error en la BD
     */
    public List<Medico> findByApellido(String apellido) throws Exception {
        String sql = "SELECT * FROM medicos WHERE apellido = ?";
        return executeQuery(sql, apellido);
    }
    
    /**
     * Busca médicos por nombre
     * @param nombre El nombre del médico
     * @return Lista de médicos encontrados
     * @throws Exception si hay error en la BD
     */
    public List<Medico> findByNombre(String nombre) throws Exception {
        String sql = "SELECT * FROM medicos WHERE nombre = ?";
        return executeQuery(sql, nombre);
    }
}
