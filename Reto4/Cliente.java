class Cliente {
   

    private int cantidadItems;


    public Cliente() {
        this.cantidadItems = (int)(Math.random() *11)+5;
    }

    public int cantidadItems() {
        return cantidadItems;
    }   

}