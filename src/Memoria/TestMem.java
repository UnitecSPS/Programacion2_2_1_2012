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
        
        if( lista.buscar("Jean"))
            System.out.println("SE ENCONTRO JEAN!");
        
        if( !lista.buscar("Patito") )
            System.out.println("NO SE ENCONTRO PATITO!");
        
        lista.agregarEnMedio("Jean",new Nodo("Angela"));
        lista.agregarEnMedio("Edwin",new Nodo("Batman"));
        lista.agregarEnMedio("Patito", new Nodo("Pollito"));
        System.out.println("\nLista con agregados\n------");
        lista.listar();
        
    }
}
