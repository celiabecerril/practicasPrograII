package Intervalo;
class Intervalo{

    private double inferior;
    private double superior;

    public Intervalo(){
        superior = 0;
        inferior = 0;
    }

    public Intervalo(double inferior, double superior){
        this.inferior = inferior;
        this.superior = superior;
    }

    public Intervalo(double superior) {
        inferior = 0;
        this.superior = superior;
    }

    public Intervalo(Intervalo intervalo){
        this(intervalo.inferior, intervalo.superior);
    }

    public double longitud(){
        return (superior - inferior);
    }


    public Intervalo clonar(){
        return new Intervalo(this);
    }


    public void mostrar(){
        System.out.println("(" + inferior + " , " + superior + ")");
    } 
    
    public void doblar() {
        inferior = inferior * 2;
        superior = superior * 2;

    }


    public static void main(String[] args) {
        Intervalo intervalo = new Intervalo(2,7);
        //Intervalo intervalo2 = new Intervalo(5);
       // Intervalo intervalo3 = new Intervalo(intervalo2);
       // Intervalo intervalo4 = intervalo.clonar();

        
        intervalo.mostrar();    
        System.out.println("Longitud: " + intervalo.longitud());

        intervalo.doblar();
        intervalo.mostrar();

        

    }

}
