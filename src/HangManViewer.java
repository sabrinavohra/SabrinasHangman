// Sabrina Vohra

import javax.swing.*;
import java.awt.*;

// HangManViewer class is the front end for the game and paints the screen
public class HangManViewer extends JFrame {
    // Initializes all dimensions, colors, and fonts for the game
    public static final int WINDOW_WIDTH = 1165,
            WINDOW_HEIGHT = 645,
            START_X = 600,
            START_Y = 400,
            WORD_PRINT_X = 550,
            WORD_PRINT_Y = 290;
    public static final Color BOX_COLOR  = new Color(98, 57, 115);
    public static final Font BIG = new Font("TimesRoman Bold", Font.BOLD, 50);
    public static final Font SMALL = new Font("TimesRoman Bold", Font.BOLD, 30);
    // Initializes instance variables for the front end
    private HangMan h;
    private Word theWord;
    private Image[] screens;
    private Body toDraw;

    // HangManViewer constructor implements each instance variable and takes in a parameter of a HangMan for easy access
    // to HanMan's instance variables
    public HangManViewer(HangMan h) {
        // Creates Body object
        toDraw = new Body(h);
        this.h = h;
        theWord = h.getTheWord();
        // Sets each background Image to a value in screens Array
        screens = new Image[3];
        screens[0] = new ImageIcon("Resources/introScreen.png").getImage();
        screens[1] = new ImageIcon("Resources/newWinScreen.png").getImage();
        screens[2] = new ImageIcon("Resources/loseScreen.png").getImage();
        // Sets size, title, exit on close, and visibility for the front end
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Halloween Hangman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // Paint method draws each state
    public void paint(Graphics g) {
        // Gets state from HangMan object
        int state = h.getState();
        g.setFont(SMALL);
        // Draws intro screen
        if (state == HangMan.INTRO) {
            g.drawImage(screens[0], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        }
        // Draws state for user to guess
        if (state == HangMan.PLAYING) {
            // Colors background black
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            // Draws empty displayString
            g.setColor(Color.ORANGE);
            g.drawString(h.getDisplayString(), START_X, START_Y);
            // Draws box for incorrect guesses
            g.setColor(BOX_COLOR);
            g.fillRect(50, 500, 300, 100);
        }
        // Paints winning screen if user has won
        if (state == HangMan.HAS_WON) {
            g.drawImage(screens[1], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            // Prints word
            g.setFont(BIG);
            g.setColor(Color.LIGHT_GRAY);
            g.drawString(theWord.getWord(), 550, 290);
        }
        if (state == HangMan.GUESS_CORRECT) {
            g.setColor(Color.BLACK);
            g.fillRect(450, 300, 700, 300);
            g.setColor(Color.ORANGE);
            g.drawString(h.getDisplayString(), START_X, START_Y);
        }
        if (state == HangMan.GUESS_INCORRECT) {
            toDraw.drawBody(g);
            g.setColor(Color.GREEN);
            g.drawString(h.getWrongGuesses(), 75, 550);
        }
        if (toDraw.getCurrent() == 6) {
            g.drawImage(screens[2], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.setColor(Color.LIGHT_GRAY);
            g.drawString(theWord.getWord(), WORD_PRINT_X, WORD_PRINT_Y);
        }
    }
}
