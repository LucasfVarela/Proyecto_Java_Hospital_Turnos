package Controllers;


import DAO.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import DAO.GenericDAOImpl;
import Model.Turno;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Controlador para la gestión de Turnos en el sistema.
 * 
 * Esta clase extiende GenericDAOImpl para proporcionar operaciones CRUD específicas
 * para la entidad Turno. Además de las operaciones básicas de base de datos,
 * 
 * El controlador mantiene una instancia interna del modelo Turno que se utiliza
 * para construir las consultas SQL dinámicamente.
 * 
 * Funcionalidades principales:
 * - Operaciones CRUD heredadas de GenericDAOImpl
 * - Carga de datos del Turno en el modelo interno

 * 
 * @author Varela Lucas , Lautaro Nuccitelli, Lautaro Vallejo
 * @version 1.0
 * @see GenericDAOImpl
 * @see Paciente
 */

public  class TurnosController extends GenericDAOImpl<Turno, Integer> {
    
    public Turno _Model = new Turno();
    
    public  TurnosController()
    {
        
    }
     /**
     * Carga los datos de un turno en el modelo interno del controlador.
     * Este método transfiere todos los atributos del paciente proporcionado
     * al modelo interno para su posterior uso en operaciones SQL.
     * 
     * @param Paciente El objeto Paciente cuyos datos se van a cargar
     */
    public void Load(Turno turno)
    {
        
        _Model.setId(turno.getId());
        _Model.setId_Paciente(turno.getId_Paciente());
        _Model.setId_Medico(turno.getId_Medico());
        _Model.setEstado(turno.getEstado());
        _Model.setFecha(turno.getFecha());
        _Model.setHora(turno.getHora());
        _Model.setDuracion(turno.getDuracion());
        
    }
      /**
     * Obtiene el nombre de la tabla en la base de datos.
     * 
     * @return El string "Turno" que corresponde al nombre de la tabla
     */
    @Override
    protected String getTableName() {
        return "Turno";
    }
    
    /**
     * Construye la sentencia SQL para insertar un nuevo turno.
     * Utiliza concatenación de strings con los valores del modelo interno.
     * 
     * @return La sentencia SQL INSERT construida dinámicamente
     */
    
      @Override
         protected String getInsertSQL() {
        return "INSERT INTO Turno (Id_Medico, Id_Paciente, Estado, Fecha, Hora,Duracion)  VALUES ("+_Model.getId_Medico()+","+_Model.getId_Paciente()+",'"+_Model.getEstado()+"',CONVERT(date,'"+_Model.getFecha()+"',23),'"+_Model.getHora()+"',"+_Model.getDuracion()+")";
    }
   
      /**
     * Construye la sentencia SQL para actualizar un turno existente.
     * Utiliza concatenación de strings con los valores del modelo interno.
     * 
     * 
     * @return La sentencia SQL UPDATE construida dinámicamente
     */
    @Override
    protected String getUpdateSQL() {
        return "UPDATE Turno SET Id_Medico = "+_Model.getId_Medico()+", Id_Paciente = "+_Model.getId_Paciente()+", Fecha =CONVERT(date,'"+_Model.getFecha()+"',23), " +
               "Hora = '"+_Model.getHora()+"', Duracion ="+_Model.getDuracion()+", Estado = '"+_Model.getEstado()+"' WHERE Id = "+_Model.getId()+"";
    }
    

    @Override
    protected Turno mapResultSetToEntity(ResultSet rs) throws SQLException {
        Turno turno = new Turno();
        turno.setId(rs.getInt("Id"));
        turno.setId_Paciente(rs.getInt("Id_Paciente"));
        turno.setId_Medico(rs.getInt("Id_Medico"));
        turno.setEstado(rs.getString("Estado"));
        turno.setFecha( rs.getDate("Fecha").toLocalDate());
        turno.setHora(rs.getTime("Hora").toLocalTime());
        turno.setDuracion(rs.getInt("Duracion"));
        
        return turno;
    }
    /**
     * Mapea un ResultSet de la base de datos a un objeto Turno.
     * Extrae todos los campos de la fila actual del ResultSet y construye
     * una instancia completa de Turno con esos datos.
     * 
     * @param rs El ResultSet del cual se leerán los datos
     * @return Un objeto Turno con los datos mapeados desde el ResultSet
     * @throws SQLException Si ocurre un error al leer los datos del ResultSet
     */
     protected Turno mapResultSetToDTO(ResultSet rs) throws SQLException {
        Turno turno = new Turno();
        turno.setId(rs.getInt("Id"));
        Date fecha = rs.getDate("Fecha");
        turno.setFecha( rs.getDate("Fecha").toLocalDate());
        turno.setHora(rs.getTime("Hora").toLocalTime());  
        //Campos no mapeados de la Clase
        turno.setPaciente(rs.getString("Paciente"));
        turno.setMedico(rs.getString("Medico"));
        //--
        turno.setEstado(rs.getString("Estado"));
        return turno;
    }
    
    @Override
    protected Integer getEntityId(Turno Turno) {
        return Turno.getId();
    }
    
    public Turno GetModel(){
        
        return _Model;
    }
    /**
 * Trae todos los turnos de la base de datos.
 * Incluye el nombre del paciente y del médico en cada turno.
 *
 * @return lista con todos los turnos
 * @throws Exception si hay algún problema con la base de datos
 */
     public List<Turno> getAllTurnos() throws SQLException, Exception {
         
         String sql = "SELECT " +
                    "T.Id, " +
                    "T.Fecha, " +
                    "T.Hora , " +
                    "P.Apellido + ',' + P.Nombre AS Paciente, " +
                    "M.Apellido + ',' + M.Nombre AS Medico, " +
                    "T.Estado " +
                    "FROM Turno T " +
                    "LEFT JOIN Medico M ON T.Id_Medico = M.Id " +
                    "LEFT JOIN Paciente P ON T.Id_Paciente = P.Id";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        List<Turno> turnos = new ArrayList<>();
        
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                turnos.add(mapResultSetToDTO(rs));
            }
            return turnos;
            
        } catch (SQLException e) {
            throw new Exception("Error en la base de datos al obtener todas las entidades: " + e.getMessage(), e);
        } finally {
            closeResources(conn, stmt, rs);
        }
        
  
    }
   
    /**
        * Borra todos los turnos de un médico o de un paciente.
        * 
        *
        * @param id el número de identificación del médico o paciente
        * @param Borrar_Medico true para borrar turnos del médico, false para borrar del paciente
        * @throws Exception si no encuentra nada para borrar o hay error en la base de datos
    */
    public void deleteById_Medico_Paciente(int id,boolean Borrar_Medico) throws Exception {
        String sql = "DELETE FROM " + getTableName() + " WHERE Id_Paciente = ?";
        
        if (Borrar_Medico == true){
            sql = "DELETE FROM " + getTableName() + " WHERE Id_Medico = ?";
        }
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
  
}
