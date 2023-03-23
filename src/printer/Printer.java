package printer;

import java.util.List;
import java.util.Set;

public class Printer {

    public void printWelcomeText() {
        System.out.println("\nÜdvözöllek a Szókitalálós játékban!\n" + " \n" + "A játék egy-egy menetében egy szót kell kitalálnod.\n" + "A szó legfeljebb 11 betűs magyar szó, szóközök, kötőjelek és más írásjelek nélkül, szófajára\n" + "nézve főnév, melléknév, vagy ige, ragozatlan alakban, ill. egyes szám 3. személyben.\n" + "Egyszerre egy betűt adhatsz meg; a szó kitalálásához az összes betűt azonosítanod kell. Ehhez\n" + "legfeljebb 12 lehetőséged van. A program segítségképpen felfedi a szóban az eltalált betűket,\n" + "és számon tartja azokat a betűket is, amelyek hibás tippnek bizonyultak. Tippeléskor a kis- és\n" + "nagybetűk közti különbség nem számít.");
    }

    public void printTextWithNewLine(String text) {
        System.out.println(text);
    }

    public void printTextWithoutNewLine(String text) {
        System.out.print(text);
    }

    public void printCorrectTips(List<Character> correctTips) {
        for (Character element : correctTips) {
            System.out.print(element);
        }
        System.out.println();
    }
    public void printIncorrectTips(Set<Character> incorrectTips){
        System.out.print("Rossz tippek: ");
        for (Character element : incorrectTips){
           System.out.print(element + ", ");
       }
        System.out.println();
    }

    public void printGoodbyeText() {
        System.out.println("\nViszlát!");
    }

    public void printSessionStarter(boolean whichSession) {
        System.out.printf("\nKezdődhet a(z) %s menet (i / n)?: ", whichSession ? "első" : "következő");

    }
}
