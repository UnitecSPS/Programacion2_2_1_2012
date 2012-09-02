/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

public enum StatusMovie {
    ESTRENO(55), NORMAL(40), KIDS(30);
    
    
    public  double c;
    StatusMovie(double c){
        this.c=c;
    }
 
    public double getPrecio(){
       return c;
   }
    
}
