package UNOGame;

class Carta {

    private String color;
    private int valor;
    private String tipo;

    public Carta(String color, int valor, String tipo) {
        this.color = color;
        this.valor = valor;
        this.tipo = tipo;
    }

    

    public String obtenerColor() {
        return color;
    }

    public int obtenerValor() {
        return valor;
    }

    public String obtenerTipo() {
        return tipo;
    }

}
