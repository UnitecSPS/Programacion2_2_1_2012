/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExaLab2;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public abstract class ArregloDinamico {
    protected ArrayList<Object> valores;
    protected String nombreSet;
    
    public ArregloDinamico(String n){
        nombreSet = n;
        valores = new ArrayList<Object>();
    }
    
    public final String getNombreSet(){
        return nombreSet;
    }
    
    public abstract void agregarElemento(Object obj);
    public abstract TipoArreglo getTipoArreglo();
    
    public void imprimir(){
        for(Object obj : valores)
            System.out.println(obj);
    }
}