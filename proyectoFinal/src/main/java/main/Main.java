/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * @author Norberto
 * 
 * TABLERO(2 bases con 30 vida y 0 escudo en inicio(10 max), max 3 cartas en mano, max 5 personajes en juego)
 * JUGADOR(mazo(5 cartas), max 3 acciones por turno, 10 mana maximo(relleno al inicio), regenera 3 mana por turno)
 * CARTA
 *	personaje(invocables)
 *		arquero{
 * 				Datos(3 usos, 5 vida, 2 mana)
 *				Uso(-3 vida(escudo si tiene))
 * 				
 *			}
 *		luchador{
 *				Datos(3 usos, 10 vida, 3 mana)
 * 				Uso(-5 vida(escudo si tiene))
 *			}
 *		ariete{
 *				Datos(1 uso, 10 escudo, 10 vida, 5 mana) 
 *				Uso(-10 escudo, - 1 vida)
 *			}
 *
 *	hechizo(1 solo uso)
 *		muro(+5 escudo, 6 mana)		
 *		fuego(-5 VIDA a todas las unidades, 8 mana)
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
