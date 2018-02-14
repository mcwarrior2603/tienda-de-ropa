/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Raul
 */
public abstract class ItemSubmenu extends JPanel{
    
    private JLabelMenu labelIcon = new JLabelMenu(){
        public void clickLabel(){
            click();
        }
    };
    private JLabelMenu labelTexto = new JLabelMenu(){
        public void clickLabel(){
            click();
        }
    };
    
    public static int height = 65;
    public static int width = 65;
    
    private String texto;
    
    public ItemSubmenu(String text, String urlIcono){
        
        setLayout(new BorderLayout(1,1));
        
        this.width = width;
        this.height = height;
        setSize(new Dimension(width, height));                                
        
        setOpaque(false);
        setBackground(Color.WHITE);
        
        texto = text;
        
        labelTexto.setText(text);
        labelIcon.setIcon(new ImageIcon(
                new ImageIcon(ItemSubmenu.class.getResource(urlIcono)).getImage()
                        .getScaledInstance(width - 15, height - 15, Image.SCALE_SMOOTH)));
        
        labelTexto.setHorizontalAlignment(JLabel.CENTER);
        labelIcon.setHorizontalAlignment(JLabel.CENTER);
        
        add(labelIcon, BorderLayout.CENTER);
        add(labelTexto, BorderLayout.SOUTH);
        
        labelIcon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                
            }
        });
    }        
    
    @Override
    public String toString(){
        return texto;
    }
    
    public abstract void click();
    
}
