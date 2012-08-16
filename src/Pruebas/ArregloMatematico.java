/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class ArregloMatematico extends Matematico{
    private ArrayList<Integer> numeros;
    
    public ArregloMatematico(String n){
        super(n);
        numeros = new ArrayList<Integer>();
    }

    public void add(int valor){
        numeros.add(valor);
    }
    
    @Override
    public double suma() {
        double s = 0;
        for(Integer val : numeros)
            s += val;
        return s;
    }
    
}
