/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPERS;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rene Barrera
 */
public class WaitGif {
    Icon icon;
    JLabel label;
    JPanel panel;

    public WaitGif(JPanel panel, JLabel label) {
        
            this.icon = new ImageIcon("waiting.gif");
            this.label = label;
            label.setIcon(icon);
            this.panel = panel;
            panel.add(label);
            panel.setVisible(true);
            label.setVisible(true);
       
    }
   
}
