// Sabrina Vohra
import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class HangManViewer extends JFrame {
    public static final int WINDOW_WIDTH = 1165,
            WINDOW_HEIGHT = 645,
            BUFFER_LENGTH = 50,
            UNDERLINE_LENGTH = 20,
            START_X = 600,
            START_Y = 400;
    private HangMan h;
    private Word theWord;
    private Image intro;
    private Body toDraw;

    public HangManViewer(HangMan h) {
        toDraw = new Body(h);
        this.h = h;
        theWord = h.getTheWord();
        intro = new ImageIcon("Resources/intro.png").getImage();
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
        if(state == 0) {
            g.drawImage(intro, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        }
        if(state == 1) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(d);
            g.fillRect(100, 700, 100, 100);
            g.setColor(Color.ORANGE);
            int startX;
            for(int i = 0; i < theWord.getNumLetters(); i++) {
                startX = START_X + (i * BUFFER_LENGTH);
                g.drawLine(startX, START_Y, startX + UNDERLINE_LENGTH, START_Y);
                startX += UNDERLINE_LENGTH;
            }
            g.setColor(c);
            g.fillRect(50, 500, 300, 100);
        }
        if(state == 2) {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.BLACK);
            g.setFont(a);
            g.drawString("YOU WIN!", WINDOW_WIDTH / 3, WINDOW_HEIGHT / 2);
            g.setColor(Color.WHITE);
            g.drawString("the word was: " + theWord.getWord(),  WINDOW_WIDTH / 6,  WINDOW_HEIGHT / 3);
        }
        if(state == 3) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.GREEN);
            g.drawString("Enter your guess: ", WINDOW_WIDTH / 3, WINDOW_HEIGHT / 2);
        }
        // Letter has been guessed correctly
        if(state == 4) {
            g.setColor(Color.BLACK);
            g.fillRect(450, 300, 700, 300);
            g.setColor(Color.ORANGE);
            g.drawString(h.getDisplayString(), START_X, START_Y);
        }
        // Letter has been guessed incorrectly
        if(state == 5) {
            System.out.println("state = 5");
            toDraw.drawBody(g);
            g.setColor(Color.GREEN);
            g.drawString(h.getWrongGuesses(), 75, 550);
        }
        if(state == 8) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        }
        if(toDraw.getCurrent() == 6) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.orange);
            g.drawString(theWord.getWord(), 300, 200);
            g.drawString("you lost (uh oh)", 500, 400);
        }
    }
}
