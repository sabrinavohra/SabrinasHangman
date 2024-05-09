// Sabrina Vohra

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

// HangMan class where game is played
public class HangMan implements KeyListener {
    // Holds the names for each state
    public static final int INTRO = 0;
    public static final int PLAYING = 1;
    public static final int HAS_WON = 2;
    public static final int GUESS_CORRECT = 3;
    public static final int GUESS_INCORRECT = 4;
    // Initializes instance variables for HangMan class
    private final Word theWord;
    private HangManViewer front;
    private ArrayList<String> guessed;
    private int state;
    private int numLetters;
    private String displayString;
    private String wrongGuesses;
    private String guess;

    public HangMan() {
        // Initializes the word by calling an instance of the Word class
        theWord = new Word();
        front = new HangManViewer(this);
        // Adds key listener for user input
        front.addKeyListener(this);
        this.numLetters = theWord.getNumLetters();
        // Calls first state
        state = INTRO;
        // Initializes ArrayList to store the values of the already guessed letters
        guessed = new ArrayList<>();
        // Initializes String for the wrong guesses
        wrongGuesses = "";
        // Initializes String that holds the right number of underlines depending on the length of the word
        displayString = "";
        for (int i = 0; i < numLetters; i++) {
            displayString += "_";
        }
        front.repaint();
    }

    // Getters for instance variables to be called from other classes
    public int getState() {
        return state;
    }

    public Word getTheWord() {
        return theWord;
    }

    public HangManViewer getFront() {
        return front;
    }

    public String getWrongGuesses() {
        return wrongGuesses;
    }

    // Returns an updated displayString with spaces in between each letter / underscore
    public String getDisplayString() {
        String newDisplay = "";
        for (int i = 0; i < displayString.length(); i++) {
            newDisplay += " " + displayString.charAt(i);
        }
        return newDisplay;
    }

    // Checks to see if user has won by seeing if there are any letters left to guess
    public void isWon() {
        if (numLetters == 0) {
            // Changes state if user has won
            state = HAS_WON;
            front.repaint();
        }
    }

    // Checks to see if a letter has already been guessed
    public boolean checkGuessedLetter() {
        for(String s: guessed) {
            if(guess.equals(s)) {
                return false;
            }
        }
        return true;
    }

    // Checks each guessed letter to see if it should be in the word
    public void checkLetter(String letter) {
        // Keeps track of whether the letter was in any spots
        boolean in = false;
        guess = letter;
        // Makes sure letter has not already been guessed
        if (checkGuessedLetter()) {
            // Adds letter to ArrayList if it has not been guessed
            guessed.add(letter);
            // Checks every letter in the word to see if it matches with the guessed letter
            for (int i = 0; i < theWord.getNumLetters(); i++) {
                if (theWord.getWord().substring(i, i + 1).equals(letter)) {
                    // Updates displayString if the letter matches
                    if (i == 0) {
                        displayString = letter + displayString.substring(i + 1);
                    }
                    else {
                        displayString = displayString.substring(0, i) + letter + displayString.substring(i + 1);
                    }
                    state = GUESS_CORRECT;
                    in = true;
                    this.numLetters--;
                    isWon();
                }
            }
            // If letter was not in the word, calls a different state and adds guess to the wrongGuesses String
            if (!in) {
                state = GUESS_INCORRECT;
                wrongGuesses += "  " + letter;
            }
            // Repaints the screen for both cases - correct and incorrect guess
            front.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // keyPressed is called for the start of the game, the game being called to restart, or any letter guessed
    @Override
    public void keyPressed(KeyEvent e) {
        // Gets the value of the key that was pressed
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                // Starts game if user pressed enter
                state = PLAYING;
                front.repaint();
                break;
            case KeyEvent.VK_9:
                // Calls a new game if user pressed 9
                HangMan newH = new HangMan();
                break;
            default:
                // In the case that any other key is guessed, takes the value and checks if it's in the word
                String letter = String.valueOf(e.getKeyChar());
                checkLetter(letter);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // Main method calls for the implementation of a new HangMan object
    public static void main(String[] args) {
        HangMan newH = new HangMan();
    }
}
