/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import Archivos.BancoBinario;   
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class GotchaBank {
    static iBanco banco;
    static Scanner lea = new Scanner(System.in);
    
    static{
        banco = new BancoBinario();
    }
    
    public static void main(String args[]){
        int op;
        
        do{
            System.out.println("1- Agregar Cuenta");
            System.out.println("2- Depositar en Cuenta");
            System.out.println("3- Retirar de Cuenta");
            System.out.println("4- Transferencias a terceros");
            System.out.println("5- Configurar Fecha Fin");
            System.out.println("6- Registrar Intereses");
            System.out.println("7- Imprimir");
            System.out.println("8- Salir");
            System.out.print("\nEscoja Opcion: ");
            op = lea.nextInt();
            
            switch( op ){
                case 1:
                    System.out.println("Ingrese Codigo: ");
                    int cod = lea.nextInt();
                    System.out.println("Ingrese Nombre: ");
                    String n = lea.next();
                    System.out.println("Ingrese tipo: ");
                    String tipo = lea.next();
                    
                    addCuenta(cod,n,tipo);
                    break;
                case 2:
                    System.out.println("Ingrese Codigo: ");
                    cod = lea.nextInt();
                    System.out.println("Monto: ");
                    double m = lea.nextDouble();
                    
                    if( banco.deposito(cod, m))
                        System.out.println("Se deposito bien");
                    else
                        System.out.println("No se pudo depositar");
                    break;
                case 3:
                    retirar();
                    break;
                case 4:
                    transferencias();
                    break;
                case 5:
                    System.out.print("Codigo: ");
                    cod = lea.nextInt();
                    
                    configuarFechaFin(cod);
                    break;
                case 6:
                    intereses();
                    break;
                case 7:
                    banco.imprimir();
                    break;
                    
                            
            }
        }while(op!= 8);
    }
    
    public static void addCuenta(int nc,String n,String tip){
        try{
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
        catch(IllegalArgumentException e){
            System.out.println("TIPO DE CUENTA INCORRECTO");
        }
        catch(DuplicateCodeException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void configuarFechaFin(int nc){
        System.out.println("Ingrese Anio: ");
        int y = lea.nextInt();
        System.out.println("INgrese mes: ");
        int m = lea.nextInt();
        System.out.println("Ingrese el dia: ");
        int d = lea.nextInt();
        
        if( banco.setFechaFin(nc, y, m, d) )
            System.out.println("SE HIZO BIEN");
        else
            System.out.println("NO SE PUDO HACER");
    }

    private static void retirar() {
        System.out.print("Codigo: ");
        int cod = lea.nextInt();
        System.out.print("Monto: ");
        double m = lea.nextDouble();
        
        if( banco.retiro(cod, m) )
            System.out.println("Se pudo retirar");
        else
            System.out.println("No se pudo retirar");
    }

    private static void transferencias() {
        System.out.print("Codigo Origen: ");
        int codo = lea.nextInt();
        System.out.print("Codigo Destino: ");
        int codd = lea.nextInt();
        System.out.print("Monto: ");
        double m = lea.nextDouble();
        
        if( banco.transferenciaTerceros(codo, codd, m) )
            System.out.println("Se pudo Transferir");
        else
            System.out.println("No se pudo trasnferir");
    }

    private static void intereses() {
        System.out.print("Codigo: ");
        int cod = lea.nextInt();
        banco.agregarIntereses(cod);
    }
}
