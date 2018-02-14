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
    public String nombre;
    public float precio;
    public float saldoPendiente;

    public Apartado(int folio, int folioDeVenta, String nombre, float precio, float saldoPendiente) {
        this.folio = folio;
        this.folioDeVenta = folioDeVenta;
        this.nombre = nombre;
        this.precio = precio;
        this.saldoPendiente = saldoPendiente;
    }
        
    @Override
    public String toString(){
        return nombre;
    }
}
