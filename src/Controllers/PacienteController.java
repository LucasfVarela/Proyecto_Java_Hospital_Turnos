/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Paciente;
import DAO.PacienteDAO;
import Exceptions.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Controlador para gestionar operaciones sobre pacientes.
 * @author lautaro
 */
public class PacienteController {
    
    private PacienteDAO pacienteDAO;
    
    public PacienteController() {
        this.pacienteDAO = new PacienteDAO();
    }
    
    /**
     * Crea un nuevo paciente
     * @param paciente El paciente a crear
     * @return El paciente creado
     * @throws Exception si hay error
     */
    public Paciente crear(Paciente paciente) throws Exception {
        validar(paciente);
        return pacienteDAO.save(paciente);
    }
    
    /**
     * Obtiene un paciente por ID
     * @param id El ID del paciente
     * @return El paciente
     * @throws Exception si no existe
     */
    public Paciente obtener(Integer id) throws Exception {
        return pacienteDAO.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Paciente", id));
    }
    
    /**
     * Obtiene todos los pacientes
     * @return Lista de pacientes
     * @throws Exception si hay error
     */
    public List<Paciente> obtenerTodos() throws Exception {
        return pacienteDAO.findAll();
    }
    
    /**
     * Actualiza un paciente
     * @param paciente El paciente a actualizar
     * @return El paciente actualizado
     * @throws Exception si hay error
     */
    public Paciente actualizar(Paciente paciente) throws Exception {
        validar(paciente);
        return pacienteDAO.update(paciente);
    }
    
    /**
     * Elimina un paciente
     * @param id El ID del paciente
     * @throws Exception si hay error
     */
    public void eliminar(Integer id) throws Exception {
        pacienteDAO.deleteById(id);
    }
    
    /**
     * Busca pacientes por documento
     * @param numeroDocumento El numero de documento
     * @return Lista de pacientes
     * @throws Exception si hay error
     */
    public List<Paciente> buscarPorDocumento(String numeroDocumento) throws Exception {
        return pacienteDAO.findByNumeroDocumento(numeroDocumento);
    }
    
    /**
     * Valida los datos del paciente
     */
    private void validar(Paciente paciente) throws ValidationException {
        if (paciente.getNombre() == null || paciente.getNombre().trim().isEmpty()) {
            throw new ValidationException("El nombre es requerido");
        }
        if (paciente.getApellido() == null || paciente.getApellido().trim().isEmpty()) {
            throw new ValidationException("El apellido es requerido");
        }
        if (paciente.getNumeroDocumento() == null || paciente.getNumeroDocumento().trim().isEmpty()) {
            throw new ValidationException("El numero de documento es requerido");
        }
        if (paciente.getTelefono() == null || paciente.getTelefono().trim().isEmpty()) {
            throw new ValidationException("El telefono es requerido");
        }
        if (paciente.getEmail() == null || paciente.getEmail().trim().isEmpty()) {
            throw new ValidationException("El email es requerido");
        }
        if (!isValidEmail(paciente.getEmail())) {
            throw new ValidationException("El formato del email no es valido");
        }
        if (paciente.getFechaNacimiento() == null) {
            throw new ValidationException("La fecha de nacimiento es requerida");
        }
        if (paciente.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new ValidationException("La fecha de nacimiento no puede ser en el futuro");
        }
    }
    
    /**
     * Valida el formato de un email
     */
    private boolean isValidEmail(String email) {
        return email.matches("@");
    }
}
