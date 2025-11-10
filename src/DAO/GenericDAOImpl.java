/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

// Implementación base del DAO genérico
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {
    
    protected abstract String getTableName();
    protected abstract String getInsertSQL();
    protected abstract String getUpdateSQL();
    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;
    protected abstract ID getEntityId(T entity);
    
    @Override
    public T Insert(T entity) throws Exception {
        String sql = getInsertSQL();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
          
           
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    
                }
                return entity;
            }
            throw new Exception("Error al guardar la entidad");
        } catch (SQLException e) {
            throw new Exception("Error en la base de datos al guardar: " + e.getMessage(), e);
        } finally {
            closeResources(conn, stmt, rs);
        }
    }
    
    @Override
    public T findById(int id) throws Exception {
        String sql = "SELECT * FROM " + getTableName() + " WHERE Id ="+id;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            //stmt.setObject(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapResultSetToEntity(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new Exception("Error en la base de datos al buscar por ID: " + e.getMessage(), e);
        } finally {
            closeResources(conn, stmt, rs);
        }
    }
    
    @Override
    public List<T> findAll() throws Exception {
        String sql = "SELECT * FROM " + getTableName()+" Order BY Id ASC";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<T> entities = new ArrayList<>();
        
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                entities.add(mapResultSetToEntity(rs));
            }
            return entities;
        } catch (SQLException e) {
            throw new Exception("Error en la base de datos al obtener todas las entidades: " + e.getMessage(), e);
        } finally {
            closeResources(conn, stmt, rs);
        }
    }
    
    @Override
    public T update(T entity) throws Exception {
        String sql = getUpdateSQL();
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return entity;
            }
            throw new Exception("No se encontró la entidad para actualizar");
        } catch (SQLException e) {
            throw new Exception("Error en la base de datos al actualizar: " + e.getMessage(), e);
        } finally {
            closeResources(conn, stmt, null);
        }
    }
    
    @Override
    public void deleteById(ID id) throws Exception {
        String sql = "DELETE FROM " + getTableName() + " WHERE Id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, id);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("No se encontró la entidad para eliminar");
            }
        } catch (SQLException e) {
            throw new Exception("Error en la base de datos al eliminar: " + e.getMessage(), e);
        } finally {
            closeResources(conn, stmt, null);
        }
    }
    
    @Override
    public void SoftdeleteById(ID id) throws Exception {
        
        
        String sql = "UPDATE " + getTableName() + "SET Activo = false  WHERE Id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, id);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("No se encontró la entidad para eliminar");
            }
        } catch (SQLException e) {
            throw new Exception("Error en la base de datos al eliminar: " + e.getMessage(), e);
        } finally {
            closeResources(conn, stmt, null);
        }
    }
    

    
    @Override
    public long count() throws Exception {
        String sql = "SELECT COUNT(*) FROM " + getTableName();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getLong(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new Exception("Error en la base de datos al contar: " + e.getMessage(), e);
        } finally {
            closeResources(conn, stmt, rs);
        }
    }
    
    /**
     * Método auxiliar para cerrar recursos de forma segura
     */
    protected void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try { rs.close(); } catch (SQLException e) { /* ignore */ }
        }
        if (stmt != null) {
            try { stmt.close(); } catch (SQLException e) { /* ignore */ }
        }
        if (conn != null) {
            try { conn.close(); } catch (SQLException e) { /* ignore */ }
        }
    }
    
    /**
     * Método auxiliar para ejecutar consultas personalizadas
     */
    protected List<T> executeQuery(String sql, Object... parameters) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<T> entities = new ArrayList<>();
        
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            
            for (int i = 0; i < parameters.length; i++) {
                stmt.setObject(i + 1, parameters[i]);
            }
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                entities.add(mapResultSetToEntity(rs));
            }
            return entities;
        } catch (SQLException e) {
            throw new Exception("Error ejecutando consulta personalizada: " + e.getMessage(), e);
        } finally {
            closeResources(conn, stmt, rs);
        }
    }
    
     public boolean existsById(int id) throws Exception {
       String sql = "SELECT COUNT(*) FROM " + getTableName() + " WHERE Id = " + id;
       Connection conn = null;
       PreparedStatement stmt = null;
       ResultSet rs = null;
    
       try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
        
            if (rs.next()) {
               return rs.getInt(1) > 0;
            }
            return false;
           } catch (SQLException e) {
               throw new Exception("Error al verificar existencia: " + e.getMessage(), e);
           } finally {
             closeResources(conn, stmt, rs);
          }
    }
}

