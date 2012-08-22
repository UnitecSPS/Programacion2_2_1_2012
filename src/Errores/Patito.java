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
public class Patito {
    public void test()throws PolloDanceException{
        try{
            Scanner lea = new Scanner(System.in);
            String x = lea.next();
            
            if( x.equalsIgnoreCase("DORMIDO"))
                throw new PolloDanceException();
        }
        catch(NullPointerException e){
            System.out.println("Instancia el Scanner!");
        }
        catch(InputMismatchException e){
            System.out.println("No escribiste bien");
        }
        finally{
            System.out.println("FINALLY");
        }
        
        System.out.println("Aqui continuo");
    }
}
