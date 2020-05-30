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
    
    private final byte escudo;
    
    public Muro() {
        super((byte) 6);
        this.escudo = 5;
    }
    
    public void usar(Tablero t) {
        t.setEscudo((byte) (t.getEscudo() + 5));
        if (t.getEscudo() > 10) {
            t.setEscudo((byte) 10);
            
        }
        System.out.println("Escudo actual: "+t.getEscudo());
    }
}
