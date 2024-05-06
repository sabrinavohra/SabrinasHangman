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
    private Image[] body;
    private Image intro;
    private int part;
    private Body toDraw;

    public HangManViewer(HangMan h) {
        toDraw = new Body(h);
        this.h = h;
        theWord = h.getTheWord();
        part = 0;
        intro = new ImageIcon("Resources/intro.png").getImage();
        body = new Image[7];
        // Dimensions of ~ 340 x 400
        body[0] = new ImageIcon("Resources/head.png").getImage();
        // Dimensions of ~ 280 x 450
        body[1] = new ImageIcon("Resources/torso.png").getImage();
        // Dimensions 200 x 500
        body[2] = new ImageIcon("Resources/leftLeg.png").getImage();
        // Dimensions 230 x 500
        body[3] = new ImageIcon("Resources/rightLeg.png").getImage();
        // Dimensions 310 x 420
        body[4] = new ImageIcon("Resources/leftArm.png").getImage();
        // Dimensions 180 x 370
        body[5] = new ImageIcon("Resources/rightArm.png").getImage();
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
            //g.setColor(Color.GREEN);
            g.setColor(Color.ORANGE);
            //g.setFont(b);
            int startX;
            //
            //g.drawString(theWord.getWord(), 50, 50);
            for(int i = 0; i < theWord.getNumLetters(); i++) {
                //startX = START_X + (i * START_X) + (i * BUFFER_LENGTH);
                //g.drawString(h.getDisplayString(), START_X, START_Y);
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
            // Add letters at the index multiplied by start_X to get right coordinate
            g.setColor(Color.BLACK);
            g.fillRect(450, 300, 700, 300);
            g.setColor(Color.ORANGE);
            g.drawString(h.getDisplayString(), START_X, START_Y);
            //g.drawString(h.getGuess(), START_X + (h.getGuessIndex() * BUFFER_LENGTH), START_Y);
        }
        // Letter has been guessed incorrectly
        if(state == 5) {
            System.out.println("state = 5");
            toDraw.drawBody(g);
            g.setColor(Color.GREEN);
            g.drawString(h.getWrongGuesses(), 75, 550);
            //g.drawString(h.getGuess(), 100, 400);
        }
        if(state == 8) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        }

        if(state == 10) {

        }
        if(toDraw.getCurrent() == 6) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.orange);
            g.drawString(theWord.getWord(), 300, 200);
            g.drawString("you lost (uh oh)", 500, 400);
        }
//        if(state == 7) {
//            g.setColor(Color.BLACK);
//            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
//            // Width and height divided by 4
//            g.drawImage(body[0], 100, 150, 85, 100,this);
//            g.drawImage(body[1], 100, 250, 70, 112,this);
//            g.drawImage(body[2], 75, 360, 50, 125,this);
//            g.drawImage(body[3], 140, 360, 58, 125,this);
//            g.drawImage(body[4], 40, 205, 62, 84,this);
//            g.drawImage(body[5], 170, 255, 45, 93,this);
//        }
    }
}
