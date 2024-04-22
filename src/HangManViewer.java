import javax.swing.*;
import java.awt.*;
public class HangManViewer extends JFrame {
    public static final int WINDOW_WIDTH = 900,
            WINDOW_HEIGHT = 500;

    private HangMan h;

    public HangManViewer(HangMan h) {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Hangman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
    }
}
