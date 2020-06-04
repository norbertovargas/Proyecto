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

    private final byte daño;//daño del fuego

    /**
     * Constructor de fuego
     */
    public Fuego() {
        super((byte) 8);
        this.daño = 5;
    }

    /**
     * Getter de daño
     * @return daño
     */
    public byte getDaño() {
        return daño;
    }

    /**
     * Funcion que ejecuta el uso del fuego
     * @param mesa 
     */
    public void usar(Personaje[] mesa) {
        //recorro el array
        for (int i = 0; i < mesa.length; i++) {
            //compruebo que el valor no es nulo
            if (mesa[i] != null) {
                //reduzco la vida del objetivo con el daño del fuego
                mesa[i].setVida((byte) (mesa[i].getVida() - this.daño));
                //si la vida del objetivo se vuelve 0 el valor del array se vuelve null
                if (mesa[i].getVida() <= 0) {
                    mesa[i] = null;

                }
            }
        }

    }

}
