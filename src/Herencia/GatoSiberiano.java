/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class GatoSiberiano extends Gato{
    
    private GatoSiberiano(){
        super("Siberiano");
    }

    @Override
    public void hablar() {
        System.out.println("MI MI MI");
    }
    
    public static void frio(){
        System.out.println("FRIO");
    }
}
