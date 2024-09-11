package estudio.finalprg1versionprg2;

class Jugador {
    private int turnosRestantes;
    private int soldadosRescatados;

    public Jugador() {
        this.turnosRestantes = 50;
        this.soldadosRescatados = 0;
    }

    public int getTurnosRestantes() {
        return this.turnosRestantes;
    }

    public void decrementarTurnos() {
        this.turnosRestantes--;
    }

    public int getSoldadosRescatados() {
        return this.soldadosRescatados;
    }

    public void incrementarSoldadosRescatados() {
        this.soldadosRescatados++;
    }
}