/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

/**
 *
 * @author Gotcha
 */
public class Batalla {
    
    public static int numPlaneta;
    
    public static void patito(){
        System.out.println("PATITO");
    }
    
    public static void main(String args[]){
        numPlaneta = 6;
        patito();
        
        Marciano m1 = new Marciano("ALF");
        Marciano m2 = new Marciano("MARVIN");
        Marciano m3 = new Marciano("MESSI");
        Marciano m4 = new Marciano("JEAN");
        Marciano m5 = new Marciano("GOTCHA");
        
        System.out.println(Marciano.CONT);
        m1.atacar();
        m2.atacar();
        m3.atacar();
        m4.atacar();
        m5.atacar();
    }
}
