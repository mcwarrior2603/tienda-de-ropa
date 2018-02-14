/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Calendar;

/**
 *
 * @author Raul
 */
public class Fecha {
    
    public static String now(){
        String fecha = "";
        Calendar c = Calendar.getInstance();        
        
        fecha = c.get(Calendar.YEAR) + "/"
                + ((c.get(Calendar.MONTH)<9) ?
                        "0" + (c.get(Calendar.MONTH) + 1) : (c.get(Calendar.MONTH) + 1))
                + "/"
                + c.get(Calendar.DAY_OF_MONTH);
        
        return fecha;        
    }
    
    /**
     * Genera una cadena con la fecha actual.
     * La cadena generada tendrá formato "YYYY/MM/DD" el cual es 
     * compatible con SQL.
     * @return una cadena conteniendo la fecha de hoy en el formato indicado.
     */
    public static String hoy(){        
        Calendar hoy = Calendar.getInstance();                
        
        return hoy.get(Calendar.YEAR) + 
                "/" + (hoy.get(Calendar.MONTH) + 1) + 
                "/" + hoy.get(Calendar.DAY_OF_MONTH);                
    }
    
}
