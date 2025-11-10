package Controllers;

import Model.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.GenericDAOImpl;

/**
 * Controlador para la gestión de médicos en el sistema.
 * 
 * Esta clase extiende GenericDAOImpl para proporcionar operaciones CRUD específicas
 * para la entidad Medico. Además de las operaciones básicas de base de datos,
 * 
 * El controlador mantiene una instancia interna del modelo Medico que se utiliza
 * para construir las consultas SQL dinámicamente.
 * 
 * Funcionalidades principales:
 * - Operaciones CRUD heredadas de GenericDAOImpl
 * - Carga de datos del médico en el modelo interno

 * 
 * @author Varela Lucas , Lautaro Nuccitelli, Lautaro Vallejo
 * @version 1.0
 * @see GenericDAOImpl
 * @see Medico
 */

public class MedicoController extends GenericDAOImpl<Medico, Integer> {
    
    public Medico _Model = new Medico();
    
    public MedicoController()
    {
        
    }
    
     /**
     * Carga los datos de un médico en el modelo interno del controlador.
     * Este método transfiere todos los atributos del médico proporcionado
     * al modelo interno para su posterior uso en operaciones SQL.
     * 
     * @param Medico El objeto Medico cuyos datos se van a cargar
     */
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
    
     /**
     * Obtiene el nombre de la tabla en la base de datos.
     * 
     * @return El string "Medico" que corresponde al nombre de la tabla
     */
    @Override
    protected String getTableName() {
        return "Medico";
    }
    
   /**
     * Construye la sentencia SQL para insertar un nuevo médico.
     * Utiliza concatenación de strings con los valores del modelo interno.
     * 
     * @return La sentencia SQL INSERT construida dinámicamente
     */
      @Override
         protected String getInsertSQL() {
        return "INSERT INTO Medico (Nombre, Apellido, Nro_Documento, Telefono, Email, Especialidad, Horario_Desde, Horario_Hasta) VALUES ('"+_Model.getNombre()+"','"+_Model.getApellido()+"','"+_Model.getNro_Documento()+"','"+_Model.getTelefono()+"','"+_Model.getEmail()+"','"+_Model.getEspecialidad()+"','"+_Model.getHorario_Desde()+"','"+_Model.getHorario_Hasta()+"')";
    }
   
     /**
     * Construye la sentencia SQL para actualizar un médico existente.
     * Utiliza concatenación de strings con los valores del modelo interno.
     * 
     * 
     * @return La sentencia SQL UPDATE construida dinámicamente
     */
    @Override
    protected String getUpdateSQL() {
        return "UPDATE Medico SET Nombre = '"+_Model.getNombre()+"', Apellido = '"+_Model.getApellido()+"', Nro_Documento = '"+_Model.getNro_Documento()+"', " +
               "Telefono = '"+_Model.getTelefono()+"', Email = '"+_Model.getEmail()+"', Especialidad = '"+_Model.getEspecialidad()+"', Horario_Desde = '"+_Model.getHorario_Desde()+"', Horario_Hasta = '"+_Model.getHorario_Hasta()+"' WHERE Id = "+_Model.getId()+"";
    }
    
     /**
     * Mapea un ResultSet de la base de datos a un objeto Medico.
     * Extrae todos los campos de la fila actual del ResultSet y construye
     * una instancia completa de Medico con esos datos.
     * 
     * @param rs El ResultSet del cual se leerán los datos
     * @return Un objeto Medico con los datos mapeados desde el ResultSet
     * @throws SQLException Si ocurre un error al leer los datos del ResultSet
     */
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
        medico.setHorario_Desde(rs.getTime("Horario_Desde").toLocalTime());
        medico.setHorario_Hasta(rs.getTime("Horario_Hasta").toLocalTime());
        
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