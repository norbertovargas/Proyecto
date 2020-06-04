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
    
    private byte usos;//usos del personaje
    private byte vida;//vida de la carta
    private byte daño;//daño que hace la carta
    
    /**
     * Constructor de personaje
     * @param usos usos del personaje
     * @param vida vida del personaje
     * @param daño daño del personaje
     * @param costo costo de la carta
     */
    public Personaje(byte usos, byte vida, byte daño, byte costo) {
        super(costo);
        this.usos = usos;
        this.vida = vida;
        this.daño = daño;
    }
    
    /**
     * Getter de usos
     * @return usos
     */
    public byte getUsos() {
        return usos;
    }
    
    /**
     * Getter de vida
     * @return vida
     */
    public byte getVida() {
        return vida;
    }
    
    /**
     * Getter de daño
     * @return daño
     */
    public byte getDaño() {
        return daño;
    }
    
    /**
     * Setter de usos
     * @param usos usos del personaje
     */
    public void setUsos(byte usos) {
        this.usos = usos;
    }
    
    /**
     * Setter de vida
     * @param vida vida del personaje
     */
    public void setVida(byte vida) {
        this.vida = vida;
    }
    
    /**
     * Setter de daño
     * @param daño daño del personaje
     */
    public void setDaño(byte daño) {
        this.daño = daño;
    }
    
    /**
     * Funcion de atacar al tablero
     * @param t tablero
     */
    public void atacarBase(Tablero t) {
        //si el tablero tiene escudo se baja primero el escudo
        if (t.getEscudo() > 0) {
            t.setEscudo((byte) (t.getEscudo() - daño));
            //si se baja el escudo y el daño es mayor que el escudo el daño restante se aplica en la vida
            if (t.getEscudo() < 0) {
                t.setVida((byte) (t.getVida() + t.getEscudo()));
                t.setEscudo((byte) 0);
                
            }
        //si no tiene escudo se ataca a la vida
        } else {
            t.setVida((byte) (t.getVida() - daño));
            
        }
        
    }
    
    /**
     * Funcion de atacar a un personaje
     * @param p personaje
     */
    public void atacarUnidad(Personaje p) {
        //se baja la vida del personaje dependiendo de la vida del atacante
        p.setVida((byte) (p.getVida() - daño));
        System.out.println("Vida: "+p.getVida());
        
    }
    
    /**
     * Funcion de atacar a un ariete
     * @param a ariete
     */
    public void atacarUnidad(Ariete a) {
        //si el ariete tiene escudo se baja primero el escudo
        if (a.getEscudo() > 0) {
            a.setEscudo((byte) (a.getEscudo() - daño));
            //si se baja el escudo y el daño es mayor que el escudo el daño restante se aplica en la vida
            if (a.getEscudo() < 0) {
                a.setVida((byte) (a.getVida() + a.getEscudo()));
                a.setEscudo((byte) 0);
                
            }
        //si no tiene escudo se ataca a la vida
        } else {
            a.setVida((byte) (a.getVida() - daño));
            
        }
        
    }
    
    
}
