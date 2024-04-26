import javax.swing.*;
import java.awt.*;
public class HangManViewer extends JFrame {
    public static final int WINDOW_WIDTH = 1165,
            WINDOW_HEIGHT = 645,
            BUFFER_LENGTH = 50,
            UNDERLINE_LENGTH = 30,
            START_X = 500,
            START_Y = 400;


    private HangMan h;
    private Word w;
    private Image intro;

    public HangManViewer(HangMan h) {
        this.h = h;
        w = h.getTheWord();
        intro = new ImageIcon("Resources/instructions.png").getImage();
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Hangman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        int state = h.getState();
        Color c = new Color(38, 29, 3);
        Color d = new Color(79, 60, 9);
        Font a = new Font("TimesRoman Bold", Font.BOLD, 50);
        g.drawImage(intro, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        if(state == 0) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
//            g.setColor(Color.GREEN);
            g.drawImage(intro, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        }
        if(state == 1) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(d);
            g.fillRect(100, 700, 100, 100);
            g.setColor(Color.GREEN);
            int startX;
            for(int i = 0; i < w.getNumLetters(); i++) {
                startX = START_X + (i * START_X) + (i * BUFFER_LENGTH);
                g.drawLine(startX, START_Y, startX + UNDERLINE_LENGTH, START_Y);
                startX += UNDERLINE_LENGTH;
            }
        }
        if(state == 2) {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.BLACK);
            g.setFont(a);
            g.drawString("YOU WIN!", WINDOW_WIDTH / 3, WINDOW_HEIGHT / 2);
        }
        if(state == 3) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.GREEN);
            g.drawString("Enter your guess: ", WINDOW_WIDTH / 3, WINDOW_HEIGHT / 2);
        }
    }
}
