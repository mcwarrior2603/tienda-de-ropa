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
public class Abono {
    public int folio_apartado;
    public int folio_ticket;
    public String fecha;
    public String usuario;
    public float monto;

    public Abono(int folio_apartado, int folio_ticket, String fecha, String usuario, float monto) {
        this.folio_apartado = folio_apartado;
        this.folio_ticket = folio_ticket;
        this.fecha = fecha;
        this.usuario = usuario;
        this.monto = monto;
    }
    
        
}
