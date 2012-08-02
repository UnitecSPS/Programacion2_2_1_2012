/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class CuentaPlazoFija extends CuentaBancaria {
    private Date fechaFin;
    private double interesGenerado;
    
    public CuentaPlazoFija(int nc,String n){
        super(nc,n);
        interesGenerado = 0;
    }
    
    public void setFechaFin(int year,int mes,int dia){
        
    }
    
    @Override
    public void patito(){
        System.out.println("SOY PATITO FIJO");
    }
}
