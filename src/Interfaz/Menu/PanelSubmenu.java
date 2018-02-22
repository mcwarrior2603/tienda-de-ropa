/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Raul
 */
public class PanelSubmenu extends JLayeredPane{
    
    public static Color fondo = new Color(0xFFFFFF);
    
    private ArrayList<ItemSubmenu> items = new ArrayList();
    
    private JPanel panelFondo = new JPanel();
    private JPanel glassPane = new JPanel();
    
    private JLabel labelMenu = new JLabel();
    private JLabel labelIcon = new JLabel();
    
    public ImageIcon icono = new ImageIcon();
    
    private static int width = 75;
    private static int height = 75;
    
    private static int heightLabel = 15;
    
    public PanelSubmenu(String text, String urlIcono){
        setSize(width, height);       
        
        labelMenu.setText(text);
        labelIcon.setIcon(new ImageIcon(
                new ImageIcon(PanelSubmenu.class.getResource(urlIcono)).getImage()
                        .getScaledInstance(width - heightLabel, height - heightLabel, Image.SCALE_SMOOTH)));
        
        labelMenu.setPreferredSize(new Dimension(width, heightLabel));
        
        labelMenu.setHorizontalAlignment(JLabel.CENTER);
        labelIcon.setHorizontalAlignment(JLabel.CENTER);
        
        panelFondo.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panelFondo.add(labelIcon);
        panelFondo.add(labelMenu);        
        panelFondo.setOpaque(false);
        
        glassPane.setOpaque(false);
                        
        add(panelFondo, Integer.valueOf(1));
        add(glassPane, Integer.valueOf(2));
        
        panelFondo.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev){
                System.out.println("Clic en");
            }
        });
        
        glassPane.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent ev){
                panelFondo.setBackground(fondo);
                panelFondo.setOpaque(true);
                setSize(width, items.size() * ItemSubmenu.height + height + 10);                                                                
                for(ItemSubmenu temp : items){
                    panelFondo.add(temp);                                        
                }
                ((JPanel)getParent()).updateUI();
                updateUI();
            }
            @Override
            public void mouseExited(MouseEvent ev){
                setSize(width, height);        
                panelFondo.setOpaque(false);
                for(ItemSubmenu temp : items){
                    panelFondo.remove(temp);                    
                }
                ((JPanel)getParent()).updateUI();
                updateUI();
            }
            @Override
            public void mouseClicked(MouseEvent ev){
                if(SwingUtilities.getDeepestComponentAt(panelFondo, ev.getX(), ev.getY())instanceof JLabelMenu)
                    ((JLabelMenu)SwingUtilities.getDeepestComponentAt(panelFondo, ev.getX(), ev.getY())).clickLabel();                
            }
        });
        
    }       
    
    @Override
    public void setSize(int width, int height){
        super.setSize(width, height);
        super.setPreferredSize(new Dimension(width, height));
        panelFondo.setSize(width, height);
        glassPane.setSize(width, height);
    }
    
    @Override
    public void setBackground(Color bg){
        panelFondo.setBackground(bg);
    }
    
    public void addItem(ItemSubmenu item){
        items.add(item);
    }
          
    private PanelSubmenu getThis(){
        return this;
    }
    
}