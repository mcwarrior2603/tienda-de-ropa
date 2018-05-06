/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raul
 */
public class DiscoveryThread implements Runnable{

    public static final String CADENA_CONTROL_PETICION 
            = "DISCOVER_SERVER_REQUEST";
    public static final String CADENA_CONTROL_RESPUESTA 
            = "DISCOVER_SERVER_RESPONSE";
    
    DatagramSocket socket;
    
    private volatile boolean isActive = true;
    
    @Override
    public void run() {
        try {
            socket = new DatagramSocket(1998, InetAddress.getByName("0.0.0.0"));
            socket.setBroadcast(true);
            
            while(isActive){
                System.out.println(getClass().getName() + ">>Listo para recibir "
                        + "paquetes de broadcast");
                
                byte[] bufferRecepcion = new byte[15000];
                
                DatagramPacket packet = new DatagramPacket(
                        bufferRecepcion, 
                        bufferRecepcion.length);
                socket.receive(packet);
                
                System.out.println(getClass().getName() + ""
                        + ">>Discovery packet received from " 
                        + packet.getAddress().getHostAddress());
                System.out.println("Packet received; data:" 
                        + new String(packet.getData()));
                
                String msgReceived = new String(packet.getData()).trim();
                if(msgReceived.equals(CADENA_CONTROL_PETICION)){
                    byte[] sendData = CADENA_CONTROL_RESPUESTA.getBytes();
                    
                    DatagramPacket sendPacket = new DatagramPacket(
                            sendData,
                            sendData.length,
                            packet.getAddress(),
                            packet.getPort());
                    socket.send(sendPacket);
                    
                    System.out.println(getClass().getName() 
                            + ">>Paquete enviado a " 
                            + sendPacket.getAddress().getHostAddress());                    
                }
            }                        
        } catch (UnknownHostException ex) {
            Logger.getLogger(DiscoveryThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(DiscoveryThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DiscoveryThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void stop(){
        isActive = false;
    }
    
    public static DiscoveryThread getInstance() {
        return DiscoveryThreadHolder.INSTANCE;
    } 

    private static class DiscoveryThreadHolder {
        private static final DiscoveryThread INSTANCE = new DiscoveryThread();
    }   
}
