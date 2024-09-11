package UNOGame;

class Jugador {
    private Carta[] mano;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new Carta[7];
    }

    public void recibirCarta(Carta carta, int indice) {
        mano[indice] = carta;
    }

    public String getNombre() {
        return nombre;
    }

    public Carta[] getMano() {
        return mano;
    }

    public Carta jugarCarta(int indice) {
        Carta carta = mano[indice];
        mano[indice] = null; 
        return carta;
    }
} 
    