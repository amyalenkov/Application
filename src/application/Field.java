/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Артем
 */
public class Field extends JPanel {

    private Image img;

    public Field(String str) {
         img = new ImageIcon("f:\\dev\\applicationNetBeans\\Application\\res\\ff.jpg").getImage();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
