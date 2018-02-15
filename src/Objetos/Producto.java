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
public class Producto {
    
    public String clave;
    public String nombre;
    public boolean nuevo;
    public String categoria;
    public float precio;
    public String detalles;
    public String imagen;
    public int existencia;
    public int idAsignacion;

    public Producto(String clave, String nombre, int existencia) {
        this.clave = clave;
        this.nombre = nombre;
        this.existencia = existencia;
    }

    public Producto(String clave, String nombre, float precio) {
        this.clave = clave;
        this.nombre = nombre;
        this.precio = precio;
    }
           
}
