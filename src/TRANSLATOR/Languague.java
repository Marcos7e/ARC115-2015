package TRANSLATOR;


import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos
 */
public class Languague {
    
    public HashMap<String, String> lang;
    public HashMap<String, String> Alfabeto;
    
    public Languague()
    {
        this.lang = new HashMap<>();
        this.Alfabeto = new HashMap<>();
        
        lang.put("ES", "Alfabeto");
        lang.put("EN","Alfabeto");
        
        Alfabeto.put("a", "100000");
        Alfabeto.put("b", "101000");
        Alfabeto.put("c", "110000");
        Alfabeto.put("d", "110100");
        Alfabeto.put("e", "100100");
        Alfabeto.put("f", "111000");
        Alfabeto.put("g", "111100");
        Alfabeto.put("h", "101100");
        Alfabeto.put("i", "011000");
        Alfabeto.put("j", "011100");
        Alfabeto.put("k", "100010");
        Alfabeto.put("l", "101010");
        Alfabeto.put("m", "110010");
        Alfabeto.put("n", "110110");
        Alfabeto.put("ñ", "111101");
        Alfabeto.put("o", "100110");
        Alfabeto.put("p", "111010");
        Alfabeto.put("q", "111110");
        Alfabeto.put("r", "101110");
        Alfabeto.put("s", "011010");
        Alfabeto.put("t", "011110");
        Alfabeto.put("u", "100011");
        Alfabeto.put("v", "101011");
        Alfabeto.put("w", "011101");
        Alfabeto.put("x", "110011");
        Alfabeto.put("y", "110111");
        Alfabeto.put("z", "100111");
        
        Alfabeto.put(" ", "ESPACIO");
        
        Alfabeto.put(".","000010");
        Alfabeto.put(";","001010");
        Alfabeto.put(":","001100");
        Alfabeto.put(",","001000");
        Alfabeto.put("?","001001");
        Alfabeto.put("!","001110");
        Alfabeto.put("(","101001");
        Alfabeto.put(")","010110");
        Alfabeto.put("'","001011");
        Alfabeto.put("-","000011");
        
        
        
        
        
    }
    
}
