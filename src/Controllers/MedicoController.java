package Controllers;

import Model.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import DAO.GenericDAOImpl;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicoController extends GenericDAOImpl<Medico, Integer> {
    
    public Medico _Model = new Medico();
    
    public MedicoController() {
        
    }
    
    public void Load(Medico Medico) {
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
    
@Override
protected String getInsertSQL() {
    return "INSERT INTO Medico (Nombre, Apellido, Nro_Documento, Telefono, Email, Especialidad, Horario_Desde, Horario_Hasta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
}

@Override
protected String getUpdateSQL() {
    return "UPDATE Medico SET Nombre = ?, Apellido = ?, Nro_Documento = ?, Telefono = ?, Email = ?, Especialidad = ?, Horario_Desde = ?, Horario_Hasta = ? WHERE Id = ?";
}
    
    @Override
    protected void setInsertParameters(PreparedStatement stmt, Medico medico) throws SQLException {
        stmt.setString(1, medico.getNombre());
        stmt.setString(2, medico.getApellido());
        stmt.setString(3, medico.getNro_Documento());
        stmt.setString(4, medico.getTelefono());
        stmt.setString(5, medico.getEmail());
        stmt.setString(6, medico.getEspecialidad());
        
        // Convertir String a java.sql.Time (formato esperado: "HH:mm:ss" o "HH:mm")
        if (medico.getHorario_Desde() != null) {
            stmt.setTime(7, Time.valueOf(medico.getHorario_Desde()));
        } else {
            stmt.setNull(7, java.sql.Types.TIME);
        }
        
        if (medico.getHorario_Hasta() != null) {
            stmt.setTime(8, Time.valueOf(medico.getHorario_Hasta()));
        } else {
            stmt.setNull(8, java.sql.Types.TIME);
        }
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
        
        // Convertir java.sql.Time a String
        Time horarioDesde = rs.getTime("Horario_Desde");
        if (horarioDesde != null) {
            medico.setHorario_Desde(horarioDesde.toString());
        }
        
        Time horarioHasta = rs.getTime("Horario_Hasta");
        if (horarioHasta != null) {
            medico.setHorario_Hasta(horarioHasta.toString());
        }
        
        return medico;
    }
    
    @Override
    protected Integer getEntityId(Medico medico) {
        return medico.getId();
    }
    
    public Medico GetModel() {
        return _Model;
    }
    
    public Medico finbyId(int id) throws Exception {
        return super.findById(id);
    }

    @Override
    public boolean existsById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}