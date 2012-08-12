/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ExamenLaboratorio1;

import java.util.Calendar;

public class EmpleadoVentas extends Empleado{
    private double ventas[];
    private double tasaVenta;

    public EmpleadoVentas (int c, String n, double s){
        super(c,n,s);
        ventas = new double[12];
        for(int x=0; x < 10; x++)
            ventas[x] = 0;
        tasaVenta = 0.05;
    }

    public void setTasaVenta(double tasaVenta) {
        this.tasaVenta = tasaVenta;
    }

    public void actualizarVenta (double v){
        int month = Calendar.getInstance().get(Calendar.MONTH);
        ventas[month] += v;
    }

    @Override
    public double pago(){
        int month = Calendar.getInstance().get(Calendar.MONTH);
        //la venta del mes por la tasa + salario - rap
        return (ventas[month] * tasaVenta) + super.pago();
    }

    public double ventaAnual(){
        return ventaAnual(0);
    }
    
    public double ventaAnual(int pos){
        if (pos < ventas.length)
                return ventas[pos] + ventaAnual(pos+1);
        return 0;
    }
}
