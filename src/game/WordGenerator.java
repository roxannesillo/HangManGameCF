package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGenerator {

    private static final List<String> fileData;

    static {
        try {
            fileData = Files.readAllLines(Paths.get("Words.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Character> getRandomWord() {
        Random random = new Random();
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
        return (randomWord.length() <= Constants.getMaxNumberOfLetters() - 1);
    }


}
