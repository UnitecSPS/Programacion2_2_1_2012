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
public interface iBanco extends Imprimible {
    
    int VERSION_IBANCO = 55665;
    /**
     * Esta funcion es para agregar una cuenta
     * @param cb Cuenta Bancaria para agregar
     * @throws DuplicateCodeException Por codigo duplicado
     */
    void agregarCuenta(CuentaBancaria cb);
    
    /**
     * Devuelve el OBJETO CuentaBancaria segun su codigo
     * @param codigo Codigo de la cuenta
     * @return El objecto Cuenta o <code>null</code>
     * si no existe un objeto cuenta con ese codigo
     */
    CuentaBancaria getCuenta(int codigo);
    
    boolean deposito(int codigo,double m);
    
    boolean retiro(int codigo,double m);
    
    /**
     * Transferir un monto entre Cuentas
     * @param co Cuenta Origen
     * @param cd Cuenta destino
     * @param m Monto a depositar
     * @return <code>true</code>Si la operacion se hizo satisfactoriamente
     */
    boolean transferenciaTerceros(int co,int cd,double m);
    
    /**
     * Configura la fecha final especial para una CuentaPlazoFija
     * @param codigo
     * @param y ANIO
     * @param m MES
     * @param d DIA
     * @return 
     */
    boolean setFechaFin(int codigo,int y,int m,int d);
    
    /**
     * Registra los intereses ganados para una cuenta
     * @param codigo Codigo de la cuenta
     */
    void agregarIntereses(int codigo);
    
    void agregarCheque(int cb,int nc,double m);
    void pagarCheque(int cb,int nc);
}
