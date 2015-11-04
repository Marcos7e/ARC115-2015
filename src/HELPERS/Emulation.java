/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPERS;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Marcos Barrera
 */
public class Emulation {
    
    public JPanel b1; 
    public JPanel b2; 
    public JPanel b3; 
    public JPanel b4; 
    public JPanel b5; 
    public JPanel b6;
    
    public String brailleCode;
    public char[] indBrailleCode;
    public Color offColor;
    public Color onColor;
   
    public Emulation(JPanel b1, JPanel b2, JPanel b3, JPanel b4, JPanel b5, JPanel b6, Color off, Color on){
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
        this.b6 = b6;
        this.offColor = off;
        this.onColor = on;
        this. indBrailleCode = new char[6];
    }
    
    public void setAllOff()
    {
        this.b1.setBackground(offColor);
        this.b2.setBackground(offColor);
        this.b3.setBackground(offColor);
        this.b4.setBackground(offColor);
        this.b5.setBackground(offColor);
        this.b6.setBackground(offColor);
    }

 
    
    public void onRecibeData(String brailleCode)
    {
        this.brailleCode = brailleCode;
        
        for(int i =0; i<brailleCode.length();i++)
        {
            indBrailleCode[i] = brailleCode.charAt(i);
        }
        
        if( indBrailleCode[0]=='1')
        {this.b1.setBackground(onColor);}
        else
        { this.b1.setBackground(offColor);}
        
        if( indBrailleCode[1]=='1')
        {this.b2.setBackground(onColor);}
        else
        { this.b2.setBackground(offColor);}
          
        if( indBrailleCode[2]=='1')
        {this.b3.setBackground(onColor);}
        else
        { this.b3.setBackground(offColor);}
            
        if( indBrailleCode[3]=='1')
        {this.b4.setBackground(onColor);}
        else
        { this.b4.setBackground(offColor);}
              
        if( indBrailleCode[4]=='1')
        {this.b5.setBackground(onColor);}
        else
        { this.b5.setBackground(offColor);}
                
        if( indBrailleCode[5]=='1')
        {this.b6.setBackground(onColor);}
        else
        { this.b6.setBackground(offColor);}
        
        
        
    }
            
    
    
    
}
