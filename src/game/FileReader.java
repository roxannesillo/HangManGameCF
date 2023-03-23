package game;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static List<String> readFile() {
        List<String> fileData;
        try {
            fileData = Files.readAllLines(Paths.get("Words.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileData;
    }
}
