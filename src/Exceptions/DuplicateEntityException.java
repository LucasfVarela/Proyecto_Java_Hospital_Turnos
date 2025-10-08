/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author lautisape
 */
public class DuplicateEntityException extends HospitalException {
    
    public DuplicateEntityException(String entidad, String campo, String valor) {
        super(entidad + " con " + campo + " '" + valor + "' ya existe en el sistema");
    }
    
    public DuplicateEntityException(String mensaje) {
        super(mensaje);
    }
}
