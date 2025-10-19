/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Turno;
import DAO.TurnoDAO;
import Exceptions.*;
import java.util.List;
/**
 * Controlador para gestionar operaciones sobre turnos.
 * @author lautaro
 */
public class TurnoController {
    
    private TurnoDAO turnoDAO;
    
    public TurnoController() {
        this.turnoDAO = new TurnoDAO();
    }
    
    /**
     * Crea un nuevo turno
     * @param turno El turno a crear
     * @return El turno creado
     * @throws Exception si hay error
     */
    public Turno crear(Turno turno) throws Exception {
        validar(turno);
        return turnoDAO.save(turno);
    }
    
    /**
     * Obtiene un turno por ID
     * @param id El ID del turno
     * @return El turno
     * @throws Exception si no existe
     */
    public Turno obtener(Integer id) throws Exception {
        return turnoDAO.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Turno", id));
    }
    
    /**
     * Obtiene todos los turnos
     * @return Lista de turnos
     * @throws Exception si hay error
     */
    public List<Turno> obtenerTodos() throws Exception {
        return turnoDAO.findAll();
    }
    
    /**
     * Actualiza un turno
     * @param turno El turno a actualizar
     * @return El turno actualizado
     * @throws Exception si hay error
     */
    public Turno actualizar(Turno turno) throws Exception {
        validar(turno);
        return turnoDAO.update(turno);
    }
    
    /**
     * Elimina un turno
     * @param id El ID del turno
     * @throws Exception si hay error
     */
    public void eliminar(Integer id) throws Exception {
        turnoDAO.deleteById(id);
    }
    
    /**
     * Valida los datos del turno
     */
    private void validar(Turno turno) throws ValidationException {
        if (turno.getNombre() == null || turno.getNombre().trim().isEmpty()) {
            throw new ValidationException("El nombre es requerido");
        }
        if (turno.getApellido() == null || turno.getApellido().trim().isEmpty()) {
            throw new ValidationException("El apellido es requerido");
        }
        if (turno.getNumeroDocumento() == null || turno.getNumeroDocumento().trim().isEmpty()) {
            throw new ValidationException("El numero de documento es requerido");
        }
        if (turno.getEspecialidad() == null || turno.getEspecialidad().trim().isEmpty()) {
            throw new ValidationException("La especialidad es requerida");
        }
    }
}
