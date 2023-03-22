package game;

import java.text.Collator;
import java.util.*;

public class TipMemory {

    private final Set<Character> incorrectTips = new TreeSet<>();

    private final List<Character> correctTips = new ArrayList<>();

    public TipMemory(int size) {
        for (int i = 0; i < size; i++) {
            correctTips.add(i, '-');
        }
    }

    public void setIncorrectTips(char incorrectTip) {
        incorrectTips.add(incorrectTip);
    }

    public Set<Character> getIncorrectTips() {
        return incorrectTips;
    }

    public void setCorrectTips(char correctTip, List<Character> randomWordCharacters) {
        for (int i = 0; i < randomWordCharacters.size(); i++) {
            if (randomWordCharacters.get(i) == correctTip) {
                correctTips.set(i, correctTip);
            }
        }
    }

    public List<Character> getCorrectTips() {
        return correctTips;
    }

}
