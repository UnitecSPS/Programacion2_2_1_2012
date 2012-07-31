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
    
    public void patito(){
        this.codigo = 1;
        this.nombre = "Patito";
        this.saldo = 300;
    }
    
}
