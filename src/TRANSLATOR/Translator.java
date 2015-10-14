/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRANSLATOR;



/**
 *
 * @author Marcos
 */
public class Translator {
    
    public String[] letters;
    public Languague lan;
    
    public Translator(String text){
    this.letters = new String[text.length()];
    this.lan = new Languague();
    
    
    }
    
    
    public void lineToBraille(String line)
    {
        if(!line.isEmpty())
        {
           for(int i=0; i<line.length(); i++)
           {
               this.letters[i] =String.valueOf(line.charAt(i));
           }
           
           for(int i=0; i< this.letters.length; i++)
           {
               System.out.println(letters[i]+"= "+ lan.Alfabeto.get(letters[i]));
           }
           
        }
        
    
    }
    
}
