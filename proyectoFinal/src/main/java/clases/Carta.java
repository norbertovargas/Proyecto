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
    private byte costo;//costo de mana de la carta

    /**
     * Constructor de carta
     * @param costo costo de mana de la carta
     */
    public Carta(byte costo) {
        this.costo = costo;
    }
    
    /**
     * Getter de costo
     * @return costo
     */
    public byte getCosto() {
        return costo;
    }

    /**
     * Setter de costo 
     * @param costo costo de mana de la carta
     */
    public void setCosto(byte costo) {
        this.costo = costo;
    }


    
}
