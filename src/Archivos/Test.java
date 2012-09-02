/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Gotcha
 */
public class Test {
    public static void main(String args[]){
        
        File f = new File("juana");
        
        if( f.exists() ){
            System.out.println("EXISTE");
            System.out.println("Nombre: " + f.getName());
            System.out.println("Papa: " + f.getAbsoluteFile().getParent());
            System.out.println("Absolta: " + f.getAbsolutePath());
            System.out.println("Mide: " + f.length());
            
            if( f.delete() )
                System.out.println("Se borro!");
            else
                System.out.println("NO SE BORRO");
        }
        else{
            System.out.println("NO EXSTE");
            try{
                if(f.createNewFile())
                    System.out.println("SE CREO BIEN");
                else
                    System.out.println("NO SE CREO");
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
                
        }
    }
}
