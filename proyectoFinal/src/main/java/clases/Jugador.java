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
    private byte acciones;//solo se permiten 3 acciones por turno, ya sea sacar nuevas cartas o atacar con las que se tienen
    private Carta[] mazo;

    public Jugador(Carta[] mazo) {
        this.mana = 10;
        this.acciones = 3;
        this.mazo = mazo;
    }

    public byte getMana() {
        return mana;
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
    public void setAcciones(byte acciones) {
        this.acciones = acciones;
    }

    public void setMazo(Carta[] mazo) {
        this.mazo = mazo;
    }
    
    public void aumentarMana(){
        this.setMana((byte) (this.getMana()+3));
        if (this.getMana()>10) {
            this.setMana((byte) 10);
            
        }
    
    }
}
