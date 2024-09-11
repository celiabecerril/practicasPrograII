package Repos.pyDiaDietaIngesta;
import java.util.Scanner;

public class pyDiaDietaIngesta {
    static Scanner scanner = new Scanner(System.in);
    static String[][][] foods = new String[5][5][10]; // 5 days, 5 meals each day, up to 10 foods each meal
    static int[][] foodCounts = new int[5][5]; // number of foods entered for each meal of each day
    static String[] mealNames = {"Breakfast", "Mid-morning", "Lunch", "Snack", "Dinner"}; // names of the meals

    public static void main(String[] args) {
        String name = askName();
        System.out.println("Patient's name: " + name);

        while (true) {
            int day = askDay();
            if (day == -1) {
                break;
            }
            System.out.println("Selected day: " + day);

            while (true) {
                int meal = askMeal();
                if (meal == -1) {
                    break;
                }
                System.out.println("Selected meal: " + mealNames[meal - 1]);

                while (true) {
                    String food = askFood(day, meal);
                    if (food.equals("-1")) {
                        break;
                    } else if (food.equals("-2")) {
                        listFoods();
                    } else {
                        addFood(day, meal, food);
                        System.out.println("Entered food: " + food);
                    }
                }

                if (allMealsHaveFood()) {
                    listFoods();
                    break;
                }
            }
        }
    }

    public static String askName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    public static int askDay() {
        System.out.print("Enter a day number (1-5, or -1 to exit): ");
        int day = scanner.nextInt();
        scanner.nextLine(); 

        while (day < -1 || day > 5) {
            System.out.println("Invalid day number. Please enter a number between 1 and 5, or -1 to exit.");
            System.out.print("Enter a day number (1-5, or -1 to exit): ");
            day = scanner.nextInt();
            scanner.nextLine();
        }

        return day;
    }

    public static int askMeal() {
        System.out.println("Select intake: 1 (Breakfast) / 2 (Mid-morning) / 3 (Lunch) / 4 (Snack) / 5 (Dinner) / -1 (Previous menu)");
        int meal = scanner.nextInt();
        scanner.nextLine(); 

        while (meal < -1 || meal > 5 || meal == 0) {
            System.out.println("Invalid meal number. Please enter a number between 1 and 5, or -1 for the previous menu.");
            System.out.println("Select intake: 1 (Breakfast) / 2 (Mid-morning) / 3 (Lunch) / 4 (Snack) / 5 (Dinner) / -1 (Previous menu)");
            meal = scanner.nextInt();
            scanner.nextLine(); 
        }

        return meal;
    }

    public static String askFood(int day, int meal) {
        System.out.println("Enter a food for " + mealNames[meal - 1] + " of day " + day + " (-1 to go back, -2 to list foods): ");
        return scanner.nextLine();
    }

    public static void addFood(int day, int meal, String food) {
        foods[day - 1][meal - 1][foodCounts[day - 1][meal - 1]] = food;
        foodCounts[day - 1][meal - 1]++;
    }

    public static void listFoods() {
        System.out.println("All entered foods:");
        for (int day = 0; day < 5; day++) {
            for (int meal = 0; meal < 5; meal++) {
                for (int i = 0; i < foodCounts[day][meal]; i++) {
                    System.out.println("Day " + (day + 1) + ", " + mealNames[meal] + ": " + foods[day][meal][i]);
                }
            }
        }
    }

    public static boolean allMealsHaveFood() {
        for (int day = 0; day < 5; day++) {
            for (int meal = 0; meal < 5; meal++) {
                if (foodCounts[day][meal] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}