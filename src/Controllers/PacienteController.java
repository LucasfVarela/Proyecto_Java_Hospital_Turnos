package Controllers;

import Model.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.GenericDAOImpl;
/**
 * Controlador para la gestión de Pacientes en el sistema.
 * 
 * Esta clase extiende GenericDAOImpl para proporcionar operaciones CRUD específicas
 * para la entidad Paciente. Además de las operaciones básicas de base de datos,
 * 
 * El controlador mantiene una instancia interna del modelo Paciente que se utiliza
 * para construir las consultas SQL dinámicamente.
 * 
 * Funcionalidades principales:
 * - Operaciones CRUD heredadas de GenericDAOImpl
 * - Carga de datos del Paciente en el modelo interno

 * 
 * @author Varela Lucas , Lautaro Nuccitelli, Lautaro Vallejo
 * @version 1.0
 * @see GenericDAOImpl
 * @see Paciente
 */
public class PacienteController extends GenericDAOImpl<Paciente, Integer> {
    
    public Paciente _Model = new Paciente();
    
    public PacienteController()
    {
        
    }
    
    /**
     * Carga los datos de un paciente en el modelo interno del controlador.
     * Este método transfiere todos los atributos del paciente proporcionado
     * al modelo interno para su posterior uso en operaciones SQL.
     * 
     * @param Paciente El objeto Paciente cuyos datos se van a cargar
     */
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
    
      /**
     * Obtiene el nombre de la tabla en la base de datos.
     * 
     * @return El string "Paciente" que corresponde al nombre de la tabla
     */
    @Override
    protected String getTableName() {
        return "Paciente";
    }
    
   
    /**
     * Construye la sentencia SQL para insertar un nuevo paciente.
     * Utiliza concatenación de strings con los valores del modelo interno.
     * 
     * @return La sentencia SQL INSERT construida dinámicamente
     */
      @Override
         protected String getInsertSQL() {
        return "INSERT INTO Paciente (Nombre, Apellido, Nro_Documento, Telefono, Email,Fecha_Nacimiento,Sexo)  VALUES ('"+_Model.getNombre()+"','"+_Model.getApellido()+"','"+_Model.getNumeroDocumento()+"','"+_Model.getTelefono()+"','"+_Model.getEmail()+"',CONVERT(date,'"+_Model.getFechaNacimiento()+"',23),'"+_Model.getSexo()+"')";
    }

    
     /**
     * Construye la sentencia SQL para actualizar un paciente existente.
     * Utiliza concatenación de strings con los valores del modelo interno.
     * 
     * 
     * @return La sentencia SQL UPDATE construida dinámicamente
     */
    @Override
    protected String getUpdateSQL() {
        return "UPDATE Paciente SET Nombre = '"+_Model.getNombre()+"', Apellido = '"+_Model.getApellido()+"', Nro_Documento = '"+_Model.getNumeroDocumento()+"', " +
               "Telefono = '"+_Model.getTelefono()+"', Email = '"+_Model.getEmail()+"', Fecha_Nacimiento = CONVERT(date,'"+_Model.getFechaNacimiento()+"',23) ,Sexo = '"+_Model.getSexo()+"' WHERE Id = "+_Model.getId()+"";
    }
    
   /**
     * Mapea un ResultSet de la base de datos a un objeto Paciente.
     * Extrae todos los campos de la fila actual del ResultSet y construye
     * una instancia completa de Paciente con esos datos.
     * 
     * @param rs El ResultSet del cual se leerán los datos
     * @return Un objeto Paciente con los datos mapeados desde el ResultSet
     * @throws SQLException Si ocurre un error al leer los datos del ResultSet
     */
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
        

         paciente.setFechaNacimiento(rs.getDate("Fecha_Nacimiento").toLocalDate());
      
        
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