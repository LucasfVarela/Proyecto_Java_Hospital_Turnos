/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author lautisape
 */
public class DatabaseException extends HospitalException {
    
    public DatabaseException(String mensaje) {
        super("Error de Base de Datos: " + mensaje);
    }
    
    public DatabaseException(String mensaje, Throwable causa) {
        super("Error de Base de Datos: " + mensaje, causa);
    }
}
