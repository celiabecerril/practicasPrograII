package VistaPrivada;

class Restaurante {

    private String name;
    private String address;
    private int capacity;
    private Mesa mesa;

    public Restaurante (String name, String address, int capacity, Mesa mesa) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.mesa = mesa;
    }

    public void printDetails() {
        System.out.println("Restaurante: " + name);
        System.out.println("Dirección: " + address);
        System.out.println("Capacidad: " + capacity);
        mesa.printDetails();
    }
}

class Mesa {
    private int number;
    private Reserva reserva;

    public Mesa(int number, Reserva reserva) {
        this.number = number;
        this.reserva = reserva;
    }

    public void printDetails() {
        System.out.println("Mesa: " + number);
        reserva.printDetails();
    }
}

class Reserva {

    private String name;
    private Cliente cliente;

    public Reserva (String name, Cliente cliente) {
        this.name = name;
        this.cliente = cliente;
    }

    public void printDetails() {
        System.out.println("Reserva: " + name);
        cliente.printDetails();
    }
}

class Cliente {
    private String name;

    public Cliente(String name) {
        this.name = name;
    }

    public void printDetails() {
        System.out.println("Cliente: " + name);
    }
}

 class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Celia");
        Reserva reserva = new Reserva("Reserva 1", cliente);
        Mesa mesa = new Mesa(1, reserva);
        Restaurante restaurante = new Restaurante("Restaurante 1", "Calle 123", 100, mesa);
        restaurante.printDetails();
    }
}

