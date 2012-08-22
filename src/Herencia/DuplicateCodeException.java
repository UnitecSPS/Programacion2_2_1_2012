/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class DuplicateCodeException extends Exception{
    public DuplicateCodeException(int cod){
        super(cod + " es un codigo duplicado en el sistema");
    }
}
