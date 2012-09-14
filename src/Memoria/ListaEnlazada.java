 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

import java.io.IOException;
import java.io.RandomAccessFile;

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
    
    public void listar(){
        Nodo tmp = raiz;
        
        while(tmp != null){
            System.out.println("Nombre: " + tmp.nombre);
            tmp = tmp.siguiente;
        }
    }
    
    public void borrar(String n){
        //verifico que la lista tenga 1 nodo por lo menos
         if( raiz != null ){
             //verifico si no es la raiz que le
             //quiero dar jabon
             if( raiz.nombre.equals(n)){
                 raiz = raiz.siguiente;
             }
             else{
                 //busquemos el nodo a borrar
                 Nodo tmp = raiz;
                 
                 while(tmp.siguiente != null &&
                      !tmp.siguiente.nombre.equals(n)){
                     
                     tmp = tmp.siguiente;
                 }
                 
                 if( tmp.siguiente != null ){
                     //quede apuntando el que quiero borrar
                     tmp.siguiente = tmp.siguiente.siguiente;
                 }
                 else{
                     System.out.println("NO EXISTE " + n);
                 }
             }
         }
    }
    
    /***
     * Retorna true si un elemento de la lista enlazada existe
     * dado su valor de nombre
     * @param nombre El nombre a buscar
     * @return TRUE si existe o no
     */
    public boolean buscar(String nombre){
        Nodo tmp = raiz;
        
        while(tmp != null ){
            if( tmp.nombre.equals(nombre))
                return true;
            tmp = tmp.siguiente;
        }
        return false;
    }
    
    /***
     * Agrega un nuevo Nodo a la lista enlazada despues
     * del nodo que su atributo nombre coincide con el
     * parametro nombre. Ese nodo debe existir para agregarlo
     * despues de el, el nuevo nodo.
     * @param nombre El nombre a buscar
     * @param obj El nodo para agregar
     */
    public void agregarEnMedio(String nombre,Nodo obj){
        Nodo tmp = raiz;
        
        while( tmp != null ){
            if( tmp.nombre.equals(nombre) ){
                //encontre el nodo que despues de el agregare
                //el nuevo nodo
                obj.siguiente = tmp.siguiente;
                tmp.siguiente = obj;
                break;
            }
            else
                tmp = tmp.siguiente;
        }
    }
    
    /**
     * De un archivo binario cuya direccion viene de parametro
     * se lee los nombres (El formato solo es valores Strings,
     * uno tras otro) y con estos nombres se va cargando la
     * lista. Antes se LIMPIA toda la lista.
     * @param textFile La direccion del archivo
     */
    public void recarga(String textFile){
        raiz = null; //borro todo!
        
        try{
            RandomAccessFile ram = new RandomAccessFile(textFile,"rw");
            
            while( ram.getFilePointer() < ram.length() ){
                agregar( new Nodo(ram.readUTF()) );
            }
        }catch(IOException e){
            
        }
    }
}
