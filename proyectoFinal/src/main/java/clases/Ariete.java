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
public class Ariete extends Personaje {

    private byte escudo;
    private byte dañoEscudos;

    public Ariete() {
        super((byte) 1, (byte) 10, (byte) 1, (byte) 5);
        this.escudo = 10;
        this.dañoEscudos = 10;
    }

    public byte getEscudo() {
        return escudo;
    }

    public byte getDañoEscudos() {
        return dañoEscudos;
    }

    public void setEscudo(byte escudo) {
        this.escudo = escudo;
    }

    public void setDañoEscudos(byte dañoEscudos) {
        this.dañoEscudos = dañoEscudos;
    }

}
