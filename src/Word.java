// Sabrina Vohra

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Word class to create and keep track of current word
public class Word {
    // Declares instance variables for word class
    private static final int MAX_WORDS = 132;
    public static final String[] DICTIONARY = new String[MAX_WORDS];
    private int numLetters;
    private String word;

    // Constructor for Word class
    public Word() {
        // Loads dictionary to pick word
        Word.loadDictionary();
        // Randomly generates word from dictionary
        int whichWord = (int) (Math.random() * MAX_WORDS);
        word = DICTIONARY[whichWord];
        // Initializes the word length
        numLetters = word.length();
    }

    // Method returns the current word
    public String getWord() {
        return word;
    }

    // Method returns the number of letters in the word
    public int getNumLetters() {
        return numLetters;
    }

    // Method returns dictionary
    // Code borrowed from SpellingBee
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
        while (s.hasNextLine()) {
            DICTIONARY[i++] = s.nextLine();
        }
    }
}
