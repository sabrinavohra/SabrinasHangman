import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Word {
    private static final int MAX_WORDS = 143091;
    public static final String[] DICTIONARY = new String[MAX_WORDS];
    private int numLetters;
    private String word;
    private String foundLetters;
    private String lostLetters;

    public Word() {
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
    public boolean isFoundLetter(char a) {
        for(int i = 0; i < foundLetters.length(); i++) {
            if(foundLetters.substring(i, i + 1).equals(a)) {
                return true;
            }
        }
        return false;
    }

    public static void loadDictionary() {
        Scanner s;
        File dictionaryFile = new File("Resources/dictionary.txt");
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
