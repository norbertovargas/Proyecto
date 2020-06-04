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

    private byte escudo;//escudo que tiene el ariete
    private byte dañoEscudos;//daño que hace el ariete a escudos

    //constructor de ariete
    public Ariete() {
        super((byte) 1, (byte) 10, (byte) 1, (byte) 5);
        this.escudo = 10;
        this.dañoEscudos = 10;
    }

    /**
     * Getter de escudo
     * @return escudo
     */
    public byte getEscudo() {
        return escudo;
    }

    /**
     * Getter de dañoEscudo
     * @return dañoEscudos
     */
    public byte getDañoEscudos() {
        return dañoEscudos;
    }

    /**
     * Setter de escudo
     * @param escudo escudo del ariete
     */
    public void setEscudo(byte escudo) {
        this.escudo = escudo;
    }

    /**
     * Setter de dañoEscudo
     * @param dañoEscudos daño a escudos del ariete
     */
    public void setDañoEscudos(byte dañoEscudos) {
        this.dañoEscudos = dañoEscudos;
    }

    /**
     * Funcion que hace que el ariete ataque
     * @param dañoEscudos daño a escudos del ariete
     */
    public void atacarBase(Tablero t){
        t.setEscudo((byte)0);
        t.setVida((byte)(t.getVida()-1));
    
    }
}
