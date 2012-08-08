/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen1;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Plan {
    protected int numTel;
    protected String nombre;
    protected Date creadoen;
    public static double TASA_CAMBIO = 19.7;
    
    public Plan(int nt,String n){
        numTel = nt;
        nombre = n;
        creadoen = new Date();
    }

    public Date getCreadoen() {
        return creadoen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumTel() {
        return numTel;
    }

    @Override
    public String toString() {
        return "Plan{" + "numTel=" + numTel + ", nombre=" + nombre + '}';
    }
    
    public double pagoMensual(int cmins, int cmsgs){
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Plan){
            Plan p = (Plan)obj;
            
            if( p.numTel == this.numTel )
                return true;
        }
        else if( obj instanceof Integer ){
            if( Integer.parseInt(obj.toString()) == this.numTel)
                return true;
        } 
        
        return false;
    }
    
    
}
