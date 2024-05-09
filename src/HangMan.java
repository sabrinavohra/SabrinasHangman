// Sabrina Vohra

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class HangMan implements KeyListener {

    public static final int GUESS_CORRECT = 3;
    private final Word theWord;
    private HangManViewer front;
    private ArrayList<String> guessed;
    private int state;
    private int numLetters;
    private String displayString;
    private String wrongGuesses;
    private String guess;

    public HangMan() {
        theWord = new Word();
        front = new HangManViewer(this);
        front.addKeyListener(this);
        this.numLetters = theWord.getNumLetters();
        state = 0;
        guessed = new ArrayList<>();
        wrongGuesses = "";
        displayString = "";
        for (int i = 0; i < theWord.getWord().length(); i++) {
            displayString += "_";
        }
        front.repaint();
    }

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

    public String getDisplayString() {
        String newDisplay = "";
        for (int i = 0; i < displayString.length(); i++) {
            newDisplay += " " + displayString.charAt(i);
        }
        return newDisplay;
    }

    public void isWon() {
        if (numLetters == 0) {
            state = 2;
            front.repaint();
        }
    }

    public boolean checkGuessedLetter() {
        for(String s: guessed) {
            if(guess.equals(s)) {
                return false;
            }
        }
        return true;
    }

    public void checkLetter(String letter) {
        boolean in = false;
        guess = letter;
        if (checkGuessedLetter()) {
            guessed.add(letter);
            for (int i = 0; i < theWord.getNumLetters(); i++) {
                if (theWord.getWord().substring(i, i + 1).equals(letter)) {
                    if (i == 0) {
                        displayString = letter + displayString.substring(i + 1);
                    } else {
                        displayString = displayString.substring(0, i) + letter + displayString.substring(i + 1);
                    }
                    state = GUESS_CORRECT;
                    in = true;
                    this.numLetters--;
                    isWon();
                }
            }
            if (!in) {
                state = 4;
                wrongGuesses += "  " + letter;
            }
            front.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                state = 1;
                front.repaint();
                break;
            case KeyEvent.VK_9:
                HangMan newH = new HangMan();
            default:
                String letter = String.valueOf(e.getKeyChar());
                checkLetter(letter);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        HangMan newH = new HangMan();
    }
}
