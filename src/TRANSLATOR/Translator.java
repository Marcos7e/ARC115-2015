/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRANSLATOR;

import COM.Communication;
import HELPERS.Emulation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;



/**
 *
 * @author Marcos
 */
public class Translator implements Runnable {
    
    private final String[] letters;
    private final Languague lan;
    private final int threadSleepTimeMillis;
    private final String line;
    private final JButton boton;
    public Communication com ;
    public String respuestaArduino;
    public Emulation emu;
    
    
    
    
    public Translator(String line, int threadSleepTimeMillis, JButton boton, Emulation emu){
    this.line = line;
    this.letters = new String[line.length()];
    this.lan = new Languague();
    this.threadSleepTimeMillis = threadSleepTimeMillis;
    this.boton = boton;
    this.emu =emu;
    
    
    this.com = new Communication("COM3", 9600, 1000);
    
    
    }
    
    
    public void lineToBraille()
    {
        
        
        if(!this.line.isEmpty())
        {
           for(int i=0; i<line.length(); i++)
           {
               this.letters[i] =String.valueOf(line.charAt(i)).toLowerCase();
           }
           
           for(int i=0; i< this.letters.length; i++)
           {
               try {
                   Thread.sleep(this.threadSleepTimeMillis);
                    System.out.println(letters[i]+"= "+ lan.Alfabeto.get(letters[i]));
                    com.sendData(letters[i]);
                   
               } catch (InterruptedException ex) {
                   System.out.println(ex.getMessage());
               }
              
           }
           
        }
        
    
    }

   
    @Override
    public void run() {
        
           
         if(!line.isEmpty())
        {
           com.InicializarConexion();
            
            boton.setText("Traduciendo a Braille...");
            boton.setEnabled(false);
           for(int i=0; i<line.length(); i++)
           {
               this.letters[i] =String.valueOf(line.charAt(i)).toLowerCase();
           }
            try {
            for (String letter : this.letters) {
               
                    Thread.sleep(this.threadSleepTimeMillis);
                    System.out.println(letter + "= " + lan.Alfabeto.get(letter));
                    emu.onRecibeData(lan.Alfabeto.get(letter));
                    com.sendData(lan.Alfabeto.get(letter));
                    respuestaArduino = com.getData();
                    System.out.println("Arduino says: "+respuestaArduino);
                
                }
            
             boton.setText("Mandar contenido a interfaz Braille");
             boton.setEnabled(true);
             com.closeConnection();
                
             }    
                
                
                catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            
    }

    
}
}
