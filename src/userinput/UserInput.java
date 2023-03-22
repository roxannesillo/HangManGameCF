package userinput;

import game.Constants;
import printer.Printer;

import java.util.Scanner;

public class UserInput {

    Printer printer = new Printer();

    private static final String REGEX = "[A-ZÁÉÍÓÖŐÚÜŰ*]";

    Scanner scanner = new Scanner(System.in);

    public char getTip() {
        char tip;
        do {
            printer.printTextWithoutNewLine("Kérek egy betűt: ");
            tip = scanner.next().toUpperCase().charAt(0);
        } while (!isCorrect(tip));
        return tip;
    }

    private boolean isCorrect(char tip) {
        if (tip == Constants.getUserExit()) {
            return true;
        } else return Character.toString(tip).matches(REGEX);
    }

    public boolean canSessionStart() {
        return scanner.nextLine().equalsIgnoreCase("i");
    }
}

