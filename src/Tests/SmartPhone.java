/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

/**
 *
 * @author Gotcha
 */
public class SmartPhone extends Phone {
    private boolean tieneInternet;
    public static String SUPPORT_WIFI = "Wi-Fi 802.11 b/g/n";
    
    public SmartPhone(int nt,String s,boolean ti){
        super(nt,s);
        tieneInternet = ti;
    }
}
