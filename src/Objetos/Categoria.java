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
public class Categoria {
    public int id;
    public String categoria;

    public Categoria(int id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }
       
    public Categoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString(){
        return categoria;
    }
}
