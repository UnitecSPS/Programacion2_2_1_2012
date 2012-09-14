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
        ListaEnlazada lista = new ListaEnlazada();
        
        lista.agregar(new Nodo("Carlos"));
        lista.agregar(new Nodo("William"));
        lista.agregar(new Nodo("Edwin"));
        lista.agregar(new Nodo("Dennis"));
        lista.agregar(new Nodo("Oscar"));
        lista.agregar(new Nodo("Jean"));
        
        lista.listar();
        
        lista.borrar("Carlos");
        System.out.println("\nLista Sin Carlos\n----");
        lista.listar();
        
        lista.borrar("Dennis");
        System.out.println("\nLista sin Dennis\n------");
        lista.listar();
        
        System.out.println("\nBorrar uno que no existe\n----");
        lista.borrar("Patito");
        
    }
}
