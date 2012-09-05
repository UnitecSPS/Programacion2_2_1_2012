/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Exa2.NoSuchOptionException;
import Exa2.iOpciones;
import Herencia.CuentaBancaria;
import Herencia.DuplicateCodeException;
import Herencia.TipoCuenta;
import Herencia.iBanco;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Gotcha
 * 
 * CUENTAS.bac
 * --------------
 * int cod
 * String tipo
 * String nom
 * double sal
 * long fecha
 * long fechafin*
 * double intgana*
 * int numchequera*
 * 
 * codigo_cheques.bac
 * ---------------------
 * int num
 * double m
 * long fecha
 * boolean cambiado
 * 
 * log.bac
 * ------------
 * int codigo
 * String tipo
 * long fecha
 * double m
 */
public class BancoBinario implements iBanco, iOpciones{
    
    private RandomAccessFile rCuentas;
    private RandomAccessFile rLog;
    
    public BancoBinario(){
        try{
            rCuentas = new RandomAccessFile("cuentas.bac","rw");
            rLog = new RandomAccessFile("log.bac","rw");
            initCodigos();
        }catch(IOException e){
            
        }
    }
    
    public final void initCodigos()throws IOException{
       RandomAccessFile rCod = new RandomAccessFile("codigos.bac","rw");
       if( rCod.length() == 0 )
           rCod.writeInt(1);
       rCod.close();
    }
    
    public int getCodigo()throws IOException{
        RandomAccessFile rCod = new RandomAccessFile("codigos.bac","rw");
        int cod = rCod.readInt();
        rCod.seek(0);
        rCod.writeInt(cod+1);
        rCod.close();
        return cod;
    }

    public boolean buscarCuenta(int cuenta)throws IOException{
        
        while(rCuentas.getFilePointer() < rCuentas.length()){
            if( cuenta == rCuentas.readInt() )
                return true;
            TipoCuenta tc = TipoCuenta.valueOf( rCuentas.readUTF() );
            rCuentas.readUTF();//nombre;
            rCuentas.readDouble();//saldo
            rCuentas.readLong();
            
            if( tc == TipoCuenta.PLAZOFIJO ){
                rCuentas.readLong();
                rCuentas.readDouble();
            }
            else if( tc == TipoCuenta.CHEQUE){
                rCuentas.readInt();
            }
        }
        
        return false;
    }
    
    @Override
    public void agregarCuenta(CuentaBancaria cb){
        try{
            if( buscarCuenta(cb.getCodigo() )){

            }
            else
                throw new DuplicateCodeException(cb.getCodigo());
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public CuentaBancaria getCuenta(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deposito(int codigo, double m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retiro(int codigo, double m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean transferenciaTerceros(int co, int cd, double m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean setFechaFin(int codigo, int y, int m, int d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void agregarIntereses(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void imprimir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exportar(String tipo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void agregarCheque(int cb, int nc, double m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pagarCheque(int cb, int nc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void imprimirOpciones() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ejecutarOpcion(int opId) throws NoSuchOptionException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
