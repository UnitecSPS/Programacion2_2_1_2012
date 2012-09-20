/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen3;

import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class CallOfDuty {
    RandomAccessFile rPlayers;
    
    public CallOfDuty(){
        try{
            rPlayers = new RandomAccessFile("CODOnlinePlayers.cod", "rw");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public int generateCode()throws IOException{
        RandomAccessFile rCod = new RandomAccessFile("CODOnlineCodes.cod", "rw");
        
        int cod = 1;
        if( rCod.length() == 0 ){
            rCod.writeInt(cod);
        }
        else{
            cod = rCod.readInt();
            rCod.seek(0);
            rCod.writeInt(cod + 1);
        }
        rCod.close();
        return cod;
    }
    
    public boolean addPlayer(String nick)throws IOException{
        rPlayers.seek(rPlayers.length());
        rPlayers.writeInt( generateCode() );
        rPlayers.writeUTF(nick);
        rPlayers.writeInt(0);
        rPlayers.writeBoolean(true);
        return true;
    }
    
    public boolean addPoints(int cp, int totalpoints)throws IOException{
        rPlayers.seek(0);
        
        while(rPlayers.getFilePointer() < rPlayers.length()){
            int cod = rPlayers.readInt();
            String n = rPlayers.readUTF();
            long pos = rPlayers.getFilePointer();
            int points = rPlayers.readInt();
            
            if( rPlayers.readBoolean()){
                if( cod == cp ){
                    //encontraron el jugador
                    int ptos = points + totalpoints;
                    rPlayers.seek(pos);
                    rPlayers.writeInt(ptos);
                    
                    System.out.println(n + " tiene " + ptos +
                             " puntos");
                    return true;
                }
            }
        }
        return false;
    }
    
    public void topPlayer()throws IOException{
        rPlayers.seek(0);
        int mayor = -1;
        String user = "";
        
        while(rPlayers.getFilePointer() < rPlayers.length() ){
            rPlayers.readInt();
            String n = rPlayers.readUTF();
            int ptos = rPlayers.readInt();
            
            if( rPlayers.readBoolean() ){
                if( ptos > mayor){
                    mayor = ptos;
                    user = n;
                }
            }
        }
        
        System.out.println("El jugador con mas puntos es: " +
                user + " con " + mayor + " ptos.");
    }
    
    public void addBatchPlayers(String txtFile)throws IOException{
        FileReader fr = new FileReader(txtFile);
        Scanner lector = new Scanner(fr);
        
        while(lector.hasNext()){
            addPlayer( lector.next() );
        }
    }
    
    public void imprimir()throws IOException{
        imprimir(0);
    }

    private void imprimir(long pos)throws IOException {
        rPlayers.seek(pos);
        if( rPlayers.getFilePointer() < rPlayers.length()){
            int c = rPlayers.readInt();
            String n = rPlayers.readUTF();
            int ptos = rPlayers.readInt();
            
            if( rPlayers.readBoolean()){
                System.out.println(c + n  + ptos);
            }
            imprimir(rPlayers.getFilePointer());
        }
    }
}

