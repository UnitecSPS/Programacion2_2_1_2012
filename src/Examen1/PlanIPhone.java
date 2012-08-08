/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen1;

/**
 *
 * @author Gotcha
 */
public class PlanIPhone extends Plan {
    private String email;
    
    public PlanIPhone(int nt,String n,String e){
        super(nt,n);
        email = e;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public double pagoMensual(int cmins, int cmsgs) {
        double planlps = 22 * TASA_CAMBIO;
        double consumo = cmins * 20 + cmsgs * 5;
        return planlps + consumo;
    }

    @Override
    public String toString() {
        super.toString();
        return super.toString() + " email=" + email;
    }
    
    
}
