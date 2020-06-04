/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.*;
import java.util.Random;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Norberto
 *
 * TABLERO(2 bases con 30 vida y 0 escudo en inicio(10 max), max 3 cartas en
 * mano, max 5 personajes en juego) JUGADOR(mazo(5 cartas), max 3 acciones por
 * turno, 10 mana maximo(relleno al inicio), regenera 3 mana por turno)
 *
 * CARTA PERSONAJE(invocables) ARQUERO{ Datos(3 usos, 5 vida, 2 mana) Uso(-3
 * vida) } LUCHADOR{ Datos(3 usos, 10 vida, 3 mana) Uso(-5 vida(escudo si
 * tiene)) } ARIETE{ Datos(1 uso, 10 escudo, 10 vida, 5 mana) Uso(-10 escudo, -
 * 1 vida) }
 *
 * HECHIZO(1 solo uso) MURO(+5 escudo, 6 mana) FUEGO(-5 VIDA a todas las
 * unidades, 8 mana)
 *
 */
public class Main {

    /**
     * Funcion principal del programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BadNumberException, BadNumberException1 {

        consultarRegistro();
        Scanner sc = new Scanner(System.in);//Declaro el escaner

        //Declaro los arrays que contienen las cartas en mano de ambos jugadores
        Carta[] mano1 = new Carta[3];
        Carta[] mano2 = new Carta[3];

        //Declaro los arrays que contienen las cartas en uso de ambos jugadores
        Personaje[] mesa1 = new Personaje[5];
        Personaje[] mesa2 = new Personaje[5];

        //Inicializo ambos tableros con su mano y su mesa correspondiente
        Tablero t1 = new Tablero(mano1, mesa1);
        Tablero t2 = new Tablero(mano2, mesa2);

        //Declaro el mazo del jugador 1 con una carta de cada tipo
        Carta[] mazo1 = new Carta[5];
        mazo1[0] = new Luchador();
        mazo1[1] = new Arquero();
        mazo1[2] = new Ariete();
        mazo1[3] = new Muro();
        mazo1[4] = new Fuego();

        //Inicializo el jugador 1 con su mazo
        Jugador j1 = new Jugador(mazo1);

        //Declaro el mazo del jugador 2 con una carta de cada tipo
        Carta[] mazo2 = new Carta[5];
        mazo2[0] = new Luchador();
        mazo2[1] = new Arquero();
        mazo2[2] = new Ariete();
        mazo2[3] = new Muro();
        mazo2[4] = new Fuego();

        //Inicializo el jugador 1 con su mazo
        Jugador j2 = new Jugador(mazo2);

        //Relleno las 2 manos para empezar el juego con las cartas de los mazos
        rellenarMano(mano1, mazo1);

        rellenarMano(mano2, mazo2);

        //Declaro una variable que va a servir para elegir la opcion en el turno
        byte opcion;

        //Comienza el juego, y se repite hasta que la vida de uno de los jugadores llegue a 0
        while (t1.getVida() > 0 || t2.getVida() > 0) {
            //Turno de j1
            System.out.println("\n\nJuega J1");
            do {
                System.out.println("\nElige una opcion, turnos restantes " + j1.getAcciones());
                System.out.println("\t1-Invocar Carta");
                System.out.println("\t2-Usar Carta");
                System.out.println("\t3-Saltar Turno");
                opcion = sc.nextByte();
                switch (opcion) {
                    //en el caso de pulsar 1 se ejecuta la funcion de invocar carta
                    case 1:
                        invocarCarta(mano1, mesa1, j1, mesa2, t1);
                        //cuando acaba la funcion se resta una accion al jugador
                        j1.setAcciones((byte) (j1.getAcciones() - 1));
                        break;
                    //en caso de pulsar 1 se ejecuta la funcion de usar carta
                    case 2:
                        usarCarta(mesa1, mesa2, t2, j1);
                        //cuando acaba la funcion se resta una accion al jugador
                        j1.setAcciones((byte) (j1.getAcciones() - 1));
                        break;
                    //en caso de pulsar 3 se salta el turno haciendo que las acciones sean 0
                    case 3:
                        j1.setAcciones((byte) 0);
                        break;

                }

            } while (j1.getAcciones() > 0);//cuando el jugador se queda sin acciones es turno del otro jugador

            //si la vida del j2 llega a 0 se registra a j1 como ganador y se acaba la ejecucion del main
            if (t2.getVida() < 1) {
                System.out.println("Gana J1");
                registrarGanador(t1, "j1");
                break;
            }
            //cuando acaba el turno de j1 se rellena su mazo
            rellenarMano(mano1, j1.getMazo());
            //se resetean las acciones y se ponen en 3
            j1.setAcciones((byte) 3);
            //despues del turno se aumenta el mana de j1
            j1.aumentarMana();

            //Turno de j2
            System.out.println("\n\nJuega J2");
            do {
                System.out.println("\nElige una opcion, turnos restantes " + j2.getAcciones());
                System.out.println("\t1-Invocar Carta");
                System.out.println("\t2-Usar Carta");
                System.out.println("\t3-Saltar Turno");
                opcion = sc.nextByte();
                switch (opcion) {
                    case 1:
                        invocarCarta(mano2, mesa2, j2, mesa1, t2);
                        j2.setAcciones((byte) (j2.getAcciones() - 1));
                        break;
                    case 2:
                        usarCarta(mesa2, mesa1, t1, j2);
                        j2.setAcciones((byte) (j2.getAcciones() - 1));
                        break;
                    case 3:
                        //saltarTruno;
                        j2.setAcciones((byte) 0);
                        break;

                }

            } while (j2.getAcciones() > 0);//cuando el jugador se queda sin acciones es turno del otro jugador

            //si la vida del j1 llega a 0 se registra a j2 como ganador y se acaba la ejecucion del main
            if (t1.getVida() < 1) {
                System.out.println("Gana J2");
                registrarGanador(t2, "j2");
                break;
            }
            //cuando acaba el turno de j2 se rellena su mazo
            rellenarMano(mano2, j2.getMazo());
            //se resetean las acciones y se ponen en 3
            j2.setAcciones((byte) 3);
            //despues del turno se aumenta el mana de j2
            j2.aumentarMana();

        }
        System.out.println("Fin del juego");

    }
    
    /**
     * Funcion que comprueba si el numero no se puede introducir
     * @param n numero por parametro
     * @throws BadNumberException 
     */
    private static final void comprobar(byte n) throws BadNumberException {

        if (n == 50) {
            throw new BadNumberException("El numero no puede ser 50");
        }

    }
    
    
    private static final void comprobar2(byte n) throws BadNumberException1 {

        if (n == 100) {
            throw new BadNumberException1("El numero no puede ser 100");
        }

    }

