/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.net.DatagramSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public class NetworkConnection {
    
    public static final String CADENA_CONTROL_PETICION 
            = "DISCOVER_SERVER_REQUEST";
    public static final String CADENA_CONTROL_RESPUESTA 
            = "DISCOVER_SERVER_RESPONSE";
    
    ArrayList<String> direccionesIp = new ArrayList();     
    DatagramSocket c;
    
    private void cargarServidores(){
        direccionesIp.clear();
          
    }
    
}
