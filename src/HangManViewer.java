// Sabrina Vohra

import javax.swing.*;
import java.awt.*;

public class HangManViewer extends JFrame {
    public static final int WINDOW_WIDTH = 1165,
            WINDOW_HEIGHT = 645,
            BUFFER_LENGTH = 50,
            UNDERLINE_LENGTH = 20,
            START_X = 600,
            START_Y = 400,
            WORD_PRINT_X = 550,
            WORD_PRINT_Y = 290;
    public static final Color BOX_COLOR  = new Color(98, 57, 115);
    public static final Font BIG = new Font("TimesRoman Bold", Font.BOLD, 50);
    public static final Font SMALL = new Font("TimesRoman Bold", Font.BOLD, 30);
    private HangMan h;
    private Word theWord;
    private Image[] screens;
    private Body toDraw;

    public HangManViewer(HangMan h) {
        toDraw = new Body(h);
        this.h = h;
        theWord = h.getTheWord();
        screens = new Image[3];
        screens[0] = new ImageIcon("Resources/introScreen.png").getImage();
        screens[1] = new ImageIcon("Resources/newWinScreen.png").getImage();
        screens[2] = new ImageIcon("Resources/loseScreen.png").getImage();
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Halloween Hangman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        int state = h.getState();
        g.setFont(SMALL);
        if (state == HangMan.INTRO) {
            g.drawImage(screens[0], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        }
        if (state == HangMan.PLAYING) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.ORANGE);
            for (int i = 0; i < theWord.getNumLetters(); i++) {
                int startX = START_X + (i * BUFFER_LENGTH);
                g.drawLine(startX, START_Y, startX + UNDERLINE_LENGTH, START_Y);
            }
            g.setColor(BOX_COLOR);
            g.fillRect(50, 500, 300, 100);
        }
        if (state == HangMan.HAS_WON) {
            g.setFont(BIG);
            g.setColor(Color.LIGHT_GRAY);
            g.drawImage(screens[1], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
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
