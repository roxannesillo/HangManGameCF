package userinput;

import game.Constants;
import printer.Printer;

import java.util.Scanner;


public class UserInput {

    private final Printer printer = new Printer();

    private static final String REGEX = "[A-ZÁÉÍÓÖŐÚÜŰ*]";

    private static final Scanner scanner = new Scanner(System.in);


    public char getTip() {
        char tip;
        do {
            printer.printTextWithoutNewLine("Kérek egy betűt: ");
            tip = scanner.next().toUpperCase().charAt(0);
        } while (!isCorrect(tip));
        if (tip == Constants.USER_EXIT) {
            scanner.close();
        }
        return tip;
    }

    private boolean isCorrect(char tip) {
        if (tip == Constants.USER_EXIT) {
            return true;
        } else return Character.toString(tip).matches(REGEX);
    }

    public boolean canSessionStart() {
        String input = scanner.nextLine();
        if (input.equals("i")) {
            return true;
        }
        scanner.close();
        return false;
    }
}

