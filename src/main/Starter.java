package main;

import game.Completion;
import game.Session;
import printer.Printer;
import userinput.UserInput;

public class Starter {
    private final Printer printer = new Printer();
   private final UserInput userInput = new UserInput();


    public void startGame() {

        Session session = new Session();
        printer.printWelcomeText();
        for (boolean firstSession = true; canSessionStart(firstSession); firstSession = false) {
            if (session.playGame().equals(Completion.ABRUPT_QUIT)) {
                break;
            }
        }
        printer.printGoodbyeText();
    }

    private boolean canSessionStart(boolean whichSession) {
        printer.printSessionStarter(whichSession);
        return userInput.canSessionStart();
    }
}
