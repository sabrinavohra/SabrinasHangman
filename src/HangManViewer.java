import javax.swing.*;
import java.awt.*;
public class HangManViewer extends JFrame {
    public static final int WINDOW_WIDTH = 1000,
            WINDOW_HEIGHT = 900,
            BUFFER_LENGTH = 50,
            START_X = 500,
            START_Y = 400;


    private HangMan h;
    private Word w;

    public HangManViewer(HangMan h) {
        this.h = h;
        w = h.getTheWord();
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Hangman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        int state = h.getState();
        Font a = new Font("TimesRoman Bold", Font.BOLD, 50);
        if(state == 0) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        }
        if(state == 1) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.GREEN);
            for(int i = 0; i < w.getNumLetters(); i++) {
                int startX = START_X + (i * START_X) + (i * BUFFER_LENGTH);
                g.drawLine(startX, START_Y, startX + START_X, START_Y);
            }
        }
        if(state == 2) {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.BLACK);
            g.setFont(a);
            g.drawString("YOU WIN!", WINDOW_WIDTH / 3, WINDOW_HEIGHT / 2);
        }
    }
}
