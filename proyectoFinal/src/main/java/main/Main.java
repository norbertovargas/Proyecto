/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.*;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Norberto
 *
 * TABLERO(2 bases con 30 vida y 0 escudo en inicio(10 max), max 3 cartas en
 * mano, max 5 personajes en juego) JUGADOR(mazo(5 cartas), max 3 acciones por
 * turno, 10 mana maximo(relleno al inicio), regenera 3 mana por turno) CARTA
 * personaje(invocables) arquero{ Datos(3 usos, 5 vida, 2 mana) Uso(-3
 * vida(escudo si tiene))
 *
 * }
 * luchador{ Datos(3 usos, 10 vida, 3 mana) Uso(-5 vida(escudo si tiene)) }
 * ariete{ Datos(1 uso, 10 escudo, 10 vida, 5 mana) Uso(-10 escudo, - 1 vida) }
 *
 * hechizo(1 solo uso) muro(+5 escudo, 6 mana) fuego(-5 VIDA a todas las
 * unidades, 8 mana)
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

        Carta[] mano1 = new Carta[3];
        Carta[] mano2 = new Carta[3];

        Personaje[] mesa1 = new Personaje[5];
        Personaje[] mesa2 = new Personaje[5];

        Carta[] mazo1 = new Carta[5];

        mazo1[0] = new Luchador();
        mazo1[1] = new Arquero();
        mazo1[2] = new Ariete();
        mazo1[3] = new Muro();
        mazo1[4] = new Fuego();

        Jugador j1 = new Jugador(mazo1);

        Carta[] mazo2 = new Carta[5];

        mazo2[0] = new Luchador();
        mazo2[1] = new Arquero();
        mazo2[2] = new Ariete();
        mazo2[3] = new Muro();
        mazo2[4] = new Fuego();

        Jugador j2 = new Jugador(mazo2);

        rellenarMano(mano1, mazo1);

        rellenarMano(mano2, mazo2);

        inicializarTablero(mesa1);

        inicializarTablero(mesa2);

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
        byte opcion;

        while (t1.getVida() > 0 || t2.getVida() > 0) {
            System.out.println("Elige una opcion:");
            opcion = sc.nextByte();
            switch (opcion) {
                case 1:
                    invocarCarta(mano1, mesa1, mazo1, j1);
                    break;
                case 2:
                    usarCarta(mesa1, mesa2, t1, t2);
                    break;
                case 3:
                    //saltarTruno;
                    j1.setAcciones((byte) 0);
                    break;

            }

        }

    }

    private static void inicializarTablero(Carta[] tablero) {

        for (int i = 0; i < tablero.length; i++) {
            tablero[i] = null;
        }

    }

    private static void rellenarMano(Carta[] mano, Carta[] mazo) {

        Random rnd = new Random();

        for (byte i = 0; i < 3; i++) {
            if (mano[i] == null) {
                mano[i] = mazo[rnd.nextInt(5)];
            }

        }

    }

    private static void invocarCarta(Carta[] mano, Personaje[] mesa, Carta[] mazo, Jugador j) {

        Scanner sc = new Scanner(System.in);

        byte uso;

        System.out.println("cartas en mano:");
        for (int i = 0; i < mano.length; i++) {
            System.out.println(mano[i].getClass().getName());
        }

        System.out.println("elige la carta a invocar");
        do {
            uso = sc.nextByte();
            if (uso < 0 || uso > 2) {
                System.out.println("No es una carta valida");
            } else if (mano[uso].getCosto() > j.getMana()) {
                System.out.println("No tienes suficiente mana para esta carta");
            }

        } while (uso < 0 || uso > 2 || mano[uso].getCosto() > j.getMana());

        j.setMana((byte) (j.getMana() - mano[uso].getCosto()));
        System.out.println("has usado: " + mano[uso].getCosto());
        System.out.println("te quedan: " + j.getMana());

        for (int i = 0; i < mesa.length; i++) {
            if (mesa[i] == null) {
                switch (mano[uso].getClass().getCanonicalName()) {
                    case "clases.Arquero":
                        mesa[i] = new Arquero();
                        System.out.println(mesa[i].getClass().getCanonicalName());
                        break;
                    case "clases.Luchador":
                        mesa[i] = new Luchador();
                        System.out.println(mesa[i].getClass().getCanonicalName());
                        break;
                    case "class clases.Ariete":
                        mesa[i] = new Ariete();
                        System.out.println(mesa[i].getClass().getCanonicalName());
                        break;
                    default:
                        break;
                }
                break;

            }
        }
        mano[uso] = null;

        rellenarMano(mano, mazo);

        j.setMana((byte) (j.getMana() + 3));

        j.setAcciones((byte) (j.getAcciones() - 1));

    }

    private static void usarCarta(Personaje[] mesaAtaque, Personaje[] mesaDefensa, Tablero t1, Tablero t2) {
        Scanner sc = new Scanner(System.in);

        System.out.println("A quien atacas?");
        byte ataque;
        
        System.out.println("0-Nexo enemigo: " + t2.getVida()+" Escudo: "+t2.getEscudo());
        for (int i = 0; i < mesaDefensa.length; i++) {
            if (mesaDefensa[i] != null) {
                System.out.println((i + 1) + "-"+mesaDefensa[i].getClass().getCanonicalName() + mesaDefensa[i].getVida());
            }
        }
        ataque = sc.nextByte();
        System.out.println("Con quien atacas");
        for (int i = 0; i < mesaAtaque.length; i++) {
            if (mesaAtaque[i] != null) {
                System.out.println(i + ": " + mesaAtaque[i].getClass());
            }
        }

        byte op;
        op = sc.nextByte();
        mesaAtaque[op].atacarBase(t2);
        System.out.println(t2.getVida());
    }

}
