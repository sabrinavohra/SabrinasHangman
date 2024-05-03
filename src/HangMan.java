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
    private boolean won;
    String guess;

    public HangMan() {
        theWord = new Word();
        front = new HangManViewer(this);
        front.addKeyListener(this);
        this.numLetters = theWord.getNumLetters();
        state = 0;
        guessed = new ArrayList<String>();
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
    public void isWon() {
        if(numLetters == 0) {
            state = 2;
            front.repaint();
        }
    }

    public void checkLetter(String letter) {
        boolean in = false;
        guess = letter;
        guessed.add(letter);
        // Change getNumLetters() to the number of letters that are missing from the word
        for(int i = 0; i < theWord.getNumLetters(); i ++) {
            String currentLetter = theWord.getWord().substring(i, i+1);
            if(currentLetter.equals(guess)) {
                state = 4;
                in = true;
                guessIndex = i;
                this.numLetters--;
                front.repaint();
                isWon();
            }
        }
        if(!in) {
            state = 5;
            front.repaint();
        }
    }
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
