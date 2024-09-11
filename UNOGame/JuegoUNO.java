package UNOGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JuegoUNO {
    private Jugador[] jugadores;
    private Carta[] mazo;
    private Carta cartaActual;
    private boolean direccionNormal = true;
    private boolean saltarTurno = false;

    public JuegoUNO() {
        jugadores = new Jugador[3];
        mazo = new Carta[108];
        cartaActual = mazo[21];
        inicializarMazo();
        repartirCartas();
    }

    private void inicializarMazo() {
        String[] colores = { "rojo", "verde", "azul", "amarillo" };
        String[] tipos = { "numbered", "skip", "reverse", "draw two" };
        int indiceMazo = 0;

        for (String color : colores) {
            for (int numero = 0; numero <= 9; numero++) {
                mazo[indiceMazo++] = new Carta(color, numero, "numbered");
                if (numero != 0) { 
                    mazo[indiceMazo++] = new Carta(color, numero, "numbered");
                }
            }
        }

        for (String color : colores) {
            for (String tipo : tipos) {
                if (!tipo.equals("numbered")) { 
                    mazo[indiceMazo++] = new Carta(color, -1, tipo);
                    mazo[indiceMazo++] = new Carta(color, -1, tipo); 
                }
            }
        }

        Random random = new Random();
        for (int i = mazo.length - 1; i > 0; i--) {
            int indice = random.nextInt(i + 1);
            Carta temp = mazo[indice];
            mazo[indice] = mazo[i];
            mazo[i] = temp;
        }
    }

    private void repartirCartas() {

        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new Jugador("Jugador " + (i + 1));
            for (int j = 0; j < 7; j++) {
                jugadores[i].recibirCarta(mazo[i * 7 + j], j);
            }
        }
    }

    public boolean haGanado(Jugador jugador) {
        for (Carta carta : jugador.getMano()) {
            if (carta != null) {
                return false;
            }
        }
        return true;
    }

    public void turno(Jugador jugador) {
        int indiceJugadorActual = 0;
        
        if (this.cartaActual == null) {
            
            this.cartaActual = mazo[0];
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(jugador.getNombre() + ", es tu turno. La carta actual es " + cartaActual.obtenerColor() + " "
                + cartaActual.obtenerValor());
        System.out.println("Estas son tus cartas:");
        for (int i = 0; i < jugador.getMano().length; i++) {
            Carta carta = jugador.getMano()[i];
            if (carta != null) {
                System.out.println(i + ": " + carta.obtenerColor() + " " + carta.obtenerValor());
            }
        }
        System.out.println("Elige el índice de la carta que quieres jugar:");
        int indice = scanner.nextInt();
    

        Carta cartaJugada = jugador.jugarCarta(indice);

        
        switch (cartaJugada.obtenerTipo()) {
            case "skip":
                
                saltarTurno = true;
                break;
            case "reverse":
                
                direccionNormal = !direccionNormal;
                break;
            case "draw two":
                
                int siguienteJugador = (indiceJugadorActual + (direccionNormal ? 1 : -1) + jugadores.length)
                        % jugadores.length;
                Jugador jugadorSiguiente = jugadores[siguienteJugador];
                for (int i = 0; i < 2; i++) {
                    Carta cartaRobada = mazo[mazo.length - 1];
                    jugadorSiguiente.recibirCarta(cartaRobada, jugadorSiguiente.getMano().length);
                    mazo[mazo.length - 1] = null;
                    mazo = Arrays.copyOf(mazo, mazo.length - 1);
                }
                break;
            case "draw four":
                
                siguienteJugador = (indiceJugadorActual + (direccionNormal ? 1 : -1) + jugadores.length)
                        % jugadores.length;
                jugadorSiguiente = jugadores[siguienteJugador];
                for (int i = 0; i < 4; i++) {
                    Carta cartaRobada = mazo[mazo.length - 1];
                    jugadorSiguiente.recibirCarta(cartaRobada, jugadorSiguiente.getMano().length);
                    mazo[mazo.length - 1] = null;
                    mazo = Arrays.copyOf(mazo, mazo.length - 1);
                }
                break;
        }

        cartaActual = cartaJugada;
    }

    

    public void jugar() {
        int indiceJugadorActual = 0;
        while (true) {
            turno(jugadores[indiceJugadorActual]);
            if (saltarTurno) {
                indiceJugadorActual = (indiceJugadorActual + 2) % jugadores.length;
                saltarTurno = false;
            } else {
                indiceJugadorActual = (indiceJugadorActual + (direccionNormal ? 1 : -1) + jugadores.length)
                        % jugadores.length;
            }
            indiceJugadorActual = (indiceJugadorActual + 1) % jugadores.length; 
            for (Jugador jugador : jugadores) {
                if (haGanado(jugador)) {
                    System.out.println(jugador.getNombre() + " ha ganado!");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        JuegoUNO juego = new JuegoUNO();
        juego.jugar();
    }
}
