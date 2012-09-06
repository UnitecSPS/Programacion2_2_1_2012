/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Gotcha
 */
public class CuentaBancaria {
    protected int codigo;
    protected String nombre;
    protected double saldo;
    protected final Date fechaInicio = new Date();
    public static final int PAGO_MINIMO = 500;
    
    public CuentaBancaria(int c, String n){
        codigo = c;
        nombre = n;
        saldo = PAGO_MINIMO;
    }

    public final int getCodigo() {
        return codigo;
    }

    public final Date getFechaInicio() {
        return fechaInicio;
    }

    public final String getNombre() {
        return nombre;
    }

    public final double getSaldo() {
        return saldo;
    }
    
    public double tasaInteres(){
        return 0.03;
    }
    
    public void deposito(double m){
        saldo += m;
    }
    
    public boolean retiro(double m)throws NotEnoughMoneyException{
        if( saldo > m ){
            saldo -= m;
            return true;
        }
        throw new NotEnoughMoneyException();
    }
    
    public void registrarIntereses(){
        saldo += saldo * tasaInteres();
    }

    @Override
    public String toString() {
        String dato = codigo + "-" + nombre + " Lps." +saldo;
        return dato;
    }
    
    public void patito(){
        System.out.println("PATITO BANCARIO");
    }
    
    public TipoCuenta getTipo(){
        return TipoCuenta.AHORRO;
    }
  }
