/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

public enum TipoConsola {
   
    XBOX(60), PS3(60), PSVITA(50) ,  WII(45);
      public double p;
      
   TipoConsola(double p){
        this.p=p;
    }
   
   public double getPrecio(){
       return p;
   }
     
   
}
