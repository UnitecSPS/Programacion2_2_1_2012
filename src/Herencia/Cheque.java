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
public class Cheque {
    public int numero;
    public double monto;
    public Date fecha;
    public boolean cambiado;
    
    public Cheque(int n,double m,boolean c){
        numero = n;
        monto = m;
        cambiado = c;
        fecha = new Date();
    }
}
