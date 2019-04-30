/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public class Apartado {

    public int folio;
    public int folioDeVenta;    
    public float total;
    public float saldoPendiente;
    public boolean cancelado;
    public boolean entregado;
    
    public ArrayList<Producto> productos = new ArrayList();

    public Apartado(int folio, 
            int folioDeVenta,             
            float total, 
            float saldoPendiente, 
            boolean cancelado, 
            boolean entregado) {
        this.folio = folio;
        this.folioDeVenta = folioDeVenta;          
        this.total = total;
        this.saldoPendiente = saldoPendiente;
        this.cancelado = cancelado;
        this.entregado = entregado;
    }
        
    @Override
    public String toString(){
        return folio  
                + (cancelado ? " : Cancelado" : "") 
                + (entregado ? " : Entregado" : "");
    }
}
