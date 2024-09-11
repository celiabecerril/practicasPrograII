class Caja {
    private Cliente clienteActual;
    private int numeroCaja;
    private int numeroItems;

    
    public Caja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
        this.numeroItems = 0; 
    }

    public boolean estaLibre() {
        return clienteActual == null;
    }

    public void recibe(Cliente cliente, int numeroItems) {
        if (estaLibre()) {
            clienteActual = cliente;
            this.numeroItems = numeroItems; 
        } else {
            System.out.println("Caja ocupada");
        }
    }

    public void atiende() {
        if (!estaLibre()) {
           //ESTO ES LO QUE ESTA MAL 
            System.out.println("Número de items: " + numeroItems);
            //clienteActual = null;
            numeroItems--; 
        } else {
            System.out.println("La caja está libre, no hay clientes para atender.");
        }
    }

    public void verEstado() {
        if (!estaLibre()) {
            
            System.out.println("Número de items: " + numeroItems);
        } else {
            System.out.println("La caja " + numeroCaja + " está libre.");
        }
    }
}