package Service;
import DAO.DatabaseConnection;
import Model.Medico;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HorarioDisponibleService {
    
    private Connection conexion;
    private static final int DURACION_TURNO = 30; // Duración de cada turno en minutos
     Connection conn = null;
    public HorarioDisponibleService() throws SQLException {
         conn = DatabaseConnection.getConnection();
        this.conexion = conn;
    }
    
    /**
     * Obtiene los horarios disponibles de un médico para una fecha específica
     * @param idMedico ID del médico
     * @param fecha Fecha para consultar disponibilidad
     * @return Lista de horarios disponibles en formato "HH:mm"
     */
    public List<String> obtenerHorariosDisponibles(int idMedico, LocalDate fecha) {
        List<String> horariosDisponibles = new ArrayList<>();
        
        try {
            // 1. Obtener horario del médico
            Medico medico = obtenerMedico(idMedico);
            if (medico == null) {
                return horariosDisponibles;
            }
            
            LocalTime horarioDesde = medico.getHorario_Desde();
            LocalTime horarioHasta = medico.getHorario_Hasta();
            
            // 2. Obtener turnos ocupados en esa fecha
            List<LocalTime> turnosOcupados = obtenerTurnosOcupados(idMedico, fecha);
            
            // 3. Generar todos los slots posibles
            LocalTime horaActual = horarioDesde;
            while (horaActual.isBefore(horarioHasta)) {
                // Verificar si el slot está disponible
                if (!estaOcupado(horaActual, turnosOcupados)) {
                    horariosDisponibles.add(horaActual.toString());
                }
                horaActual = horaActual.plusMinutes(DURACION_TURNO);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al obtener horarios disponibles: " + e.getMessage());
            e.printStackTrace();
        }
        
        return horariosDisponibles;
    }
    
    /**
     * Obtiene los datos del médico
     */
    private Medico obtenerMedico(int idMedico) throws SQLException {
        String sql = "SELECT Id, Nombre, Apellido, Horario_Desde, Horario_Hasta " +
                     "FROM Medico WHERE Id = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idMedico);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("Id"));
                medico.setNombre(rs.getString("Nombre"));
                medico.setApellido(rs.getString("Apellido"));
                
                // Convertir Time a LocalTime
                Time timeDesde = rs.getTime("Horario_Desde");
                Time timeHasta = rs.getTime("Horario_Hasta");
                
                if (timeDesde != null) {
                    medico.setHorario_Desde(timeDesde.toLocalTime());
                }
                if (timeHasta != null) {
                    medico.setHorario_Hasta(timeHasta.toLocalTime());
                }
                
                return medico;
            }
        }
        return null;
    }
    
    /**
     * Obtiene todos los turnos ocupados de un médico en una fecha
     */
    private List<LocalTime> obtenerTurnosOcupados(int idMedico, LocalDate fecha) throws SQLException {
        List<LocalTime> turnosOcupados = new ArrayList<>();
        
        String sql = "SELECT Hora FROM Turno " +
                     "WHERE Id_Medico = ? AND Fecha = ? " +
                     "ORDER BY Hora";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idMedico);
            ps.setDate(2, Date.valueOf(fecha));
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Time hora = rs.getTime("Hora");
                if (hora != null) {
                    turnosOcupados.add(hora.toLocalTime());
                }
            }
        }
        
        return turnosOcupados;
    }
    
    /**
     * Verifica si un horario está ocupado
     */
    private boolean estaOcupado(LocalTime hora, List<LocalTime> turnosOcupados) {
        for (LocalTime turnoOcupado : turnosOcupados) {
            // Verificar si hay conflicto con turnos existentes
            if (hora.equals(turnoOcupado)) {
                return true;
            }
            // Considerar la duración del turno (evitar solapamientos)
            LocalTime finTurno = turnoOcupado.plusMinutes(DURACION_TURNO);
            if (hora.isAfter(turnoOcupado) && hora.isBefore(finTurno)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Valida si un horario específico está disponible (útil al guardar)
     */
    public boolean validarHorarioDisponible(int idMedico, LocalDate fecha, LocalTime hora) {
        List<String> disponibles = obtenerHorariosDisponibles(idMedico, fecha);
        return disponibles.contains(hora.toString());
    }
    
 
}