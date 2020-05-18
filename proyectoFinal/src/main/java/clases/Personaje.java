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
public class Personaje extends Carta {

    private final byte usos;
    private final byte vida;
    private final byte daño;

    public Personaje(byte usos, byte vida, byte daño, byte costo) {
        super(costo);
        this.usos = usos;
        this.vida = vida;
        this.daño = daño;
    }

    
    

}
