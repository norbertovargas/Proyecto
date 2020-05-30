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
    
    private byte usos;
    private byte vida;
    private byte daño;
    
    public Personaje(byte usos, byte vida, byte daño, byte costo) {
        super(costo);
        this.usos = usos;
        this.vida = vida;
        this.daño = daño;
    }
    
    public byte getUsos() {
        return usos;
    }
    
    public byte getVida() {
        return vida;
    }
    
    public byte getDaño() {
        return daño;
    }
    
    public void setUsos(byte usos) {
        this.usos = usos;
    }
    
    public void setVida(byte vida) {
        this.vida = vida;
    }
    
    public void setDaño(byte daño) {
        this.daño = daño;
    }
    
    public void atacarBase(Tablero t) {
        byte resto;
        if (t.getEscudo() > 0) {
            t.setEscudo((byte) (t.getEscudo() - daño));
            if (t.getEscudo() < 0) {
                t.setVida((byte) (t.getVida() + t.getEscudo()));
                t.setEscudo((byte) 0);
                
            }
        } else {
            t.setVida((byte) (t.getVida() - daño));
            
        }
        
    }
    
    public void atacarUnidad(Personaje p) {
        p.setVida((byte) (p.getVida() - daño));
        System.out.println("Vida: "+p.getVida());
        
    }
    
    public void atacarUnidad(Ariete a) {
        byte resto;
        if (a.getEscudo() > 0) {
            a.setEscudo((byte) (a.getEscudo() - daño));
            if (a.getEscudo() < 0) {
                a.setVida((byte) (a.getVida() + a.getEscudo()));
                a.setEscudo((byte) 0);
                
            }
        } else {
            a.setVida((byte) (a.getVida() - daño));
            
        }
        
    }
    
    
}
