/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

/**
 *
 * @author Gotcha
 */
public class NoPostException extends Exception {
    public NoPostException(){
        super("El post no existe");
    }
}
