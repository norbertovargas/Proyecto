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
public class Tablero {

    private byte vida;//vida del tablero
    private byte escudo;//escudo del tablero
    private Carta[] mano;//cartas que hay en mano
    private Carta[] mesa;//cartas que hay en la mesa

    /**
     * Constructor de tablero
     * @param mano//cartas que hay en mano
     * @param mesa//cartas que hay en la mesa
     */
    public Tablero(Carta[] mano, Personaje[] mesa) {
        this.vida = 30;
        this.escudo = 0;
        this.mano = new Carta[3];
        this.mesa = new Carta[5];

    }

    /**
     * Getter de vida
     * @return vida
     */
    public byte getVida() {
        return vida;
    }

    /**
     * Getter de escudo
     * @return escudo
     */
    public byte getEscudo() {
        return escudo;
    }

    /**
     * Getter de mano
     * @return mano
     */
    public Carta[] getMano() {
        return mano;
    }

    /**
     * Getter de mesa
     * @return 
     */
    public Carta[] getMesa() {
        return mesa;
    }

    /**
     * Setter de mesa
     * @param vida vida del tablero
     */
    public void setVida(byte vida) {
        this.vida = vida;
    }

    /**
     * Setter de escudo
     * @param escudo escudo del tablero
     */
    public void setEscudo(byte escudo) {
        this.escudo = escudo;
    }

    /**
     * Setter de mano
     * @param mano cartas que hay en mano
     */
    public void setMano(Carta[] mano) {
        this.mano = mano;
    }

    /**
     * Setter de mesa
     * @param mesa cartas que hay en la mesa
     */
    public void setMesa(Carta[] mesa) {
        this.mesa = mesa;
    }

    

}
