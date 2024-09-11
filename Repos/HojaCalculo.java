package Repos;

import java.util.Scanner;

public class HojaCalculo {

    public static void main(String[] args) {
        initializeMatrix();
        interactWithUser();
    }

    private static final int ROWS = 16;
    private static final int COLUMNS = 11;
    private static String[][] matrix = new String[ROWS][COLUMNS];
    private static int currentRow = 1;
    private static int currentCol = 1;
    private static final String EXIT_COMMAND = "q";

    public static void initializeMatrix() {

        for (int row = 1; row < ROWS; row++) {
            for (int col = 1; col < COLUMNS; col++) {
                matrix[row][col] = "";
            }
        }

        for (int row = 1; row < ROWS; row++) {
            matrix[row][0] = Integer.toString(row);
        }
        for (int col = 1; col < COLUMNS; col++) {
            matrix[0][col] = Character.toString((char) ('a' + col - 1));
        }
    }

    public static void interactWithUser() {
        String limit = "";
        for (int j = 0; j < COLUMNS; j++) {
            limit += "+-------";
        }
        limit += "+";

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(
                    "By default, you are at 'a1'. Enter 'w', 'a', 's', 'd' to navigate, 'e' to edit, or 'q' to exit:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase(EXIT_COMMAND)) {
                isRunning = false;

            }
            if (isRunning) {
                processInput(input, scanner);

                System.out.println("You are now in cell " + matrix[0][currentCol] + currentRow);
                showMatrix(limit);
            }

        }

        scanner.close();
    }

    public static void processInput(String input, Scanner scanner) {
        switch (input.toLowerCase()) {
            case "w":
                currentRow = Math.max(1, currentRow - 1);
                break;
            case "a":
                currentCol = Math.max(1, currentCol - 1);
                break;
            case "s":
                currentRow = Math.min(ROWS - 1, currentRow + 1);
                break;
            case "d":
                currentCol = Math.min(COLUMNS - 1, currentCol + 1);
                break;
            case "e":
                editCell(scanner);
                break;
        }
    }

    public static void editCell(Scanner scanner) {
        System.out.println("Ingrese el nuevo dato para la celda " + matrix[0][currentCol] + currentRow + ":");
        String newValue = scanner.nextLine();
        if (newValue.length() > 7) {
            newValue = newValue.substring(0, 7);
        }
        matrix[currentRow][currentCol] = newValue;
    }

    public static void showMatrix(String limit) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (col > 0) {
                    System.out.print("|");
                }
                if (matrix[row][col] != null) {
                    System.out.printf("%7s", matrix[row][col]);
                } else {
                    System.out.printf("%7s", "");
                }
            }
            System.out.println("|");
            if (row == 0 || row == ROWS - 1) {
                System.out.println(limit);
            }
        }
    }

}