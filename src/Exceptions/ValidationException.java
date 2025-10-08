/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author lautisape
 */
public class ValidationException extends HospitalException {
    
    public ValidationException(String mensaje) {
        super("Error de Validación: " + mensaje);
    }
}
