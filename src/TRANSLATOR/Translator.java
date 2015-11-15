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
import javax.swing.JTextField;



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
    public JTextField translator;
    public JButton control;
    
    
    
    
    public Translator(String line, int threadSleepTimeMillis, JButton boton,JButton Control, Emulation emu, Communication com, JTextField translator){
    this.line = line;
    this.letters = new String[line.length()];
    this.lan = new Languague();
    this.threadSleepTimeMillis = threadSleepTimeMillis;
    this.boton = boton;
    this.emu =emu;
    this.com = com;
    this.translator=translator;
    this.control = Control;
    
    }
    
    

   
    @Override
    public void run() {
        
           
         if(!line.isEmpty())
        {
        //   com.InicializarConexion();
            
            boton.setText("Traduciendo a Braille...");
            boton.setEnabled(false);
            control.setEnabled(true);
         
            
           for(int i=0; i<line.length(); i++)
           {
               this.letters[i] =String.valueOf(line.charAt(i)).toLowerCase();
           }
            try {
            for (String letter : this.letters) {
               
                    Thread.sleep(this.threadSleepTimeMillis);          
                    emu.onRecibeData(lan.Alfabeto.get(letter));
                    translator.setText(letter+": "+lan.Alfabeto.get(letter));
                    com.sendData(lan.Alfabeto.get(letter));
                    respuestaArduino = com.getData();
             
                
                }
            
             boton.setText("Mandar contenido a interfaz Braille");
             
             boton.setEnabled(true);
             com.sendData("000000");
             translator.setText("");
             control.setEnabled(false);
             
      
                
             }    
                
                
                catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            
    }

    
}
}
