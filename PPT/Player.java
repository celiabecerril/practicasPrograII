
import java.util.Random;

public class Player {
    private String name;
    private String choice;

    public Player(String name) {
        this.name = name;
    }

    
    public void choose() {
        Random random = new Random();
        int selection = random.nextInt(3);
        switch (selection) {
            case 0:
                choice = "Piedra";
                break;
            case 1:
                choice = "Papel";
                break;
            case 2:
                choice = "Tijeras";
                break;
        }
    }


    public String choice() {
        return choice;
    }

    public String name() {
        return name;
    }

    public boolean beats(Player other) {
        return (choice.equals("Piedra") && other.choice().equals("Tijeras")) ||
               (choice.equals("Papel") && other.choice().equals("Piedra")) ||
               (choice.equals("Tijeras") && other.choice().equals("Papel"));
    }
}

