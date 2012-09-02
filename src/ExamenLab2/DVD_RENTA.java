/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

import java.util.Scanner;


public class DVD_RENTA extends ITEMRenta {
    public StatusMovie status;
    public String actores[];
    private Scanner  lea = new Scanner(System.in);
    
    
    public DVD_RENTA(String n, int c, int co){
        super(n, c , co);
        status = StatusMovie.ESTRENO;
    }
    
    public final void setStatusMovie(String stat){
        status = StatusMovie.valueOf(stat);
    }
    
    public void ingresarActores(int cant){
        actores = new String[cant];
        
        for(int x =0; x<cant ; x++){
           actores[x] = lea.next();
        }
    }
    
    @Override
    public double generarRenta(int dias) {
       double total =status.getPrecio();
       
       if(dias > 2)
           total += status.getPrecio() * 0.8 * (dias-2);
       
       copias--;
       return total;
    }

    @Override
    public TipoItem getTipoItem() {
        return TipoItem.DVD;
    }
    public void listarActores(){
        for(String a: actores){
            System.out.println("Nombre del Actor: "+ a);
        }
    }

    @Override
    public String toString() {
      return super.toString() + " Status: " + status;
    }
    
    
    
}
