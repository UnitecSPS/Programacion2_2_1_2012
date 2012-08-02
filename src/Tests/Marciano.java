/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

/**
 *
 * @author Gotcha
 */
public class Marciano {
    public String nombre;
    public static int CONT = 0;
    
    public Marciano(String n){
        nombre = n;
        CONT++;
    }
    
    public void atacar(){
        if( CONT >= 5 )
            System.out.println("Yo " + nombre + " ATACOOO!");
        else
            System.out.println("YO " + nombre + " Soy cobarde");
    }
}
