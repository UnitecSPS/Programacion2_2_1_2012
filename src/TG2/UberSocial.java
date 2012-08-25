/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class UberSocial {
    private static ArrayList<iSocial> cuentas = new ArrayList<iSocial>();
    private static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        int op = 6;
        //lea.useDelimiter(System.getProperty("line.separator"));
        
        do{
            try{
                System.out.println("1- Agregar Cuenta");
                System.out.println("2- Agregar Amigo");
                System.out.println("3- Informacion de Usuario");
                System.out.println("4- Agregar Post");
                System.out.println("5- Agregar Comentario");
                System.out.println("6- Salir");
                System.out.print("\nEscoja una opcion: ");
                op = lea.nextInt();

                switch(op){
                    case 1:
                        System.out.print("Ingrese Username: ");
                        agregarCuenta(lea.next());
                        break;
                    case 2:
                        System.out.println("Id de usuario: ");
                        int user = lea.nextInt();
                        System.out.println("Id de Amigo: ");
                        int friend = lea.nextInt();
                        agregarAmigo(user, friend);
                        break;
                    case 3:
                        System.out.println("Id de usuario: ");
                        user = lea.nextInt();
                        verInfo(user);
                        break;
                    case 4:
                        System.out.println("Id de usuario: ");
                        user = lea.nextInt();
                        agregarPost(user);
                        break;
                    case 5:
                        System.out.println("Id de usuario: ");
                        user = lea.nextInt();
                        System.out.println("Id de Post: ");
                        int post = lea.nextInt();
                        agregarComentario(user,post);
                        break;
                    default:
                        System.out.println("ADIOS!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Escriba bien!");
                lea.next();
            }
        }while( op != 6);
    }

    private static void agregarCuenta(String user) {
        System.out.println("De que tipo? FACEBOOK o TWITTER: ");
        String tipo = lea.next();
        
        for(iSocial cuenta : cuentas){
            //si el usuario ya existe para el mismo tipo de cuenta
            if( cuenta.getUsername().equals("user")){
                if(cuenta instanceof Facebook && tipo.equalsIgnoreCase("FACEBOOK") ||
                   cuenta instanceof Twitter && tipo.equalsIgnoreCase("TWITTER")){
                    System.out.println("Username ya existe");
                    return;
                }
            }
        }
        
        if(tipo.equalsIgnoreCase("FACEBOOK"))
            cuentas.add( new Facebook(user) );
        else if( tipo.equalsIgnoreCase("TWITTER"))
            cuentas.add( new Twitter(user) );
        else
            System.out.println("TIPO INCORRECTO");
    }

    private static void agregarAmigo(int user, int friend) {
        try{
           if( user == friend ){
               System.out.println("No se puede agregar uste solo!");
               return;
           }
           
           iSocial userCuenta = cuentas.get(user);
           iSocial friendCuenta = cuentas.get(friend);
           
           userCuenta.addFriend(friend);
           
           if(userCuenta instanceof Facebook)
               friendCuenta.addFriend(user);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Id de user o Friend no existe");
        }        
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void verInfo(int user) {
        try{
            cuentas.get(user).viewMyInfo();
        }catch(Exception e){
            System.out.println("usuario no existe");
        }
    }

    private static void agregarPost(int user) {
        try{
            System.out.println("Escriba el Mensaje: ");
            String msg = lea.next();
            cuentas.get(user).createPost(msg);
        }catch(Exception e){
            System.out.println("usuario no existe");
        }
    }

    private static void agregarComentario(int user, int post) {
        try{
            iSocial cuenta = cuentas.get(user);
            if( cuenta instanceof Facebook ){
                System.out.println("Escriba su comentario: ");
                String comment = lea.next();
                ((Facebook)cuenta).addComment(post, comment);
            }
            else
                System.out.println("NO PUEDES AGREGAR COMENTARIO");
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
