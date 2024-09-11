
class CentroComercial {

    private Caja[] cajas;
    private Cliente[] cola;
    private int ultimo;

    public CentroComercial(){
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja(i);
        }
        cola = new Cliente[100];
        ultimo = 0;
    }

    public void recibe(Cliente cliente) {
        cola[ultimo] = cliente;
        ultimo++;
    }

    public void actualizar() {
        if(ultimo>0) {
            deColaACaja();
        }
        atiendeCajas();
    }

    private void deColaACaja() {
        for(int i=0;i<cajas.length;i++){
            if (cajas[i].estaLibre()){
                Cliente cliente = cola[ultimo];
                ultimo--;
                cajas[i].recibe(cliente, (int)(Math.random()*10));
            }
            if (ultimo==0){
                break;
            }
        }
    }

    private void atiendeCajas() {
        for (int i = 0; i < cajas.length; i++) {
            cajas[i].atiende();
        }
    }

    public void verEstado(int minutoActual) {
        System.out.println("Minuto actual: "+minutoActual);
        System.out.println(ultimo + " personas en cola");
        for (int i = 0; i < cajas.length; i++) {
            cajas[i].verEstado();
        }
    }
}
