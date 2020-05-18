/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Norberto
 */
public class Carta {
    private byte costo;

    public Carta(byte costo) {
        this.costo = costo;
    }
    public byte getCosto() {
        return costo;
    }

    public void setCosto(byte costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Carta{" + "costo=" + costo + '}';
    }

    
}
