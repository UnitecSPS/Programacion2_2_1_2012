/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Test {
    public static void main(String args[]){
        Scanner lea = new Scanner(System.in);
        int x;
        
        do{
            try{
                System.out.println("Ingrese Numero: ");
                x = lea.nextInt();
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Se Ingreso Mal el Numero");
                lea.next();
                
            }
        }while(true);
        
        System.out.println("X: " + x);
        
        
        int array[] = new int[5];
        try{
            int pos=lea.nextInt();
            array[pos] = lea.nextInt();
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Ya no hay espacio");
        }
    }
}
