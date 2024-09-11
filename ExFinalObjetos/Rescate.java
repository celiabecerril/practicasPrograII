package ExFinalObjetos;

public class Rescate {
    public static void main(String[] args) {
        Tablero tablero = new Tablero(8);
        Soldado soldado = new Soldado();
        tablero.colocarSoldado(soldado, 0, 0);
        tablero.rescatarSoldado(0, 0);
        System.out.println(tablero.soldadoEstaRescatado(0, 0)); 
    }
} 
