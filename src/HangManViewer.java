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
            WORD_PRINT_Y = 290,
            PRINT_WRONG_GUESS_X = 75,
            PRINT_WRONG_GUESS_Y = 550;
    public static final Color BOX_COLOR = new Color(98, 57, 115);
    public static final Font BIG = new Font("TimesRoman Bold", Font.BOLD, 50),
            SMALL = new Font("TimesRoman Bold", Font.BOLD, 30);
    // Initializes instance variables for the front end
    private static final int BOX1_X = 50,
            BOX1_Y = 500,
            BOX1_WIDTH = 300,
            BOX1_HEIGHT = 100,
            BOX2_X = 450,
            BOX2_Y = 300,
            BOX2_WIDTH = 700,
            BOX2_HEIGHT = 300;
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
            g.fillRect(BOX1_X, BOX1_Y, BOX1_WIDTH, BOX1_HEIGHT);
        }
        // Paints winning screen if user has won
        if (state == HangMan.HAS_WON) {
            g.drawImage(screens[1], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            // Prints word
            g.setFont(BIG);
            g.setColor(Color.LIGHT_GRAY);
            g.drawString(theWord.getWord(), WORD_PRINT_X, WORD_PRINT_Y);
        }
        // Paints new displayString onto screen if guess was correct
        if (state == HangMan.GUESS_CORRECT) {
            g.setColor(Color.BLACK);
            g.fillRect(BOX2_X, BOX2_Y, BOX2_WIDTH, BOX2_HEIGHT);
            g.setColor(Color.ORANGE);
            g.drawString(h.getDisplayString(), START_X, START_Y);
        }
        // Paints new body part and wrong guess onto screen
        if (state == HangMan.GUESS_INCORRECT) {
            toDraw.drawBody(g);
            g.setColor(Color.GREEN);
            g.drawString(h.getWrongGuesses(), PRINT_WRONG_GUESS_X, PRINT_WRONG_GUESS_Y);
        }
        // Paints end screen if user lost (ran out of body parts)
        if (toDraw.getCurrent() == 6) {
            g.drawImage(screens[2], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.setColor(Color.LIGHT_GRAY);
            g.drawString(theWord.getWord(), WORD_PRINT_X, WORD_PRINT_Y);
        }
    }
}
