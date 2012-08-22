/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

/**
 *
 * @author Gotcha
 */
public class Granja {
    public static void main(String args[]){
        Patito p = new Patito();
        //p.test();
        try{
            p.test();
        }
        catch(PolloDanceException e){
            System.out.println("A BAILAR!: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("ERROR EN PATITO: " + e.getMessage());
        }
        System.out.println("FIN MAIN");
    }
}
