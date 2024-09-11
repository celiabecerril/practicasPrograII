package ExFinalObjetos;

public class Soldado {
    boolean rescatado;

    Soldado() {
        this.rescatado = false;
    }

    void rescatar() {
        this.rescatado = true;
    }

    boolean estaRescatado() {
        return this.rescatado;
    }
}


