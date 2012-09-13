/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Exa2.NoSuchOptionException;
import Exa2.iOpciones;
import Herencia.CuentaBancaria;
import Herencia.CuentaCheques;
import Herencia.CuentaPlazoFija;
import Herencia.DuplicateCodeException;
import Herencia.TipoCuenta;
import Herencia.TipoTransaccion;
import Herencia.iBanco;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.Scanner;

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
 codigo_cheques.bac
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
        rCuentas.seek(0);
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
    
    /***
     * Registrar una transaccion en el archivo log.bac
     * @param cc Codigo de la cuenta bancaria
     * @param t Tipo de la transaccion (DEPOSITO, RETIRO o INTERESES)
     * @param m Monto de la transaccion
     * @throws IOException 
     */
    private void registrarTransaccion(int cc,TipoTransaccion t,double m)throws IOException{
        rLog.seek(rLog.length());
        rLog.writeInt(cc);
        rLog.writeUTF(t.toString());
        rLog.writeLong(new Date().getTime());
        rLog.writeDouble(m);
    }
    
    @Override
    public void agregarCuenta(CuentaBancaria cb){
        try{
            if( !buscarCuenta(cb.getCodigo() )){
                rCuentas.writeInt(cb.getCodigo());
                rCuentas.writeUTF(cb.getTipo().toString());
                rCuentas.writeUTF(cb.getNombre());
                rCuentas.writeDouble(cb.getSaldo());
                rCuentas.writeLong(cb.getFechaInicio().getTime());
                
                if(cb.getTipo() == TipoCuenta.PLAZOFIJO){
                    rCuentas.writeLong( ((CuentaPlazoFija)cb).getFechaFin().getTime() );
                    rCuentas.writeDouble(((CuentaPlazoFija)cb).getInteresGenerado());
                }
                else if( cb.getTipo() == TipoCuenta.CHEQUE){
                    rCuentas.writeInt(((CuentaCheques)cb).getNumChequera());
                }
            }
            else
                throw new DuplicateCodeException(cb.getCodigo());
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    /***
     * Retornar un objeto de CuentaBancaria o CuentaCheques o
     * CuentaPlazoFijo segun el tipo de la cuenta, si esta 
     * existe dentro del archivo binario.
     */
    public CuentaBancaria getCuenta(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deposito(int codigo, double m) {
        try{
            if( buscarCuenta(codigo) ){
                //el puntero esta al inicio del tipo           
                rCuentas.readUTF();
                rCuentas.readUTF();
                long pos = rCuentas.getFilePointer();
                double sal = rCuentas.readDouble();
                rCuentas.seek(pos);//rCuentas.seek(rCuentas.getFilePointer()-8);
                rCuentas.writeDouble(sal + m);
                
                registrarTransaccion(codigo, TipoTransaccion.DEPOSITO, m);
                return true;
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return false;
    }

    @Override
    public boolean retiro(int codigo, double m) {
        try{
            boolean seRetiro = false;
            double saldo = 0;
            
            if( buscarCuenta(codigo) ){
                TipoCuenta tc = TipoCuenta.valueOf(rCuentas.readUTF());
                rCuentas.readUTF();
                saldo = rCuentas.readDouble();
                
                if( tc == TipoCuenta.PLAZOFIJO ){
                        rCuentas.readLong();
                        rCuentas.readLong();
                        saldo = rCuentas.readDouble();
                }
                
                if( saldo > m ){
                    rCuentas.seek(rCuentas.getFilePointer()-8);
                    rCuentas.writeDouble(saldo - m);
                    seRetiro = true;
                    registrarTransaccion(codigo, TipoTransaccion.RETIRO, m);
                }
                
                if( tc == TipoCuenta.CHEQUE ){
                    agregarCheque(codigo, m, seRetiro);
                 }
                
                return seRetiro;
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    /***
     * Transferir efectivo entre cuentas.
     */
    public boolean transferenciaTerceros(int co, int cd, double m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    /**
     * Actualizar la fecha final para un registro de cuenta. Pero
     * este TIENE QUE SER de tipo PLAZOFIJO para poderlo hacer.
     */
    public boolean setFechaFin(int codigo, int y, int m, int d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    /***
     * Registra los intereses segun su tasa de interes a una cueta bancaria 
     * EXISTENTE segun su tipo. Recuerden que las de
     * cheque NO REGISTRAN intereses. Revisen las clases de Cuentas para que
     * miren como es para cada una. Ademas recordar que se registra en el log
     * esta transaccio
     */
    public void agregarIntereses(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void imprimir() {
        try{
            rCuentas.seek(0);
            while(rCuentas.getFilePointer() < rCuentas.length() ){
                int cod = rCuentas.readInt();
                String tipo = rCuentas.readUTF();
                String n = rCuentas.readUTF();
                double sal = rCuentas.readDouble();
                rCuentas.readLong();
                
                System.out.print(cod + "-" + n + "-Lps." + sal + 
                        " - " + tipo);
                
                if(tipo.equals("AHORRO"))
                    System.out.println("");
                else if(tipo.equals("CHEQUE")){
                    System.out.println(" Chequera: " + 
                            rCuentas.readInt());
                    
                }
                else if(tipo.equals("PLAZOFIJO")){
                    rCuentas.readLong();
                    System.out.println(" Intereses: " +
                            rCuentas.readDouble());
                }
                    
                    
                
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    /**
     * EXPORTA TODO EL LISTADO DE CUENTAS BANCARIAS CON TODOS SUS DATOS
     * a un archivo de texto cuya direccion viene de parametro.
     */
    public void exportar(String tipo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void agregarCheque(int cc, double m, boolean c) {
        try{
            String archivo = cc + "_cheques.bac";
            RandomAccessFile rCheque = new RandomAccessFile(archivo,"rw");
            
            rCheque.seek(rCheque.length());
            rCheque.writeInt( getCodigo() );
            rCheque.writeDouble(m);
            rCheque.writeLong(new Date().getTime());
            rCheque.writeBoolean(c);
            
            rCheque.close();
            
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage() );
        }
    }

    @Override
    public void imprimirOpciones() {
        System.out.println("1- Imprimir Cheques");
        
        /**
         * Hay mas opciones:
         * 2- Imprimir Log (Imprime todo el detalle del log desde una fecha
         *   de inicio hasta el presente. Ademas imprime el monto total de
         *   depositos, retiros o intereses.
         * 3- Tops Cuenta (Imprime el codigo y nombre de la cuenta que mas 
         *   efectivo deposito entre una fecha de inicio al presente, ademas
         *  de la cuenta que mas retiro efectivo)
         * 
         */
    }

    @Override
    public void ejecutarOpcion(int opId) throws NoSuchOptionException {
        switch(opId){
            case 1:
                imprimirCheques();
                break;
            default:
                throw new NoSuchOptionException();
        }
    }

    private void imprimirCheques() {
        try{
            Scanner lea = new Scanner(System.in);
            System.out.print("Numero de Cuenta: ");
            int nc = lea.nextInt();
            
            if( buscarCuenta(nc) ){
                if( rCuentas.readUTF().equals("CHEQUE")){
                    String archivo = nc + "_cheques.bac";
                    RandomAccessFile rCheque = new RandomAccessFile(archivo,"rw");
                     
                    while(rCheque.getFilePointer() < rCheque.length() ){
                        int n = rCheque.readInt();
                        double m = rCheque.readDouble();
                        long f = rCheque.readLong();
                        boolean ca = rCheque.readBoolean();
                        
                        System.out.println(n + "- Lps." + m +
                                (ca ? " CAMBIADO EN " : " REBOTADO EN ") +
                                new Date(f));
                    }
                }
                else
                    System.out.println("CUENTA NO ES DE CHEQUES");
            }
            else
                System.out.println("CUENTA NO EXISTE");
            
        }catch(IOException e){
            
        }
    }
    
}
