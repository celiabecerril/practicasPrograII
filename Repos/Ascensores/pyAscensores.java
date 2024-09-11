

package Repos.Ascensores;

import java.util.Random;
import java.util.Scanner;

public class pyAscensores {
    // Define the maximum capacity of the elevators
    private static final int MAX_CAPACITY = 6;

    // Define the number of rows and columns
    private static final int NUM_ROWS = 7;
    private static final int NUM_COLS = 6;

    // Create a 2D array to represent the matrix
    private static int[][] matrix = new int[NUM_ROWS][NUM_COLS];

    // Define the floor names
    private static String[] floorNames = {"Planta 3", "Planta 2", "Planta 1", "Planta B", "Planta -1", "Planta -2", "Planta -3"};

    // Create a Random object for generating random numbers
    private static Random random = new Random();

    public static void main(String[] args) {
        // Initialize the matrix
        initializeMatrix();

        // Create a Scanner to read the user's input
        Scanner scanner = new Scanner(System.in);

        // Simulate elevator movement
        for (int i = 0; i < 100; i++) {
            System.out.println("Presione Enter para mover los ascensores...");
            scanner.nextLine();

            moveElevators();
            printMatrix();
        }

        // Close the Scanner
        scanner.close();
    }

    public static void initializeMatrix() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void printMatrix() {
        for (int i = 0; i < NUM_ROWS; i++) {
            System.out.printf("%-10s", floorNames[i]);
            for (int j = 0; j < NUM_COLS; j++) {
                System.out.printf("%-3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void moveElevators() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 1; j < NUM_COLS - 1; j++) { // Solo las columnas 1 a 4 (0-indexado)
                // Randomly decide whether people will enter or leave the elevator
                if (random.nextBoolean()) {
                    // People enter the elevator
                    int numPeople = random.nextInt(MAX_CAPACITY - matrix[i][j] + 1);
                    matrix[i][j] += numPeople;
                } else {
                    // People leave the elevator
                    int numPeople = random.nextInt(matrix[i][j] + 1);
                    matrix[i][j] -= numPeople;
                }
            }
        }
    }
}