    /**
     * Funcion que rellena la mano con 3 cartas aleatorias del mazo
     *
     * @param mano cartas en mano del jugador
     * @param mazo cartas del mazo del jugador
     */
    private static void rellenarMano(Carta[] mano, Carta[] mazo) {

        //declaro el aleatorio
        Random rnd = new Random();

        //recorro la mano y si encuentro un valor vacio lo relleno con una carta aleatoria del mazo
        for (byte i = 0; i < 3; i++) {
            if (mano[i] == null) {
                mano[i] = mazo[rnd.nextInt(5)];
            }

        }

    }

    /**
     * Funcion que invoca la carta deseada, en el caso que sea un hechizo la usa
     * y en caso de que sea un personaje lo pone en la mesa
     *
     * @param mano cartas en mano del jugador
     * @param mesa cartas en la mesa del jugador
     * @param j jugador que actua en la ejecucion
     * @param mesaE cartas en la mesa del jugador enemigo
     * @param t tablero del jugador
     */
    private static void invocarCarta(Carta[] mano, Personaje[] mesa, Jugador j, Personaje[] mesaE, Tablero t) throws BadNumberException1 {

        boolean lleno = true;//declaro un booleano que dice si la mesa esta llena de cartas
        //se comprueba si hay espacio libre para la carta nueva, en caso afirmativo el booleano se vuelve false
        for (byte i = 0; i < mesa.length; i++) {
            if (mesa[i] == null) {
                lleno = false;
            }
        }
        //si esta llen dice que la mesa esta llena y corta la ejecucion de la funcion
        if (lleno) {
            System.out.println("Tu mesa esta llena");
            j.setAcciones((byte) (j.getAcciones() + 1));
            return;
        }

        //declaro el escaner
        Scanner sc = new Scanner(System.in);

        byte uso;//declaro una variable que indica que carta estoy usando
        System.out.println("Mana actual: " + j.getMana());
        System.out.println("Cartas en mano:");

        //enseño las cartas que puedo invocar junto a su costo de mana
        for (byte i = 0; i < mano.length; i++) {
            if (mano[i] != null) {
                System.out.println((i) + "-" + mano[i].getClass().getSimpleName() + "(" + mano[i].getCosto() + ")");
            }
        }
        System.out.println("3-Atras");

        System.out.println("Elige la carta a invocar");

        //compruebo que la eleccion de carta sea correcta
        do {
            uso = sc.nextByte();
            comprobar2(uso);
            //el valor no puede estar fuera del rango
            if (uso < 0 || uso > 3) {
                System.out.println("No es una opcion valida");
            } //si se elige la opcion 3 se corta la ejecucion de la funcion
            else if (uso == 3) {
                j.setAcciones((byte) (j.getAcciones() + 1));
                return;
            } //si no existe carta en la opcion seleccionada se dice de elegir otra
            else if (mano[uso] == null) {
                System.out.println("El slot esta vacio, escoge otra carta");
            } //si el costo de la carta es mayor que el mana del jugador tiene que elegir otra
            else if (mano[uso].getCosto() > j.getMana()) {
                System.out.println("No tienes suficiente mana para esta carta, elige otra");
            }

        } while (uso < 0 || uso > 3 || mano[uso] == null || mano[uso].getCosto() > j.getMana());

        j.setMana((byte) (j.getMana() - mano[uso].getCosto()));
        System.out.println("Mana restante: " + j.getMana());

        //se comprueba que carta se usa
        switch (mano[uso].getClass().getSimpleName()) {
            //si se elige el fuego se ejecuta sin invocarla
            case "Fuego":
                Fuego f = (Fuego) mano[uso];
                f.usar(mesaE);
                break;
            //lo mismo pasa con el muro
            case "Muro":
                Muro m = (Muro) mano[uso];
                m.usar(t);
                break;
            //si es otra carta se recorre el array de mesa para buscarle un sitio e invocarla
            default:
                for (byte i = 0; i < mesa.length; i++) {
                    if (mesa[i] == null) {
                        switch (mano[uso].getClass().getSimpleName()) {
                            //si se elige un arquero se invoca un arquero
                            case "Arquero":
                                mesa[i] = new Arquero();
                                System.out.println(mano[uso].getClass().getSimpleName() + " invocado");
                                break;
                            //si se elige un luchador se invoca un luchador    
                            case "Luchador":
                                mesa[i] = new Luchador();
                                System.out.println(mano[uso].getClass().getSimpleName() + " invocado");
                                break;
                            //si se elige el ariete se invoca un ariete
                            case "Ariete":
                                mesa[i] = new Ariete();
                                System.out.println(mano[uso].getClass().getSimpleName() + " invocado");
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                }
                break;
        }
        //se borra de la mano la carta que se haya invocado
        mano[uso] = null;

    }

    /**
     * Funcion que realiza el ataque de las cartas, con el atacante y objetivo
     * elegidos
     *
     * @param mesaAtaque cartas que atacan
     * @param mesaDefensa cartas que son atacadas
     * @param t tablero que es atacado
     * @param j jugador que ataca
     */
    private static void usarCarta(Personaje[] mesaAtaque, Personaje[] mesaDefensa, Tablero t, Jugador j) throws BadNumberException {
        boolean lleno = false;//booleano que comprueba si la mesa esta vacia
        //recorre el array para buscar un valor no nulo
        for (byte i = 0; i < mesaAtaque.length; i++) {
            if (mesaAtaque[i] != null) {
                lleno = true;
            }
        }
        //en caso de que el array esté vacío se le dice al usuario y se corta la ejecución de la función
        if (lleno == false) {
            System.out.println("Primero tienes que invocar alguna carta");
            j.setAcciones((byte) (j.getAcciones() + 1));
            return;
        }

        //declaro el escaner
        Scanner sc = new Scanner(System.in);

        System.out.println("¿A quien atacas?");
        byte ataque;

        System.out.println("0-Nexo enemigo: " + t.getVida() + " Escudo: " + t.getEscudo());
        for (byte i = 0; i < mesaDefensa.length; i++) {
            if (mesaDefensa[i] != null) {
                System.out.println((i + 1) + "-" + mesaDefensa[i].getClass().getSimpleName() + "(" + mesaDefensa[i].getVida() + ")");
            }
        }
        ataque = sc.nextByte();//variable que define la carta a atacar
        comprobar(ataque);

        System.out.println("Con quien atacas");
        for (byte i = 0; i < mesaAtaque.length; i++) {
            if (mesaAtaque[i] != null) {
                System.out.println(i + ": " + mesaAtaque[i].getClass().getSimpleName() + "(" + mesaAtaque[i].getUsos() + " usos)");
            }
        }

        byte op;//variable que define la carta atacante
        op = sc.nextByte();

        //si se elige atacar al nexo se ejecuta la funcion correspondiente
        if (ataque == 0) {
            mesaAtaque[op].atacarBase(t);
            System.out.println("Vida restante del nexo: " + t.getVida());
        } //en caso de elegir el ariete se ejecuta la funcion del ariete
        else if ("Ariete".equals(mesaDefensa[ataque - 1].getClass().getCanonicalName().substring(7))) {
            mesaAtaque[op].atacarUnidad((Ariete) mesaDefensa[ataque - 1]);
            if (mesaDefensa[ataque - 1].getVida() < 1) {
                mesaDefensa[ataque - 1] = null;

            }

        } //por ultimo se ejecuta la opcion de atacar por defecto en los demas casos
        else {
            mesaAtaque[op].atacarUnidad(mesaDefensa[ataque - 1]);
            if (mesaDefensa[ataque - 1].getVida() < 1) {
                mesaDefensa[ataque - 1] = null;

            }
        }
        //cuando se cumplen los usos de la carta, esta se elimina de la mesa
        mesaAtaque[op].setUsos((byte) (mesaAtaque[op].getUsos() - 1));
        if (mesaAtaque[op].getUsos() < 1) {
            mesaAtaque[op] = null;

        }

    }

    /**
     * Funcion que conecta con la base de datos para realizar una consulta que
     * muestra el registro de ganadores
     */
    private static void consultarRegistro() {

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto?useTimezone=true&serverTimezone=UTC", "programacion", "Programacion");
                Statement smt = con.createStatement();
                ResultSet rs = smt.executeQuery("select * from registro")) {
            System.out.println("Ganador\tVida");
            while (rs.next()) {
                String ganador = rs.getString("ganador");
                String vida = rs.getString("vida");
                System.out.println(ganador + "\t" + vida);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     *
     * @param t tablero del ganador
     * @param ganador string que recibe el ganador, j1 o j2
     */
    private static void registrarGanador(Tablero t, String ganador) {

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto?useTimezone=true&serverTimezone=UTC", "programacion", "Programacion");
                Statement smt = con.createStatement()) {

            int n = smt.executeUpdate("insert into registro values ('" + ganador + "','" + t.getVida() + "')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
