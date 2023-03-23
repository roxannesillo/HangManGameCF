package game;

import printer.Printer;
import userinput.UserInput;

import java.util.HashSet;
import java.util.List;

public class Session {

    private final WordGenerator wordGenerator = new WordGenerator();

    private final Printer printer = new Printer();
    private final UserInput userInput = new UserInput();

    public Completion playGame() {
        List<Character> randomWordCharacters = wordGenerator.getRandomWord();
        TipMemory tipMemory = new TipMemory(randomWordCharacters.size());
        printer.printCorrectTips(tipMemory.getCorrectTips());
        int tipCount = 0;
        do {
            char userTip = userInput.getTip();
            if (userTip == Constants.USER_EXIT) {
                return Completion.ABRUPT_QUIT;
            }
            if (randomWordCharacters.contains(userTip)) {
                tipMemory.setCorrectTips(userTip, randomWordCharacters);
            } else {
                tipMemory.setIncorrectTips(userTip);
                tipCount++;
            }
            if (new HashSet<>(randomWordCharacters).containsAll(tipMemory.getCorrectTips())) {
                printer.printTextWithNewLine("Kitaláltad, gratulálok!");
                return Completion.NORMAL_END;
            }
            if (tipCount == Constants.MAX_NUMBER_OF_TIPS) {
                printer.printTextWithNewLine("Ez most sajnos nem sikerült, próbáld újra!");
                return Completion.NORMAL_END;
            }
            printer.printCorrectTips(tipMemory.getCorrectTips());
            printer.printIncorrectTips(tipMemory.getIncorrectTips());

        } while (true);
    }
}
