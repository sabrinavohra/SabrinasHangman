import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    private Word theWord;
    private int state;
    private int guessIndex;
    String guess;

    public HangMan() {
        theWord = new Word();
        front = new HangManViewer(this);
    }

    public void playGame() {
        state = 7;
        front.repaint();
        Word word1 = new Word();
        front.repaint();
        if(!isWon()) {
            guess();
        }
    }

    public boolean guess() {
//        state = 3;
        return false;
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
    public boolean isWon() {
        return false;
    }

    public void checkLetter(String letter) {
        guess = letter;
        // Change getNumLetters() to the number of letters that are missing from the word
        for(int i = 0; i < theWord.getNumLetters(); i ++) {
            if(theWord.getWord().substring(i, i + 1).equals(letter)) {
                state = 4;
                guessIndex = i;
            }
        }
        state = 5;
        front.repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                playGame();
                guess();
                front.repaint();
                break;
            case KeyEvent.KEY_TYPED:
                String letter = KeyEvent.getKeyText(KeyEvent.KEY_TYPED);
                checkLetter(letter);
                // Research how to get Java letter from key code without finding every single one
                // Method that takes in char for which letter entered
                // Check if char is in mystery word
                // If it is: update
                // Keep track of mystery word and display string
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args)
    {
        // Creates and plays Game
        HangMan newH = new HangMan();
        newH.playGame();
    }
}
