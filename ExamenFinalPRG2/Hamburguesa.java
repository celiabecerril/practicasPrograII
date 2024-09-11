package ExamenFinalPRG2;

class Hamburguesa {
    private Brioche panSuperior;
    private Brioche panInferior;
    private Carne carne;
    private Object[] extras;
    private int indiceExtras;

    public Hamburguesa(Brioche panSuperior, Brioche panInferior, Carne carne, int numeroExtras) {
        this.panSuperior = panSuperior;
        this.panInferior = panInferior;
        this.carne = carne;
        this.extras = new Object[numeroExtras];
        this.indiceExtras = 0;
    }

    public void agregarExtra(Object extra) {
        if (indiceExtras < extras.length) {
            this.extras[indiceExtras] = extra;
            indiceExtras++;
        } else {
            System.out.println("No se pueden agregar más extras.");
        }
    }

    public Brioche getPanSuperior() {
        return this.panSuperior;
    }

    public Brioche getPanInferior() {
        return this.panInferior;
    }

    public Carne getCarne() {
        return this.carne;
    }

    public Object[] getExtras() {
        return this.extras;
    }

    public int getIndiceExtras() {
        return this.indiceExtras;
    }
}