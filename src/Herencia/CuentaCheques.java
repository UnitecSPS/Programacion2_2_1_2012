/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class CuentaCheques extends CuentaBancaria{
    
    private ArrayList<Integer> numeros;
    private int numChequera;
    
    public CuentaCheques(int c, String n,int nc){
        super(c,n);
        numChequera = nc;
    }
    
    @Override
    public void patito(){
        System.out.println("PATITO CHEQUE");
    }
    
}
