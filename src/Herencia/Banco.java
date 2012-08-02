/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class Banco {
    public static void main(String args[]){
        CuentaCheques ch = new CuentaCheques(1,"Carlos",1);
        //upcasting
        CuentaBancaria cb  = new CuentaCheques(2,"Angela",2);
        CuentaBancaria cb2  = new CuentaBancaria(2,"Angela");
        
        cb.patito();
        cb2.patito();
        
        //arreglosc
        CuentaBancaria cuentas[] = new CuentaBancaria[3];
        cuentas[0] = new CuentaBancaria(1,"Oscar");
        cuentas[1] = new CuentaCheques(2,"Edwin",1);
        cuentas[2] = new CuentaPlazoFija(3,"William");
        
        System.out.println("VER PATITO CONTENIDO\n\n");
        for(CuentaBancaria cbac : cuentas){
            cbac.patito();
        }
        
        // obj instanceof clase
        if( cuentas[2] instanceof CuentaBancaria ){
            System.out.println("SI SOY DE CUENTE PLAZO FIJA");
        }
        else{
            System.out.println("NO SOS PLAZO FIJA");
        }
    }
}
