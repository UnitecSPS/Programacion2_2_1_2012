/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ExamenLaboratorio1;

import java.util.ArrayList;
import java.util.Scanner;


public class Empresa {
    public static ArrayList<Empleado> empleados;
    public static Scanner lea = new Scanner (System.in);

  public static void main (String args[]){
        empleados = new ArrayList<Empleado>();
        int resp;

        do{
            System.out.println("1. Agegar Empleado");
            System.out.println("2. Pagar Empleado");
            System.out.println("3. Registar Venta");
            System.out.println("4. Imprimir");
            System.out.println("5. Salir");
            System.out.println("\nEscoja opcion: ");
            resp = lea.nextInt();

            switch( resp ){
                case 1:
                    System.out.println("Codigo del empleado: ");
                    int c = lea.nextInt();
                    System.out.println("Nombre del empleado: ");
                    String n = lea.next();
                    System.out.println("Tipo de Empleado");
                    String t = lea.next();
                    agregarEmpleado(c, n, TipoEmpleado.valueOf(t));
                    break;
                case 2:
                    System.out.println("Codigo del empleado: ");
                    pagarEmpleado(lea.nextInt());
                    break;
                case 3:
                    System.out.println("Codigo del empleado: ");
                    int cc = lea.nextInt();
                    System.out.println("Total venta: ");
                    double v = lea.nextDouble();
                    registrarVenta(cc,v);
                    break;
                case 4:
                    imprimir();
                    break;
            }
        }while( resp != 5);
    }

    private static int buscarCodigo(int c){
        for (int e=0; e < empleados.size(); e++){
            if (empleados.get(e).getCodigo() == c)
                return e;
        }
        return -1;
    }

    private static void agregarEmpleado(int c, String n, TipoEmpleado tipo){
         if (buscarCodigo(c) == -1){
            switch(tipo){
                case POR_SALARIO:
                    System.out.println("Ingrese el salario: ");
                    double sal = lea.nextDouble();
                    empleados.add(new Empleado(c,n,sal));
                case POR_HORA:
                    System.out.println("Ingrese el pago por hora: ");
                    double ph = lea.nextDouble();
                    empleados.add(new EmpleadoPorHora(c,n,ph));
                case POR_COMISION:
                    System.out.println("Ingrese el salario: ");
                    double s = lea.nextDouble();
                    empleados.add(new EmpleadoVentas(c,n,s));
                default:
                    System.out.println("TIPO INCORRECTO");
            }
        }
        else
            System.out.println("EL codigo YA existe");
    }

    private static double pagarEmpleado(int c){
        int pos = buscarCodigo(c);
        if( pos >= 0 )
            return empleados.get(pos).pago();
        return 0;
    }

    private static void registrarVenta(int c, double m){
       for (Empleado p : empleados)
            if (p.codigo == c && p instanceof EmpleadoVentas ){
                ((EmpleadoVentas)p).actualizarVenta(m);
                break;
            }
    }

    private static void imprimir(){
        int e = 0, eh = 0, ev = 0;
        for (Empleado p: empleados){
            System.out.println(p);
            if (p instanceof EmpleadoPorHora)
                eh++;
            else if (p instanceof EmpleadoVentas)
                ev++;
            else
                e++; //lo pongo de ultimo porque las hijas TAMBIEN
            // son de tipo Empleado
        }

        System.out.println("Empleados normales: " + e);
        System.out.println("Empleados por Hora: " + eh);
        System.out.println("Empleados por venta: " + ev);
    }
}

