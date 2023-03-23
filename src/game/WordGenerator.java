package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGenerator {


    public List<Character> getRandomWord() {
        Random random = new Random();
        List<String> fileData = FileReader.readFile();
        int randomNumber;
        do {
            randomNumber = random.nextInt(0, fileData.size());
        } while (!isWordLengthCorrect(fileData.get(randomNumber)));
        List<Character> characterList = new ArrayList<>();
        for (Character element : fileData.get(randomNumber).toUpperCase().toCharArray()) {
            characterList.add(element);
        }
        return characterList;
    }

    private boolean isWordLengthCorrect(String randomWord) {
        return (randomWord.length() <= Constants.MAX_NUMBER_OF_LETTERS - 1);
    }


}
