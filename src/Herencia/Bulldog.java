/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class Bulldog extends Perro {
    public Bulldog(){
        super("Bulldog");
    }

    @Override
    public void hablar() {
        super.hablar();
        System.out.println(" GRR GRRR");
        
    }
    
    
}
