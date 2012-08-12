/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class Perro extends Animal {
    
    public Perro(String n){
        super(n,4,true);
    }

    @Override
    public void hablar() {
        System.out.println("guau guau");
    }
}
