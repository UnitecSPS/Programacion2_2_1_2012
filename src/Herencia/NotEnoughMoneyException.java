/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(){
        super("Fondos Insuficientes");
    }
}
