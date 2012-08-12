/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public abstract class Animal {
    protected int patas;
    protected boolean isMamifero;
    protected String nombre;
    
    public Animal(String n,int p,boolean im){
        patas = p;
        nombre = n;
        isMamifero = im;
    }

    public boolean isIsMamifero() {
        return isMamifero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPatas() {
        return patas;
    }

    @Override
    public String toString() {
        return "Animal{" + "patas=" + patas + ", isMamifero=" + isMamifero + ", nombre=" + nombre + '}';
    }
    
    public abstract void hablar();
}
