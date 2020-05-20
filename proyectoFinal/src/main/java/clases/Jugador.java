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
    private byte mana;
    private byte vida;//el jugador empieza con 50 de vida, cuando llega a 0 muere
    private byte acciones;//solo se permiten 3 acciones por turno, ya sea sacar nuevas cartas o atacar con las que se tienen
    private Carta[] mazo;

    public Jugador(Carta[] mazo) {
        this.mana = 10;
        this.vida = 50;
        this.acciones = 3;
        this.mazo = mazo;
    }

    public byte getMana() {
        return mana;
    }

    public byte getVida() {
        return vida;
    }

    public byte getAcciones() {
        return acciones;
    }

    public Carta[] getMazo() {
        return mazo;
    }

    public void setMana(byte mana) {
        this.mana = mana;
    }

    public void setVida(byte vida) {
        this.vida = vida;
    }

    public void setAcciones(byte acciones) {
        this.acciones = acciones;
    }

    public void setMazo(Carta[] mazo) {
        this.mazo = mazo;
    }
    
    
}
