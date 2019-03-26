import java.util.Random;

public class Main {

    public static int generateRandomNumbers() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public static void main(String[] args) {
        WordAnalyzer wordAnalyzer = new WordAnalyzer("hello");
        System.out.println(wordAnalyzer.firstRepeatedCharacter());
        System.out.println(wordAnalyzer.countRepeatedCharacters());

        wordAnalyzer = new WordAnalyzer("comprehensive");
        System.out.println(wordAnalyzer.firstMultipleCharacter());
        System.out.println(wordAnalyzer.firstRepeatedCharacter());

        wordAnalyzer = new WordAnalyzer("development");
        System.out.println(wordAnalyzer.firstRepeatedCharacter());
        System.out.println(wordAnalyzer.countRepeatedCharacters());

        wordAnalyzer = new WordAnalyzer("mississippi!!!");
        System.out.println(wordAnalyzer.firstMultipleCharacter());
    }
}
