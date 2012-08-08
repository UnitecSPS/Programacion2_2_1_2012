/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Tigo {
    static ArrayList<Plan> planes = new ArrayList<Plan>();
    
    public static void main(String args[]){
        //planes
        addPlan(995,"Dany", "BLACKBERRY" );
        addPlan(996,"Jean", "IPHONE");
        addPlan(997,"Angela","IPHONE");
        addPlan(998,"Willian","IPHONE");
        addPlan(999,"Dennis","IPHONE");
        addPlan(994,"Edwin","BLACKBERRY");
        
        imprimir();
        
        int pos = planes.indexOf(new Plan(994,""));
        if( pos >= 0 ){
            System.out.println("Encontre el telefono en la pos: " + pos);
            System.out.println(planes.get(pos));
        }
        else
            System.out.println("NO EXISTE TELEFONO");
    }
    
    public static boolean busqueda(int nt,String extra,String tipo){
        return busqueda(nt,extra,tipo,0);
    }
    private static boolean busqueda(int nt,String extra,String tipo,int pos){
        if( pos < planes.size() ){
            Plan p = planes.get(pos);
                    
            if(p.getNumTel() == nt )
                return true;
            
            if(p instanceof PlanIPhone && tipo.equals("IPHONE")){
                if(extra.equals( ((PlanIPhone)p).getEmail() ))
                    return true;
            }
            
            if(p instanceof PlanBlackBerry && tipo.equals("BLACKBERRY")){
                if(extra.equals(((PlanBlackBerry)p).getPin()))
                    return true;
            }
            
            
            return busqueda(nt,extra,tipo,pos+1);
        }
        return false;
    }
    
    public static void addPlan(int nt, String n, String tipo){
        Scanner lea = new Scanner(System.in);
        
        if(tipo.equals("IPHONE")){
            System.out.println("Email: ");
            String email = lea.next();
            
            if(!busqueda(nt,email,tipo)){
                planes.add( new PlanIPhone(nt,n,email));
            }
        }
        else if(tipo.equals("BLACKBERRY")){
            System.out.println("PIN: ");
            String pin = lea.next();
            
            if(!busqueda(nt,pin,tipo)){
                PlanBlackBerry pb = new PlanBlackBerry(nt, n, pin);
                planes.add( pb );
            }
        }
        else
            System.out.println("TIPO INCORRECTO");
    }
    
    public static double pagoPlan(int nt,int mins,int msgs){
        /*int pos = planes.indexOf(nt);
        if( pos > 0 )
            return planes.get(pos).pagoMensual(mins, msgs);
        return 0;
        ///*/
        for(Plan p : planes){
            if( p.getNumTel() == nt)
                return p.pagoMensual(mins, msgs);
        }
        return 0;
    }
    
    public static void addAmigo(int nt,String pin){
       for(Plan p : planes){
            if( p.getNumTel() == nt){
                if( p instanceof PlanBlackBerry ){
                    ((PlanBlackBerry)p).addPinAmigo(pin);
                }
            }
                
        } 
    }
    
    public static void imprimir(){
        for(Plan p : planes)
            System.out.println(p);
    }
}
