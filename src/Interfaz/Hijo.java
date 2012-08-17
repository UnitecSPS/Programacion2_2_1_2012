/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author Gotcha
 */
public class Hijo extends Papa implements iBatman, iRobin {
    public Hijo(String n){
        super(n);
    }

    @Override
    public void gastarHerencia() {
        System.out.println("LO GASTARE EN JUEGOS DE PS3");
    }

    @Override
    public void imprimir() {
        System.out.println("PS3!");
    }

    @Override
    public void ayudar() {
        System.out.println("Estoy ocupado jugando PS3!");
    }
}
