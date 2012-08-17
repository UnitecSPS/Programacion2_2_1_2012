/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author Gotcha
 */
public abstract class Papa {
    protected String nombre;
    
    public Papa(String n){
        nombre = n;
    }
    
    public abstract void gastarHerencia();

    @Override
    public String toString() {
        return "Papa{" + "nombre=" + nombre + '}';
    }
    
    
}
