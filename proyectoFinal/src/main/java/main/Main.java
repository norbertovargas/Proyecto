/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.*;
import java.util.Scanner;

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
        
        Scanner sc = new Scanner(System.in);
        
        Tablero t1 = new Tablero();
        Tablero t2 = new Tablero();
        Carta[] mazo1 = new Carta[5];
        Carta[] mazo2 = new Carta[5];
        
        Carta[] mano1 = new Carta[3];
        Carta[] mano2 = new Carta[3];
        
        Carta[] mesa1 = new Carta[5];
        Carta[] mesa2 = new Carta[5];
        
        mazo1[0] = new Luchador();
        mazo1[1] = new Arquero();
        mazo1[2] = new Ariete();
        mazo1[3] = new Muro();
        mazo1[4] = new Fuego();
        
        Jugador j1 = new Jugador(mazo1); 
        Jugador j2 = new Jugador(mazo2); 
        
        
        mazo2[0] = new Luchador();
        mazo2[1] = new Arquero();
        mazo2[2] = new Ariete();
        mazo2[3] = new Muro();
        mazo2[4] = new Fuego();
        
        
        
        
        
        
        
        /*
        System.out.println("Introduce el numero de cartas de cada tipo para J1(max 5)");
        System.out.println("Luchadores:");
        System.out.println("Quedan "+max+" cartas por elegir");
        System.out.println("Arqueros:");
        System.out.println("Quedan "+max+" cartas por elegir");
        System.out.println("Arietes:");
        System.out.println("Quedan "+max+" cartas por elegir");
        System.out.println("Muros:");
        System.out.println("Quedan "+max+" cartas por elegir");
        System.out.println("Fuegos:");
        
        */
        
        
        
    }
    
}
