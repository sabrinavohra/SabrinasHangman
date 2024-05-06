// Sabrina Vohra
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Word {
    private static final int MAX_WORDS = 132;
    public static final String[] DICTIONARY = new String[MAX_WORDS];
    private int numLetters;
    private String word;
    private String foundLetters;
    private String lostLetters;
    private String guessedLetters;

    public Word() {
        Word.loadDictionary();
        int whichWord = (int)(Math.random() * MAX_WORDS);
        word = DICTIONARY[whichWord];
        numLetters = word.length();
    }

    public String getWord() {
        return word;
    }

    public int getNumLetters() {
        return numLetters;
    }
    // Method should figure out if letter has been found (repeating letters???)
    public boolean isFoundLetter(int index) {
        for(int i = 0; i < foundLetters.length(); i++) {
            if(foundLetters.substring(i, i + 1).equals(index)) {
                return true;
            }
        }
        return false;
    }

    // Code from SpellingBee, but with different dictionary
    public static void loadDictionary() {
        Scanner s;
        File dictionaryFile = new File("Resources/myDictionary.txt");
        try {
            s = new Scanner(dictionaryFile);
        } catch (FileNotFoundException e) {
            System.out.println("Could not open dictionary file.");
            return;
        }
        int i = 0;
        while(s.hasNextLine()) {
            DICTIONARY[i++] = s.nextLine();
        }
    }
}
