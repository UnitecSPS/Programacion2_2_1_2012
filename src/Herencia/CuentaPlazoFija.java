/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.Calendar;
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
        fechaFin = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public double getInteresGenerado() {
        return interesGenerado;
    }
    
    @Override
    public double tasaInteres(){
        return 0.1;
    }
    
    @Override
    
    public void registrarIntereses(){
        Date now = new Date();
        if( now.before(fechaFin) )
            interesGenerado += saldo * tasaInteres();
    }
    
    @Override
    public boolean retiro(double m){
        if( interesGenerado > m ){
            interesGenerado -= m;
            return true;
        }
        return false;
    }
    
    /**
     * Configurar <code>Fecha Final</code>
     * @param year EL Anio
     * @param mes El MEs
     * @param dia El dia
     */
    public void setFechaFin(int year,int mes,int dia){
        Calendar c = Calendar.getInstance();
        c.set(year, mes, dia);
        fechaFin = c.getTime();
    }
    
    @Override
    public void patito(){
        System.out.println("SOY PATITO FIJO");
    }

    @Override
    public String toString() {
        return super.toString() + " Intereses: " + interesGenerado;
    }
    
    @Override
    public TipoCuenta getTipo(){
        return TipoCuenta.PLAZOFIJO;
    }
    
    
}
