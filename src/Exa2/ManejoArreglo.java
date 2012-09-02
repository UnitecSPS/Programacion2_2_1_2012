/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exa2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class ManejoArreglo {
    static ArrayList<ArregloDinamico> arreglos = new ArrayList<ArregloDinamico>();
    
    public static void agregarArreglo(TipoArreglo tipo){
        switch(tipo){
            case INTEGER:
                arreglos.add( new ArregloEntero("Set"));
                break;
            case STRING:
                arreglos.add( new ArregloString() );
                break;
            case CHAR:
                arreglos.add( new ArregloCaracter());
                break;
            case BOOLEAN:
                arreglos.add( new ArregloBoolean());
                break;
            case DOUBLE:
                arreglos.add( new ArregloDouble());
        }
    }
    
    public static void agregarElemento(int pos,Object valor){
        try{
            arreglos.get(pos).agregarElemento(valor);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    public static void subMenu(int pos){
        Scanner lea = new Scanner(System.in);
        try{
            ArregloDinamico ad = arreglos.get(pos);
            ((iOpciones)ad).imprimirOpciones();
            System.out.println("Escoja opcion: ");
            int op = lea.nextInt();
            
            ((iOpciones)ad).ejecutarOpcion(op);
            
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
