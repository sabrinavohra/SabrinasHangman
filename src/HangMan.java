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
    private String word;
    private HangManViewer front;
    private Word theWord;
    private int state;

    public HangMan() {
        //word = theWord.getWord();
        front = new HangManViewer(this);
    }

    public void playGame() {
        state = 0;
        front.repaint();
        Word word1 = new Word();
    }

    public Word getTheWord() {
        return theWord;
    }
    public int getState() {
        return state;
    }

    @Override
    public void keyTyped(KeyEvent e) {

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
