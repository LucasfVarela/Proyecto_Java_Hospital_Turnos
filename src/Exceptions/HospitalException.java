/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author lautisape
 */
public class HospitalException extends Exception {
    
    public HospitalException(String mensaje) {
        super(mensaje);
    }
    
    public HospitalException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
