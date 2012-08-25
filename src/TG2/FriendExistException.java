/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

/**
 *
 * @author Gotcha
 */
public class FriendExistException extends RuntimeException {
    public FriendExistException(){
        super("Dicho amigo ya ha sido agregado");
    }
}
