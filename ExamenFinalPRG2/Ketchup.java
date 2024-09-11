package ExamenFinalPRG2;
class Ketchup extends Extras {
    String cantidad;

    Ketchup(String cantidad) {
        super("Ketchup");
        this.cantidad = cantidad;
    }

    public String getCantidad() {
        return cantidad;
    }
}