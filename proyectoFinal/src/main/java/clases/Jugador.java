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
public class Jugador {
    private byte mana;//mana del jugador
    private byte acciones;//acciones del jugador
    private Carta[] mazo;//cartas en el mazo del jugador

    /**
     * Constructor de jugador
     * @param mazo cartas en el mazo del jugador
     */
    public Jugador(Carta[] mazo) {
        this.mana = 10;
        this.acciones = 3;
        this.mazo = mazo;
    }

    /**
     * Getter de mana
     * @return mana
     */
    public byte getMana() {
        return mana;
    }

    /**
     * Getter de acciones
     * @return acciones
     */
    public byte getAcciones() {
        return acciones;
    }

    /**
     * Getter de mazo
     * @return mazo
     */
    public Carta[] getMazo() {
        return mazo;
    }

    /**
     * Setter de mana
     * @param mana mana del jugador
     */
    public void setMana(byte mana) {
        this.mana = mana;
    }
    
    /**
     * Setter de acciones
     * @param acciones acciones del jugador
     */
    public void setAcciones(byte acciones) {
        this.acciones = acciones;
    }

    /**
     * Setter de mazo
     * @param mazo cartas en el mazo del jugador
     */
    public void setMazo(Carta[] mazo) {
        this.mazo = mazo;
    }
    
    /**
     * Funcion que aumenta el mana del jugador
     */
    public void aumentarMana(){
        //incrementa 3 el mana
        this.setMana((byte) (this.getMana()+3));
        //si el mana es mayor a 10 se establece como 10 que es el maximo
        if (this.getMana()>10) {
            this.setMana((byte) 10);
            
        }
    
    }
}
