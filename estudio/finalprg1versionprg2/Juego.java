package estudio.finalprg1versionprg2;

class Juego {
    private Jugador jugador;
    private Soldado[] soldados;
    private char[][] tablero;

    public Juego() {
        this.jugador = new Jugador();
        this.soldados = new Soldado[16];
        this.tablero = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.tablero[i][j] = '.';
            }
        }
        for (int i = 0; i < 16; i++) {
            // Coloca los soldados en posiciones aleatorias
            int fila = (int) (Math.random() * 8);
            int columna = (int) (Math.random() * 8);
            this.soldados[i] = new Soldado(fila, columna);
            this.tablero[fila][columna] = 'S';
        }
    }

    public void jugarTurno(int fila, int columna) {
        for (Soldado soldado : soldados) {
            if (soldado.getFila() == fila && soldado.getColumna() == columna) {
                jugador.incrementarSoldadosRescatados();
                soldado.setFila(-1);  // El soldado ha sido rescatado
                soldado.setColumna(-1);
                this.tablero[fila][columna] = '.';
                break;
            }
        }
        jugador.decrementarTurnos();
    }

    public boolean haGanado() {
        return jugador.getSoldadosRescatados() == 16;
    }

    public boolean haTerminado() {
        return jugador.getTurnosRestantes() == 0;
    }

    public void imprimirTablero() {
        System.out.println("  +-a--b--c--d--e--f--g--h-");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + "| ");
            for (int j = 0; j < 8; j++) {
                System.out.print(this.tablero[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("  +------------------------");
    }

    public int getTurnosRestantes() {
        return jugador.getTurnosRestantes();
    }

    public int getSoldadosRescatados() {
        return jugador.getSoldadosRescatados();
    }
}