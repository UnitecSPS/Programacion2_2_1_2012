/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen1;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class PlanBlackBerry extends Plan{
    private String pin;
    private ArrayList<String> bbm;
    
    public PlanBlackBerry(int nt,String n,String pin){
        super(nt,n);
        this.pin = pin;
        bbm = new ArrayList<String>();
    }

    public String getPin() {
        return pin;
    }

    @Override
    public double pagoMensual(int cmins, int cmsgs) {
        double plan = 40 * TASA_CAMBIO;
        double consumoMin = 0, consumoMsg = 0;
        
        if( cmins > 200 )
            consumoMin = (cmins - 200) * 15;
        if( cmsgs > 300 )
            consumoMsg = (cmsgs - 300 ) * 8;
        
        return plan + consumoMin + consumoMsg;
    }

    @Override
    public String toString() {
        return super.toString() + " pin=" + pin;
    }
    
    public void addPinAmigo(String pin){
        if( !bbm.contains(pin))
            bbm.add(pin);
    }
    
    
}
