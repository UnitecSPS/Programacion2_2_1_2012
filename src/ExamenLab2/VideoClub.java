/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Oscar
 */
public class VideoClub {
    static ArrayList<ITEMRenta> items;
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        items = new ArrayList<ITEMRenta>();
        int op;
        
        do{
            System.out.println("1- Agregar Item");
            System.out.println("2- Generar renta");
            System.out.println("3- Ingresar Actores");
            System.out.println("4- Imprimir Inventario");
            System.out.println("5- Salir");
            System.out.println("Ingrese Opcion: ");
            op = lea.nextInt();
            
            try{
                switch(op){
                    case 1:
                        System.out.println("Tipo: ");
                        agregarItem(TipoItem.valueOf(lea.next()));
                        break;
                    case 2:
                        System.out.println("Dias: ");
                        int dias = lea.nextInt();
                        System.out.println("Codigo: ");
                        int cod = lea.nextInt();
                        generarRenta(dias, cod);
                        break;
                    case 3:
                        System.out.println("Codigo: ");
                        cod = lea.nextInt();
                        System.out.println("Cantidad: ");
                        int cant = lea.nextInt();
                        ingActores(cod, cant);
                        break;
                    case 4:
                        listar();
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }while(op != 5);
    }
    
    private static void agregarItem(TipoItem tipo){
        System.out.println("Nombre: ");
        String nombre = lea.next();
        System.out.println("Codigo: ");
        int codigo = lea.nextInt();
        System.out.println("Copias: ");
        int copias=lea.nextInt();
        
        switch(tipo){
            case DVD:
               items.add(new DVD_RENTA(nombre, codigo, copias));
               break;          
            case GAME:
                System.out.println("Ingrese Tipo: ");
                String tipoc = lea.next();
                items.add(new GameRenta(nombre, codigo, copias, TipoConsola.valueOf(tipoc)));
                break;
            default :
                   System.out.println("No puede agregar ese tipo");      
        } 
    }
    
    private static void generarRenta(int dias,int cod){
        for(ITEMRenta ir : items){
            if( ir.getCodigo() == cod ){
                if( ir.getCopias() > 0 ){
                    System.out.println("Pagar: " + ir.generarRenta(cod));
                    return;
                }
                else
                    throw new EmptyStackException();
            }
        }
        
        throw new NoSuchElementException("No Existe ese Item");
    }
    
    private static void ingActores(int cod, int cant){
      for(ITEMRenta i: items){
          if(i.getCodigo()==cod && i instanceof DVD_RENTA){
              ((DVD_RENTA)i).ingresarActores(cant);          
          }
      }
                
    }
    
    private static void listar(){
        int cdvd = 0, cgame = 0;
        for(ITEMRenta ir : items ){
            System.out.println(ir);
            
            if(ir instanceof DVD_RENTA)
                cdvd++;
            else
                cgame++;
        }
        System.out.println("Total DVDs: " + cdvd);
        System.out.println("Total Games: " + cgame);
    }
    
}
