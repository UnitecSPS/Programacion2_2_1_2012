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
public class BancoArraylist implements iBanco {
    private ArrayList<CuentaBancaria> cuentas; 

    public BancoArraylist(){
        cuentas = new ArrayList<CuentaBancaria>();
    }
    
    @Override
    public void agregarCuenta(CuentaBancaria cb) {
        cuentas.add(cb);
    }

    @Override
    public CuentaBancaria getCuenta(int codigo) {
        for(CuentaBancaria cb:cuentas){
            if( cb.getCodigo() == codigo ){
                return cb;
            }
        }
        return null;
    }

    @Override
    public boolean deposito(int codigo, double m) {
        CuentaBancaria cb = getCuenta(codigo);
        if( cb != null ){
            cb.deposito(m);
            return true;
        }
        return false;
    }

    @Override
    public boolean retiro(int codigo, double m) {
        CuentaBancaria cb = getCuenta(codigo);
        if( cb != null ){
            return cb.retiro(m);
        }
        return false;
    }

    @Override
    public boolean transferenciaTerceros(int co, int cd, double m) {
        if( retiro(co,m) ){
            return deposito(cd,m);
        }
        return false;
    }

    @Override
    public boolean setFechaFin(int cod,int y, int m, int d) {
        CuentaBancaria  cb = getCuenta(cod);
        if( cb != null ){
            if(cb instanceof CuentaPlazoFija){
                ((CuentaPlazoFija)cb).setFechaFin(y, m, d);
                return true;
            }
        }
        return false;
    }

    @Override
    public void imprimir() {
        for(CuentaBancaria cb: cuentas)
            System.out.println(cb);
    }

    @Override
    public void exportar(String tipo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
