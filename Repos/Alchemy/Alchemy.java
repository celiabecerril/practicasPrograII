package Repos.Alchemy;

import java.util.Scanner;

public class Alchemy {
    static String[] elements = {
            "Air", "Water", "Earth", "Fire", "Vapor", "Mud", "Lava", "Dust", "Rain", "Plant",
            "Iron", "Sand", "Glass", "Alcohol", "Life", "Energy", "Storm", "Metal", "Electricity",
            "Oxygen", "Ozone", "Diamond", "Carbon", "Pressure", "Wood", "Tool", "Vaporizer",
            "Computer", "Robot"
    };

    static int[][] combinations = {
            { 1, 3, 4 }, { 1, 2, 5 }, { 3, 2, 6 }, { 0, 2, 7 }, { 1, 0, 8 }, { 5, 8, 9 }, { 3, 6, 10 },
            { 0, 6, 11 }, { 11, 3, 12 }, { 10, 4, 13 }, { 5, 15, 14 }, { 0, 3, 15 }, { 15, 8, 16 },
            { 5, 3, 17 }, { 15, 17, 18 }, { 1, 18, 19 }, { 18, 0, 20 }, { 22, 23, 21 }, { 9, 2, 22 },
            { 2, 2, 23 }, { 9, 17, 24 }, { 10, 24, 25 }, { 25, 4, 26 }, { 17, 18, 27 }, { 27, 15, 28 }
    };

    static boolean[] knownElements = new boolean[elements.length];
    
    static final String SEPARATOR = "--------------------------------------";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Welcome to the Alchemy Game!");
        System.out.println("Combine elements to discover new ones.");
        System.out.println(SEPARATOR);

        for (int i = 0; i < 4; i++) {
            knownElements[i] = true;
        }


        do {
            displayMenu();
            System.out.print("> Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println(SEPARATOR);
                    displayElements();
                    System.out.println(SEPARATOR);
                    break;
                case 2:
                    System.out.println(SEPARATOR);
                    proposeCombination(scanner);
                    System.out.println(SEPARATOR);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose an option between 1 and 3.");
                    break;
            }
        } while (option != 3);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("=== MENU DE JUEGO===");
        System.out.println("1. List of elements");
        System.out.println("2. Propose combination");
        System.out.println("3. Exit");
    }

    public static void displayElements() {
        
        System.out.println("Displaying list of known elements...");
        for (int i = 0; i < elements.length; i++) {
            if (knownElements[i]) {
                System.out.println((i + 1) + ". " + elements[i]);
            }
        }
    }

    public static void proposeCombination(Scanner scanner) {

        System.out.print("Enter the number of the first element to combine: ");
        int firstElement = scanner.nextInt() - 1;
        System.out.print("Enter the number of the second element to combine: ");
        int secondElement = scanner.nextInt() - 1;

        for (int i = 0; i < combinations.length; i++) {
            if ((combinations[i][0] == firstElement && combinations[i][1] == secondElement) ||
                (combinations[i][0] == secondElement && combinations[i][1] == firstElement)) {
                System.out.println("Result: " + elements[combinations[i][2]]);
                knownElements[combinations[i][2]] = true;
                return;
            }
        }

        System.out.println("No combination found for these elements.");
    }
}