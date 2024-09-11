package VistaPrivada;

public class CentroComercial {

    public static void main(String[] args) {

        System.out.println("Welcome to the shopping center");

        
        Row row1 = new Row("Row 1", 1);
        Row row2 = new Row("Row 2", 2);
        Row row3 = new Row("Row 3", 3);

        row1.buyProduct("Product 1");
        row2.buyProduct("Product 2");
        row3.buyProduct("Product 3");

        Client client1 = new Client("Client 1");
        Client client2 = new Client("Client 2");
        Client client3 = new Client("Client 3");

        client1.buyProduct("Product 1");
        client2.buyProduct("Product 2");
        client3.buyProduct("Product 3");

        CashRegister cashRegister1 = new CashRegister(client1, 100);
        CashRegister cashRegister2 = new CashRegister(client2, 200);
        CashRegister cashRegister3 = new CashRegister(client3, 300);

        cashRegister1.buyProduct("Product 1");
        cashRegister2.buyProduct("Product 2");
        cashRegister3.buyProduct("Product 3");

        cashRegister1.pay();


    }
    
}


class Row {
    
    private String name;
    private int number;

    public Row(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void buyProduct(String product) {
        System.out.println(name + " bought the product:");
        System.out.println(product);
    }

    public int number() {
        return number;
    }
    
}

class Client {
    private String name;
    

    public Client(String name) {
        this.name = name;
        
    }

    public void buyProduct(String product) {
        System.out.println(name + " bought the product:");
        System.out.println(product);
    }

}

class CashRegister {

    private Client client;
    private int amount;

    public CashRegister(Client client, int amount) {
        this.client = client;
        this.amount = amount;
    }

    public void buyProduct(String product) {
        client.buyProduct(product);
    }

    public void pay() {
        System.out.println(client + " paid " + amount);
    }
    



}