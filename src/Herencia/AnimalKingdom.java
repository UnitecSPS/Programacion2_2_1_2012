/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Gotcha
 */
public class AnimalKingdom {
    public static void main(String args[]){
        
        Calendar c = Calendar.getInstance();
        System.out.print(c.get(Calendar.MONTH));
        
        ArrayList<Animal> animales = new ArrayList<Animal>();
        
        animales.add( new Perro("Canini Panini"));
        animales.add(new Bulldog());
       // animales.add( new GatoSiberiano());
        GatoSiberiano.frio();
        
        for(Animal ani : animales)
            ani.hablar();
    }
}
