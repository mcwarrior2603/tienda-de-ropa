/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Raul
 */
public class Apartado {

    public int folio;
    public int folioDeVenta;
    public String claveProducto;
    public String nombre;
    public float precio;
    public float saldoPendiente;
    public boolean cancelado;
    public boolean entregado;

    public Apartado(int folio, 
            int folioDeVenta, 
            String claveProducto,
            String nombre, 
            float precio, 
            float saldoPendiente, 
            boolean cancelado, 
            boolean entregado) {
        this.folio = folio;
        this.folioDeVenta = folioDeVenta;  
        this.claveProducto = claveProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.saldoPendiente = saldoPendiente;
        this.cancelado = cancelado;
        this.entregado = entregado;
    }
        
    @Override
    public String toString(){
        return nombre  
                + (cancelado ? " : Cancelado" : "") 
                + (entregado ? " : Entregado" : "");
    }
}
