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
public class Fuego extends Hechizo {

    private final byte daño;

    public Fuego() {
        super((byte) 8);
        this.daño = 3;
    }

    public byte getDaño() {
        return daño;
    }

    public void usar(Personaje[] mesa) {
        for (int i = 0; i < mesa.length; i++) {
            if (mesa[i] != null) {
                mesa[i].setVida((byte) (mesa[i].getVida() - 5));
                if (mesa[i].getVida() <= 0) {
                    mesa[i] = null;

                }
            }
        }

    }

}
