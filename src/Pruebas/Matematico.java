/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public abstract class Matematico {
    public static final int VERSION_ID = 344;
    protected String nombreSet;
    
    public Matematico(String n){
        nombreSet = n;
    }
    
    public final String getNombreSet(){
        return nombreSet;
    }
    
    public abstract double suma();
}
