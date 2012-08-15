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
    static iBanco banco;
    
    static{
        banco = new BancoArraylist();
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
                banco.agregarCuenta( new CuentaBancaria(nc,n) );
                break;
            case CHEQUE:
                int nchequera=0;//ingresarlo de teclado
                banco.agregarCuenta( new CuentaCheques(nc,n,nchequera));
                break;
            default:
                banco.agregarCuenta( new CuentaPlazoFija(nc, n));
        }
    }
    
    public static void configuarFechaFin(int nc,int y,int m,int d){
        if( banco.setFechaFin(nc, y, m, d) )
            System.out.println("SE HIZO BIEN");
        else
            System.out.println("NO SE PUDO HACER");
    }
}
