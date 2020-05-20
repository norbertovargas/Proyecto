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

    private byte base;
    private byte escudo;
    private Carta[] mano;
    private Carta[] juego;

    public Tablero() {
        this.base = 30;
        this.escudo = 0;
        this.mano = new Carta[3];
        this.juego = new Carta[5];

    }

    public byte getBase() {
        return base;
    }

    public byte getEscudo() {
        return escudo;
    }

    public Carta[] getMano() {
        return mano;
    }

    public Carta[] getJuego() {
        return juego;
    }

    public void setBase(byte base) {
        this.base = base;
    }

    public void setEscudo(byte escudo) {
        this.escudo = escudo;
    }

    public void setMano(Carta[] mano) {
        this.mano = mano;
    }

    public void setJuego(Carta[] juego) {
        this.juego = juego;
    }

}
