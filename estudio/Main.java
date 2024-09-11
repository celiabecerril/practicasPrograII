package estudio;
import java.util.*;

class Carta {
    private String palo;
    private String valor;

    public Carta(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public int getValorNumerico() {
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 0; i < valores.length; i++) {
            if (valor.equals(valores[i])) {
                return i;
            }
        }
        return -1;  // Nunca debería llegar aquí
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}


class Baraja {
    private Carta[] cartas;
    private int indiceActual;

    public Baraja() {
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        cartas = new Carta[palos.length * valores.length];
        indiceActual = 0;

        int indice = 0;
        for (String palo : palos) {
            for (String valor : valores) {
                cartas[indice] = new Carta(palo, valor);
                indice++;
            }
        }

        // Barajar las cartas
        Random rand = new Random();
        for (int i = 0; i < cartas.length; i++) {
            int j = rand.nextInt(cartas.length);
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
    }

    public Carta repartir() {
        if (indiceActual >= cartas.length) {
            // Todas las cartas se han repartido, reiniciar la baraja y el índice
            indiceActual = 0;
        }

        Carta cartaSeleccionada = cartas[indiceActual];
        indiceActual++;
        return cartaSeleccionada;
    }
}
class Jugador {
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void recibirCarta(Carta carta) {
        // Implementa este método para manejar la recepción de una carta
    }

    @Override
    public String toString() {
        return nombre;
    }
}

public class Main {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        boolean empate = true;
        while (empate) {
            Carta carta1 = baraja.repartir();
            Carta carta2 = baraja.repartir();
            jugador1.recibirCarta(carta1);
            jugador2.recibirCarta(carta2);

            System.out.println(jugador1 + " recibe " + carta1);
            System.out.println(jugador2 + " recibe " + carta2);

            if (carta1.getValorNumerico() > carta2.getValorNumerico()) {
                System.out.println(jugador1 + " gana!");
                empate = false;
            } else if (carta1.getValorNumerico() < carta2.getValorNumerico()) {
                System.out.println(jugador2 + " gana!");
                empate = false;
            } else {
                System.out.println("Empate! Repartiendo de nuevo...");
            }
        }
    }
}