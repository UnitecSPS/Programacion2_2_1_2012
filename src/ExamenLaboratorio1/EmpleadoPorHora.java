/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ExamenLaboratorio1;

import java.util.Scanner;

public class EmpleadoPorHora extends Empleado{

    private double pagoxhora;
    Scanner lea = new Scanner (System.in);

    public EmpleadoPorHora(int c, String n, double ph){
        super (c,n,0);
        pagoxhora = ph;
    }

    public double getPagoExtra() {
        return pagoxhora;
    }

    @Override
    public double pago(){
        System.out.println("Ingrese las horas trabajadas: ");
        int hr = lea.nextInt();
        return pagoxhora * hr;
    }

    @Override
    public String toString() {
        return super.toString() + " pagoExtra=" + pagoxhora;
    }


}
