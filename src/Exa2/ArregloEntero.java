/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exa2;

import java.util.NoSuchElementException;

/**
 *
 * @author Gotcha
 */
public class ArregloEntero extends ArregloDinamico implements iOpciones {

    public ArregloEntero(String n){
        super(n);
    }
    
    @Override
    public void agregarElemento(Object obj) {
        if( obj instanceof Integer){
            valores.add(obj);
        }
        else
            throw new NoSuchElementException();
    }

    @Override
    public TipoArreglo getTipoArreglo() {
        return TipoArreglo.INTEGER;
    }
    
    public int suma(){
        int s = 0;
        for(Object obj : valores){
            s += (Integer)obj;
        }
        return s;
    }
    
    public double promedio(){
        return suma() / valores.size();
    }

    @Override
    public void imprimirOpciones() {
        System.out.println("Menu Principal");
        System.out.println("1- Sumar");
        System.out.println("2- Promedio");
    }

    @Override
    public void ejecutarOpcion(int opId) throws NoSuchOptionException {
        switch(opId){
            case 1:
                int suma = suma();
                System.out.println("Suma: " + suma);
                break;
            case 2:
                double prom = promedio();
                System.out.println("Promedio: " + prom);
                break;
            default:
                throw new NoSuchOptionException();
        }
    }
    
}
