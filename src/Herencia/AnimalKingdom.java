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
        
        ArrayList<Animal> animales = new ArrayList<Animal>();
        
        animales.add( new Perro("Canini Panini"));
        animales.add(new Bulldog());
       // animales.add( new GatoSiberiano());
        GatoSiberiano.frio();
        
        for(Animal ani : animales)
            ani.hablar();
        
        Animal ani = new Animal("Perico",2,false) {

            public void fua(){
                System.out.println("FUAA");
            }
            
            @Override
            public void hablar() {
                System.out.println("WAKA WAKA");
                this.fua();
            }
        };
        ani.hablar();
        
        //Animal ani2 = new Animal("Sapo",4,false);
        
        
    }
}
