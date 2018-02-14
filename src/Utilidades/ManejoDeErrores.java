/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Interfaz.Ventana;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class ManejoDeErrores {
    /**
     * Método encargado de reportar que ha ocurrido un error.
     * Muestra un message dialog, el cual informa que ha ocurrido una
     * excepción, dando el tipo de esta, y el archivo .txt en que se ha
     * almacenado la información.
     * @param ex Excepcion a reportar.
     * @param infoAdicional Cadenas con información que pudiera ser importante
     */
    public static void reportarError(Exception ex, String... infoAdicional){        
        int indexFile = 0;
        PrintWriter writer;
        File archivo;
        
        do{
            indexFile++;
            archivo = new File("logs/log" + indexFile + ".txt");
        }while(archivo.exists());
        
        try {
            writer = new PrintWriter(archivo);
                       
            writer.println(ex.getLocalizedMessage());
            writer.println("-------------Inforación adicional----------------");
            for(int i = 0 ; i < infoAdicional.length ; i++){
                writer.println(infoAdicional[i]);
            }
            writer.println("-------------------------------------------------");
            ex.printStackTrace(writer);
            
            writer.close();
        } catch (FileNotFoundException ex1) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        JOptionPane.showMessageDialog(
                null, 
                "<html><b>¡Ha ocurrido un error!</b></html> \n"
                        + ex.getLocalizedMessage() + "\n"
                        + "El reporte detallado se ha guardado en "
                        + archivo.getName() + "\n"
                        + "Guarde esta información para soporte técnico", 
                "Ha ocurrido un error", 
                JOptionPane.ERROR_MESSAGE);
    }
}
