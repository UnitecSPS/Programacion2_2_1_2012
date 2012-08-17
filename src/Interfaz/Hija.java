/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.io.Serializable;

/**
 *
 * @author Gotcha
 */
public class Hija extends Papa implements iBatman, iRobin, Serializable {
    public Hija(String n){
        super(n);
    }

    @Override
    public void gastarHerencia() {
        System.out.println("Gastarlo yendo a Barcelona a ver a MESSI");
    }
    
    public int edad(){
        return 30;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public void ayudar() {
        System.out.println("Decir que no al ing, pues si");
    }
}
