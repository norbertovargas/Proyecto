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
public class Muro extends Hechizo {
    
    private final byte escudo;//escudo que aplia
    
    public Muro() {
        super((byte) 6);
        this.escudo = 5;
    }
    
    /**
     * Funcion que ejecuta el uso del muro
     * @param t tablero
     */
    public void usar(Tablero t) {
        //aumenta el escudo en 5
        t.setEscudo((byte) (t.getEscudo() + 5));
        //si el escudo pasa de 10 se establece como 10 que es el maximo
        if (t.getEscudo() > 10) {
            t.setEscudo((byte) 10);
        }
        //muestra el escudo actual
        System.out.println("Escudo actual: "+t.getEscudo());
    }
}
