/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

public class GameRenta extends ITEMRenta {
    
    public TipoConsola consola;
    
    public GameRenta(String n, int c, int co, TipoConsola consola){
        super(n, c, co);
        this.consola= consola;
    }
    
    @Override
    public double generarRenta(int d) {
        double total = consola.getPrecio();
        
        switch(consola){
            case PS3:
            case XBOX:
                if( d > 3 )
                    total += total * 0.6 * (d - 3);
                break;
            case WII:
                if( d > 5 )
                    total += total * 0.5 * (d-5);
                break;
            case PSVITA:
                if( d > 5 )
                    total += total * 0.4 * (d-5);
        }
        copias--;
        return total;
    }

    @Override
    public TipoItem getTipoItem() {
        return TipoItem.GAME;
    }

    @Override
    public String toString() {
        return super.toString() + "consola=" + consola + '}';
    }
    
    
}
