/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Raul
 */
public class Seguridad {
    
    public static boolean checkEliminarIngreso(
            int folio, 
            String fecha, 
            int idUsuario, 
            int digitoValidacion,
            String autorizacion){
        
        Calendar c = Calendar.getInstance();                        
        c.set(Calendar.YEAR, Integer.parseInt(fecha.substring(0, 4)));
        c.set(Calendar.MONTH, Integer.parseInt(fecha.substring(5, 7)));
        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fecha.substring(8, 10)));
        
        int fechaNumero = c.get(Calendar.YEAR) * c.get(Calendar.MONTH) * c.get(Calendar.DAY_OF_MONTH);
        
        int valor = Math.abs(((folio + fechaNumero + idUsuario + digitoValidacion)
                * fechaNumero) % digitoValidacion);                
        
        String hex = Integer.toHexString(valor);                
                        
        return hex.equals(autorizacion);
    }
    
    public static boolean checkEliminarEgreso(int folio, 
            String fecha, 
            int idUsuario, 
            int digitoValidacion,
            String autorizacion){        
        
        Calendar c = Calendar.getInstance();                        
        c.set(Calendar.YEAR, Integer.parseInt(fecha.substring(0, 4)));
        c.set(Calendar.MONTH, Integer.parseInt(fecha.substring(5, 7)));
        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fecha.substring(8, 10)));
        
        int fechaNumero = c.get(Calendar.YEAR) * c.get(Calendar.MONTH) * c.get(Calendar.DAY_OF_MONTH);
        
        int valor = Math.abs((folio * idUsuario * digitoValidacion / (fechaNumero * idUsuario)) % digitoValidacion );
        
        String hex = Integer.toHexString(valor);                                
        
        return hex.equals(autorizacion);    
    }
    
    public static boolean checkEliminarApartado(int folio, 
            String fecha, 
            int idUsuario, 
            int digitoValidacion,
            String autorizacion){        
        
        Calendar c = Calendar.getInstance();                        
        c.set(Calendar.YEAR, Integer.parseInt(fecha.substring(0, 4)));
        c.set(Calendar.MONTH, Integer.parseInt(fecha.substring(5, 7)));
        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fecha.substring(8, 10)));
        
        int fechaNumero = c.get(Calendar.YEAR) * c.get(Calendar.MONTH) * c.get(Calendar.DAY_OF_MONTH);
        
        int valor = Math.abs((folio * idUsuario * digitoValidacion / (fechaNumero * folio)) % digitoValidacion );
        
        String hex = Integer.toHexString(valor);                                
        
        return hex.equals(autorizacion);    
    }
    
    public static boolean checkEliminarVenta(
            int folio, 
            String fecha, 
            int idUsuario, 
            int digitoValidacion,
            String autorizacion){
        Calendar c = Calendar.getInstance();                        
        c.set(Calendar.YEAR, Integer.parseInt(fecha.substring(0, 4)));
        c.set(Calendar.MONTH, Integer.parseInt(fecha.substring(5, 7)));
        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fecha.substring(8, 10)));
        
        int fechaNumero = c.get(Calendar.YEAR) * c.get(Calendar.MONTH) * c.get(Calendar.DAY_OF_MONTH);
        
        int valor = Math.abs((folio * fechaNumero * digitoValidacion / (idUsuario * folio)) % digitoValidacion );
        
        String hex = Integer.toHexString(valor);                                
        
        return hex.equals(autorizacion);    
    }
    
    public static void main(String args[]){
        Random r = new Random(System.nanoTime()); 
//        for(int i = 0 ; i < 100 ; i++)
        checkEliminarEgreso(1, "2018/01/31", 1, 590866739, "");
    }
    
}
