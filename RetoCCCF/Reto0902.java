
import java.util.Scanner;

public class Reto0902 {
    public static void main(String[] args) {
        Reto0902 reto = new Reto0902();
        reto.simularDia();
        reto.updateCashRegisters(); 
    }

    private int cola = 0;
    int contadorPersonas = 0;
    int contadorPaquetes = 0;
    private int paquetesCaja1 = 0;
    private int paquetesCaja2 = 0;
    private int paquetesCaja3 = 0;
    private int paquetesCaja4 = 0;
    private int paquetesCaja5 = 0;
    int contadorReset = 0;

    public void simularDia() {
        int minutosDia = 12 * 60;
        for (int i = 0; i < minutosDia; i++) {
            double probabilidadPersonaLlegue = Math.random();
            int persona = (probabilidadPersonaLlegue <= 0.4) ? 1 : 0;
    
            if (persona == 1) {
                cola++;
                contadorPersonas++;
            }
    
            restarPaquetePorMinuto();
            revisarCola();
            mostrarMinuto(i, persona);
        }
    }
    

    
    public void restarPaquetePorMinuto() {
        if (paquetesCaja1 != 0) {
            paquetesCaja1--;
        
        } if (paquetesCaja2 != 0) {
            paquetesCaja2--;
        
        }  if (paquetesCaja3 != 0) {
            paquetesCaja3--;
        
        }  if (paquetesCaja4 != 0) {
            paquetesCaja4--;
        
        }  if (paquetesCaja5 != 0) {
            paquetesCaja5--;
        } 
    }

    public void revisarCola() {
        for (int j = 1; j <= cola; j++) {
            int numeroPaquetes = (int) (Math.random() * 11 + 5);
            asignarPaqueteACaja(numeroPaquetes);
        }
    }

    public void asignarPaqueteACaja(int numeroPaquetes) {
        if (paquetesCaja1 == 0) {
            paquetesCaja1 = numeroPaquetes;
            cola--;
            contadorPaquetes += numeroPaquetes;
        } else if (paquetesCaja2 == 0) {
            paquetesCaja2 = numeroPaquetes;
            cola--;
            contadorPaquetes += numeroPaquetes;
        } else if (paquetesCaja3 == 0) {
            paquetesCaja3 = numeroPaquetes;
            cola--;
            contadorPaquetes += numeroPaquetes;
        } else if (paquetesCaja4 == 0) {
            paquetesCaja4 = numeroPaquetes;
            cola--;
            contadorPaquetes += numeroPaquetes;
        } else if (paquetesCaja5 == 0) {
            paquetesCaja5 = numeroPaquetes;
            cola--;
            contadorPaquetes += numeroPaquetes;
        }
    }

    public void mostrarMinuto(int minuto, int persona) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-".repeat(25));
        System.out.println("Minuto " + minuto + ": Ha entrado " + persona + " persona/s");
        System.out.println("Hay " + cola + " persona/s en la cola");
        System.out.println("Paquetes: Caja1[" + paquetesCaja1 + "] Caja2[" + paquetesCaja2 + "] Caja3[" + paquetesCaja3 + "] Caja4[" + paquetesCaja4 + "] Caja5[" + paquetesCaja5 + "]");
        System.out.println("-".repeat(25) + "\n");
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine();
    }


    private void updateCashRegisters() {
        int[] registradora = new int[5]; // Declare and initialize the cashRegisters array
        int numCashRegisters = 5; // Assuming there are 5 cash registers
        for (int i = 0; i < numCashRegisters; i++) {
            if (registradora[i] > 0) {
                registradora[i]--;
            }
        }
    }

}
