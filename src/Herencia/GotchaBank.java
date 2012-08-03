/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class GotchaBank {
    static ArrayList<CuentaBancaria> cuentas;
    
    static{
        cuentas = new ArrayList<CuentaBancaria>();
    }
    
    public static void main(String args[]){
        //menu para
        //1- agregar cuenta
        //2- depositar
        //3- retirar
        //4- transferencias entre cuentas
        //5- Configurar Fecha Fin para Plazos Fijos
        //6- Imprimir las cuentas
    }
    
    public static void addCuenta(int nc,String n,String tip){
        TipoCuenta tipo = TipoCuenta.valueOf(tip);
        switch(tipo){
            case AHORRO:
                cuentas.add( new CuentaBancaria(nc,n) );
                break;
            case CHEQUE:
                int nchequera=0;//ingresarlo de teclado
                cuentas.add( new CuentaCheques(nc,n,nchequera));
                break;
            default:
                cuentas.add( new CuentaPlazoFija(nc, n));
        }
    }
    
    public static void configuarFechaFin(int nc,int y,int m,int d){
        for(CuentaBancaria cb : cuentas){
            if( cb.codigo == nc ){
                
                if(cb instanceof CuentaPlazoFija){
                    //downcasting
                    //in directo
                    CuentaPlazoFija cf = (CuentaPlazoFija)cb;
                    cf.setFechaFin(y, m, d);
                    //directo
                    ((CuentaPlazoFija)cb).setFechaFin(y, m, d);
                }
            }
        }
    }
}
