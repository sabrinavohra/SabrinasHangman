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
        Color c = new Color(98, 57, 115);
        Color d = new Color(79, 60, 9);
        Font a = new Font("TimesRoman Bold", Font.BOLD, 50);
        Font b = new Font("TimesRoman Bold", Font.BOLD, 30);
        g.setFont(b);
        if (state == 0) {
            g.drawImage(screens[0], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        }
        if (state == 1) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(d);
            g.fillRect(100, 700, 100, 100);
            g.setColor(Color.ORANGE);
            int startX;
            for (int i = 0; i < theWord.getNumLetters(); i++) {
                startX = START_X + (i * BUFFER_LENGTH);
                g.drawLine(startX, START_Y, startX + UNDERLINE_LENGTH, START_Y);
                startX += UNDERLINE_LENGTH;
            }
            g.setColor(c);
            g.fillRect(50, 500, 300, 100);
        }
        if (state == 2) {
            g.setFont(a);
            g.setColor(Color.LIGHT_GRAY);
            g.drawImage(screens[1], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.drawString(theWord.getWord(), 550, 290);
        }
        // Letter has been guessed correctly
        if (state == 4) {
            g.setColor(Color.BLACK);
            g.fillRect(450, 300, 700, 300);
            g.setColor(Color.ORANGE);
            g.drawString(h.getDisplayString(), START_X, START_Y);
        }
        // Letter has been guessed incorrectly
        if (state == 5) {
            toDraw.drawBody(g);
            g.setColor(Color.GREEN);
            g.drawString(h.getWrongGuesses(), 75, 550);
        }
        if (toDraw.getCurrent() == 6) {
            g.setFont(a);
            g.setColor(Color.LIGHT_GRAY);
            g.drawImage(screens[2], 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.drawString(theWord.getWord(), WORD_PRINT_X, WORD_PRINT_Y);
        }
    }
}
