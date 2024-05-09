// Sabrina Vohra

import javax.swing.*;
import java.awt.*;

// Body class to keep track of and draw body parts
public class Body {
    // Declares instance variables for Body class
    // Initializes size and location of each body part
    public static final int HEAD_X = 100,
            HEAD_Y = 150,
            HEAD_WIDTH = 85,
            HEAD_HEIGHT = 100,
            TORSO_X = 100,
            TORSO_Y = 250,
            TORSO_WIDTH = 70,
            TORSO_HEIGHT = 112,
            LEFT_LEG_X = 75,
            LEFT_LEG_Y = 360,
            LEFT_LEG_WIDTH = 50,
            LEFT_LEG_HEIGHT = 125,
            RIGHT_LEG_X = 140,
            RIGHT_LEG_Y = 360,
            RIGHT_LEG_WIDTH = 58,
            RIGHT_LEG_HEIGHT = 125,
            LEFT_ARM_X = 40,
            LEFT_ARM_Y = 205,
            LEFT_ARM_WIDTH = 62,
            LEFT_ARM_HEIGHT = 84,
            RIGHT_ARM_X = 170,
            RIGHT_ARM_Y = 255,
            RIGHT_ARM_WIDTH = 45,
            RIGHT_ARM_HEIGHT = 93;
    private Image[] body;
    private int current;
    private HangManViewer front;

    public Body(HangMan h) {
        // Initializes instanceof HangManViewer
        front = h.getFront();
        // Sets current body part to the first
        current = 0;
        // Initializes each body part
        body = new Image[6];
        body[0] = new ImageIcon("Resources/head.png").getImage();
        body[1] = new ImageIcon("Resources/torso.png").getImage();
        body[2] = new ImageIcon("Resources/leftLeg.png").getImage();
        body[3] = new ImageIcon("Resources/rightLeg.png").getImage();
        body[4] = new ImageIcon("Resources/leftArm.png").getImage();
        body[5] = new ImageIcon("Resources/rightArm.png").getImage();
    }

    // Returns current state / which body part to print
    public int getCurrent() {
        return current;
    }

    // Draws each body part depending on which ones have already been drawn
    public void drawBody(Graphics g) {
        if (current == 0) {
            g.drawImage(body[current], HEAD_X, HEAD_Y, HEAD_WIDTH, HEAD_HEIGHT, front);
        }
        if (current == 1) {
            g.drawImage(body[current], TORSO_X, TORSO_Y, TORSO_WIDTH, TORSO_HEIGHT, front);
        }
        if (current == 2) {
            g.drawImage(body[current], LEFT_LEG_X, LEFT_LEG_Y, LEFT_LEG_WIDTH, LEFT_LEG_HEIGHT, front);
        }
        if (current == 3) {
            g.drawImage(body[current], RIGHT_LEG_X, RIGHT_LEG_Y, RIGHT_LEG_WIDTH, RIGHT_LEG_HEIGHT, front);
        }
        if (current == 4) {
            g.drawImage(body[current], LEFT_ARM_X, LEFT_ARM_Y, LEFT_ARM_WIDTH, LEFT_ARM_HEIGHT, front);
        }
        if (current == 5) {
            g.drawImage(body[current], RIGHT_ARM_X, RIGHT_ARM_Y, RIGHT_ARM_WIDTH, RIGHT_ARM_HEIGHT, front);
        }
        current++;
    }
}