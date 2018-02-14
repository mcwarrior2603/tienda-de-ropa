/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Raul
 */
public class Ventana extends JFrame implements WindowListener{
 
    public static final String NOMBRE_PUNTO_DE_VENTA = "Punto de venta";        
    public static final Font FUENTE_TITULO = new Font("Arial", 20, Font.BOLD);
                
    
    /**
     * Obtiene una cadena con la hora del momento en que se manda llamar con 
     * el siguiente formato 
     * @return 
     */
    public static String obtenerHora(){
        Calendar now = Calendar.getInstance();                        
        
        return now.get(Calendar.HOUR_OF_DAY) + 
                ":" + now.get(Calendar.MINUTE) + 
                ":" + now.get(Calendar.SECOND);
    }
    
    public static boolean esFloat(String in){
        try{
            float resultado = Integer.parseInt(in);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }    
    
    protected void cerrar(){
        System.out.println("Cerrando");
        setVisible(false);
        dispose();
    }

    protected void confirmarCerrado(){
        if(isVisible()){
            if(JOptionPane.showConfirmDialog(
                    this,
                    "¿Seguro que quiere cerrar?",
                    "Confirmar cerrado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
                cerrar();
        }        
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        confirmarCerrado();
    }
    
    @Override
    public void windowOpened(WindowEvent e) {}   
    @Override
    public void windowClosed(WindowEvent e) {}           
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
}
