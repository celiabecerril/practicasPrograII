package ExamenFinalPRG2;
 class Camarero extends Empleado {
    private Hamburguesa hamburguesa;

    void recibir(Hamburguesa hamburguesa) {
        this.hamburguesa = hamburguesa;
        System.out.println("Hamburguesa recibida.");
        describirHamburguesa();

    }

    private void describirHamburguesa() {
        System.out.println("\n##############");
        System.out.println(" ::::::::::::"); // Pan superior
        for (Object extra : this.hamburguesa.getExtras()) {
            if (extra instanceof Ketchup) {
                System.out.println(" ooOooOooOooO (Cantidad: " + ((Ketchup) extra).getCantidad() + ")"); // Ketchup
            } else if (extra instanceof Mayonesa) {
                System.out.println(" ~=~~=~~=~~=~ (Cantidad: " + ((Mayonesa) extra).getCantidad() + ")"); // Mayonesa
            }
        }
        System.out.println(" ----(  )----"); // Carne
        System.out.println("##############"); // Pan inferior
    }
    
 
    public void servir() {
        System.out.println("Sirviendo la hamburguesa.");
        this.hamburguesa = null; 
    }
}