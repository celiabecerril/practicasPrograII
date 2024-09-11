package estudio.finalprg1versionprg2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        Scanner scanner = new Scanner(System.in);

        while (!juego.haTerminado() && !juego.haGanado()) {
            juego.imprimirTablero();
            System.out.println("Estas en el turno " + (50 - juego.getTurnosRestantes()));
            System.out.println("Has rescatado " + juego.getSoldadosRescatados());
            System.out.println("Ingrese coordenada: ");
            String posicion = scanner.nextLine();
            int fila = posicion.charAt(0) - 'a';
            int columna = Integer.parseInt(posicion.substring(1)) - 1;
            juego.jugarTurno(fila, columna);
        }

        if (juego.haGanado()) {
            System.out.println("¡Has ganado!");
        } else {
            System.out.println("Has perdido.");
        }

        scanner.close();
    }
}