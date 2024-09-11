package Repos.EscalasAcordes;
import java.util.Scanner;

public class MajorScales {
    private static final String[] notes = {"do", "do#", "re", "re#", "mi", "fa", "fa#", "sol", "sol#", "la", "la#", "si"};
    private static final int[] majorPattern = {2, 2, 1, 2, 2, 2, 1}; 

    public static void main(String[] args) {
        System.out.println("Enter a note:");
        Scanner scanner = new Scanner(System.in);
        String note = scanner.nextLine().toLowerCase();
        printMajorScale(note);
        printMajorChord(note);
        scanner.close();
    }

    public static void printMajorScale(String note) {
        int noteIndex = -1;
        for (int i = 0; i < notes.length; i++) {
            if (notes[i].equals(note)) {
                noteIndex = i;
                break;
            }
        }

        if (noteIndex == -1) {
            System.out.println("Unrecognized note.");
            return;
        }

        System.out.print(note + " ");
        for (int i = 0; i < majorPattern.length; i++) {
            noteIndex = (noteIndex + majorPattern[i]) % notes.length;
           
            System.out.print(notes[noteIndex] + " ");
        }
        
    }

    public static void printMajorChord(String note) {
        int noteIndex = -1;
        for (int i = 0; i < notes.length; i++) {
            if (notes[i].equals(note)) {
                noteIndex = i;
                break;
            }
        }

        if (noteIndex == -1) {
            System.out.println("Unrecognized note.");
            return;
        }

        int[] scaleInd = new int[majorPattern.length + 1];
        scaleInd[0] = noteIndex;
        for (int i = 0; i < majorPattern.length; i++) {
            noteIndex = (noteIndex + majorPattern[i]) % notes.length;
            scaleInd[i + 1] = noteIndex;
        }

        System.out.print("\nMajor chord: ");
        System.out.print(notes[scaleInd[0]] + " "); // Tonic
        System.out.print(notes[scaleInd[2]] + " "); // Mediant
        System.out.print(notes[scaleInd[4]] + " "); // Dominant
    }
}