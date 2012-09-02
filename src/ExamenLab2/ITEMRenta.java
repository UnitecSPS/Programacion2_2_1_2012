/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

public abstract class ITEMRenta {
    protected  String nombre;
    protected int codigo;
    protected int copias;
    
    
    public ITEMRenta(String n, int c, int co){
        nombre=n;
        codigo=c;
        copias =co;
    
    }

    public final int getCodigo() {
        return codigo;
    }

    public final int getCopias() {
        return copias;
    }

    public final String getNombre() {
        return nombre;
    }
    
    public abstract double generarRenta(int d);
    public abstract TipoItem getTipoItem();

    @Override
    public String toString() {
        String datos= "Nombre: "+ nombre+ "-"+ "Codigo: "+  codigo +" Copias: "+ copias;
        return datos;
    }
    
}
