/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exa2;

/**
 *
 * @author Gotcha
 */
public class NoSuchOptionException extends Exception {
    public NoSuchOptionException(){
        super("Opcion no existe");
    }
}
