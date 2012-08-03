/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

/**
 *
 * @author Gotcha
 */
public class Phone {
    protected int numTel;
    protected String serie;
    
    public Phone(int nt, String s){
        numTel = nt;
        serie = s;
    }
    
    @Override
    public String toString(){
        return numTel + " - " + serie;
    }
}
