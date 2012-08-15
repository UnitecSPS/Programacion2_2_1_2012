  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */ 
public class CuentaCheques extends CuentaBancaria{
    
    private ArrayList<Cheque> cheques;
    private int numChequera;
    
    public CuentaCheques(int c, String n,int nc){
        super(c,n);
        numChequera = nc;
        cheques = new ArrayList<Cheque>();
    }
    
    @Override
    public void patito(){
        System.out.println("PATITO CHEQUE");
    }
    
    @Override
    public boolean retiro(double m){
        Scanner lea = new Scanner(System.in);
        System.out.print("Num Cheque a cambiar: ");
        int nc = lea.nextInt();
        boolean ret = super.retiro(m);
        
        Cheque c = new Cheque(nc,m,ret);
        cheques.add(c);
        
        return ret;
    }
    
    @Override
    public double tasaInteres(){
        return 0;
    }
    
    @Override
    public String toString(){
        String cad = super.toString() + " Chequera: " + 
                numChequera;
        return cad;
    }
}
