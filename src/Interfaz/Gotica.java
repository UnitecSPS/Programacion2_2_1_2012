/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author Gotcha
 */
public class Gotica {
    public static void main(String args[]){
        Papa p = null;
        
        String tipo = "HIJO";
        
        if( tipo.equals("HIJA")){
            p = new Hija("Angela");
            //edad
            int e = ((Hija)p).edad();
            System.out.println("Edad: " + e);       
        }
        else{
            p = new Hijo("Oscar");
        }
        
        //llamar a gh
        p.gastarHerencia();
        
        //imprimir
        if( p instanceof iBatman)
            ((iBatman)p).imprimir();
        //ayudar
        if( p instanceof iRobin)
            ((iRobin)p).ayudar();
    }
}
