/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

/**
 *
 * @author Gotcha
 */
public class TestMem {
    public static void main(String args[]){
        Nodo noda = new Nodo("Carlos");
        Nodo nodb = new Nodo("Jean");
        noda.siguiente = nodb;
        
        System.out.println("A: " + noda.nombre);
        System.out.println("B: " + noda.siguiente.nombre);
        
    }
}
