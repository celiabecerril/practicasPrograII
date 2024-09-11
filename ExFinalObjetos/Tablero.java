package ExFinalObjetos;

class Tablero {
    Celda[][] celdas;

    Tablero(int tamano) {
        this.celdas = new Celda[tamano][tamano];
    }

    void colocarSoldado(Soldado soldado, int fila, int columna) {
        this.celdas[fila][columna] = new Celda(soldado);
    }

    void rescatarSoldado(int fila, int columna) {
        Celda celda = this.celdas[fila][columna];
        if (celda != null && celda.tieneSoldado()) {
            celda.rescatarSoldado();
        }
    }

    boolean soldadoEstaRescatado(int fila, int columna) {
        Celda celda = this.celdas[fila][columna];
        return celda != null && celda.tieneSoldado() && celda.soldado.estaRescatado();
    }
}