/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class Configuracion {
    
    public static Color colorFondo = new Color(0x4d4dff);
    public static Color colorPaneles = new Color(0xd9d9d9);
    public static Color colorMenu = new Color(0x4d, 0x4d, 0xff, 0x88);
    private static int transparencyMenu = 0x88;
    
    public static String rutaLogo = "multimedia/logo.jpg";
    
    public static boolean anticipoRequerido = false;
    public static double porcentajeRequerido = 0.0;
    
    public static String dbHost = "localhost";
    public static String dbPort = "3306";
    public static String dbName = "TIENDA_DE_ROPA";        
    
    private Configuracion(){}        
    
    /**
     * Método que carga la configuración del sistema desde el archivo en que se
     * encuentra
     * @return true si fue posible cargar la información sin ninún fallo,
     * false en caso contrario.
     */
    public static boolean cargarConfiguracion(){
        BufferedReader reader;
        int redIng;
        int greenIng;
        int blueIng;
        
        try {
            reader = new BufferedReader(new FileReader("archivos/config.txt"));                        
            
            redIng = Integer.parseInt(reader.readLine());
            greenIng = Integer.parseInt(reader.readLine());
            blueIng = Integer.parseInt(reader.readLine());
            
            colorFondo = new Color(redIng, greenIng, blueIng);
            
            redIng = Integer.parseInt(reader.readLine());
            greenIng = Integer.parseInt(reader.readLine());
            blueIng = Integer.parseInt(reader.readLine());
            
            colorPaneles = new Color(redIng, greenIng, blueIng);
            
            redIng = Integer.parseInt(reader.readLine());
            greenIng = Integer.parseInt(reader.readLine());
            blueIng = Integer.parseInt(reader.readLine());
            
            colorMenu = new Color(redIng, greenIng, blueIng, transparencyMenu);
            
            rutaLogo = reader.readLine();
            
            anticipoRequerido = Boolean.parseBoolean(reader.readLine());
            porcentajeRequerido = Float.parseFloat(reader.readLine());
            
            dbHost = reader.readLine();
            dbPort = reader.readLine();
            dbName = reader.readLine();
            
            return true;           
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se encuentra el archivo de configuracion\n",                            
                    "Archivo de configuración: inexistente",
                    JOptionPane.ERROR_MESSAGE);
            construirArchivoDefault();
        } catch (IOException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "El archivo de configuración no es válido", 
                    "Archivo de configuración: no válido", 
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(System.out);
            construirArchivoDefault();
        }
        return false;
    }
    
    private static void construirArchivoDefault(){
        File config = new File("archivos/config.txt");                
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(config);
            writer.println(colorFondo.getRed());
            writer.println(colorFondo.getGreen());
            writer.println(colorFondo.getBlue());
            writer.println(colorPaneles.getRed());
            writer.println(colorPaneles.getGreen());
            writer.println(colorPaneles.getBlue());
            writer.println(colorMenu.getRed());
            writer.println(colorMenu.getGreen());
            writer.println(colorMenu.getBlue());
            writer.println(rutaLogo);
            writer.println(anticipoRequerido);
            writer.println(porcentajeRequerido);
            writer.println(dbHost);
            writer.println(dbPort);
            writer.println(dbName);
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }        
    
}
