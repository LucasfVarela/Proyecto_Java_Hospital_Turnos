/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Medico;
import DAO.MedicoDAO;
import Exceptions.*;
import java.util.List;

/**
 * Controlador para gestionar operaciones sobre medicos.
 * @author lautaro
 */
public class MedicoController {
    
    private MedicoDAO medicoDAO;
    
    public MedicoController() {
        this.medicoDAO = new MedicoDAO();
    }
    
    /**
     * Crea un nuevo medico
     * @param medico El medico a crear
     * @return El medico creado
     * @throws Exception si hay error
     */
    public Medico crear(Medico medico) throws Exception {
        validar(medico);
        return medicoDAO.save(medico);
    }
    
    /**
     * Obtiene un medico por ID
     * @param id El ID del medico
     * @return El medico
     * @throws Exception si no existe
     */
    public Medico obtener(Integer id) throws Exception {
        return medicoDAO.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Medico", id));
    }
    
    /**
     * Obtiene todos los medicos
     * @return Lista de medicos
     * @throws Exception si hay error
     */
    public List<Medico> obtenerTodos() throws Exception {
        return medicoDAO.findAll();
    }
    
    /**
     * Actualiza un medico
     * @param medico El medico a actualizar
     * @return El medico actualizado
     * @throws Exception si hay error
     */
    public Medico actualizar(Medico medico) throws Exception {
        validar(medico);
        return medicoDAO.update(medico);
    }
    
    /**
     * Elimina un medico
     * @param id El ID del medico
     * @throws Exception si hay error
     */
    public void eliminar(Integer id) throws Exception {
        medicoDAO.deleteById(id);
    }
    
    /**
     * Busca medicos por especialidad
     * @param especialidad La especialidad
     * @return Lista de medicos
     * @throws Exception si hay error
     */
    public List<Medico> buscarPorEspecialidad(String especialidad) throws Exception {
        return medicoDAO.findByEspecialidad(especialidad);
    }
    
    /**
     * Valida los datos del medico
     */
    private void validar(Medico medico) throws ValidationException {
        if (medico.getNombre() == null || medico.getNombre().trim().isEmpty()) {
            throw new ValidationException("El nombre es requerido");
        }
        if (medico.getApellido() == null || medico.getApellido().trim().isEmpty()) {
            throw new ValidationException("El apellido es requerido");
        }
        if (medico.getEspecialidad() == null || medico.getEspecialidad().trim().isEmpty()) {
            throw new ValidationException("La especialidad es requerida");
        }
        if (medico.getTelefono() == null || medico.getTelefono().trim().isEmpty()) {
            throw new ValidationException("El telefono es requerido");
        }
        if (medico.getHorarios() == null) {
            throw new ValidationException("El horario es requerido");
        }
    }
}
