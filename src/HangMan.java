// Sabrina Vohra
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class HangMan implements KeyListener {
    private HangManViewer front;
    private ArrayList<String> guessed;
    private Word theWord;
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
        guessed = new ArrayList<String>();
        wrongGuesses = "";
        displayString = "";
        for(int i = 0; i < theWord.getWord().length(); i++) {
            displayString += "_";
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
    public int getState() { return state; }
    public String getGuess() {
        return guess;
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
        String newDisplay = "";
        for(int i = 0; i < displayString.length(); i++) {
            newDisplay += " " + displayString.charAt(i);
        }
        return newDisplay;
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
                        displayString = displayString.substring(0, i) + letter + displayString.substring(i + 1);
                    }
                    state = 4;
                    in = true;
                    this.numLetters--;
                    isWon();
                }
            }
            if(!in) {
                state = 5;
                wrongGuesses += "  " + letter;
            }
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
            default:
                String letter = String.valueOf(e.getKeyChar());
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
