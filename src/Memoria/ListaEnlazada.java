/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

/**
 *
 * @author Gotcha
 */
public class ListaEnlazada {
    private Nodo raiz;
    
    public ListaEnlazada(){
        raiz = null;
    }
    
    public void agregar(Nodo obj){
        if( raiz == null ){
            raiz = obj;
        }
        else{
            Nodo tmp = raiz;
            while(tmp.siguiente != null){
                tmp = tmp.siguiente;
            }
            tmp.siguiente = obj;
        }
    }
}
