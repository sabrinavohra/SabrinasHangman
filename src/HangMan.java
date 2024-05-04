// Sabrina Vohra
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class HangMan implements KeyListener {
    // Choose a random word from the dictionary
    // Draw the right number of underlines
    // Let user press a letter for guessing a letter
    // Let user press a letter for guessing the entire word
    // Tell user if that's right or not
    // Add to body, if necessary
    // Check if body is completed
    // Check if user has won
    private HangManViewer front;
    private ArrayList<String> guessed;
    private Word theWord;
    private int state;
    private int guessIndex;
    private int numLetters;
    private String displayString;
    private boolean won;
    private String wrongGuesses;
    String guess;
    private int where;

    public HangMan() {
        theWord = new Word();
        front = new HangManViewer(this);
        front.addKeyListener(this);
        this.numLetters = theWord.getNumLetters();
        state = 0;
        guessed = new ArrayList<String>();
        wrongGuesses = "";
        displayString = "";
        where = 0;
        for(int i = 0; i < theWord.getWord().length(); i++) {
            displayString += "_  ";
        }
        front.repaint();
    }

    public void playGame() {
        state = 1;
        front.repaint();
        Word word1 = new Word();
    }

    public Word getTheWord() {
        return theWord;
    }
    public int getState() {
        return state;
    }
    public String getGuess() {
        return guess;
    }
    public int getGuessIndex() {
        return guessIndex;
    }
    public HangManViewer getFront() {
        return front;
    }
    public ArrayList<String> getGuessed () {
        return guessed;
    }
    public String getWrongGuesses() {
        return wrongGuesses;
    }

    public String getDisplayString() {
        return displayString;
    }
    public int getWhere() {
        return where;
    }
    public void isWon() {
        if(numLetters == 0) {
            state = 2;
            front.repaint();
        }
    }

    public boolean checkGuessedLetter() {
        for(int i = 0; i < guessed.size(); i++) {
            if(guess.equals(guessed.get(i))) {
                return false;
            }
        }
        return true;
    }
    // Double letters need to be implemented still to print correctly
    public void checkLetter(String letter) {
        boolean in = false;
        guess = letter;
        if(checkGuessedLetter()) {
            guessed.add(letter);
            for(int i = 0; i < theWord.getNumLetters(); i++) {
                if(theWord.getWord().substring(i, i+1).equals(letter)) {
                    if(i == 0) {
                        displayString = letter + displayString.substring(i+1);
                    }
                    else {
                        displayString = displayString.substring(0, i) + letter + "  " + displayString.substring(i+1);
                    }
                    state = 4;
                    in = true;
                    this.numLetters--;
                    where = i;
                }
            }
            if(!in) {
                state = 5;
                wrongGuesses += "    " + letter;
            }
            front.repaint();
        }
    }
//    public void checkLetter(String letter) {
//        boolean in = false;
//        for(int i = 0; i < guessed.size(); i++) {
//            if(letter.equals(guessed.get(i))) {
//                break;
//            }
//        }
//        guessed.add(letter);
//        guess = letter;
//        // Change getNumLetters() to the number of letters that are missing from the word
//        for(int i = 0; i < theWord.getNumLetters(); i ++) {
//            String currentLetter = theWord.getWord().substring(i, i+1);
//            if(currentLetter.equals(guess)) {
//                state = 4;
//                in = true;
//                guessIndex = i;
//                this.numLetters--;
//                front.repaint();
//                isWon();
//            }
//        }
//        if(!in) {
//            state = 5;
//            wrongGuesses += "  " + letter;
//            front.repaint();
//        }
//    }
    @Override
    public void keyTyped(KeyEvent e) {
        // Research how to get Java letter from key code without finding every single one
        // Method that takes in char for which letter entered
        // Check if char is in mystery word
        // If it is: update
        // Keep track of mystery word and display string
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                state = 1;
                front.repaint();
                break;
//            case KeyEvent.VK_A:
//                state = 5;
//                front.repaint();
//                break;
//            case KeyEvent.VK_B:
//                state = 8;
//                front.repaint();
//                break;
            default:
                Character c = e.getKeyChar();
                String letter = String.valueOf(c);
                checkLetter(letter);
                front.repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args)
    {
        // Creates and plays Game
        HangMan newH = new HangMan();
    }
}
