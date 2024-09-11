package ExFinalObjetos;

class Celda {
    Soldado soldado;

    Celda(Soldado soldado) {
        this.soldado = soldado;
    }

    boolean tieneSoldado() {
        return this.soldado != null;
    }

    void rescatarSoldado() {
        if (tieneSoldado()) {
            this.soldado.rescatar();
        }
    }
}


