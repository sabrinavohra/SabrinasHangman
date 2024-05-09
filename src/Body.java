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
    // Creates Arrays to hold the given information about each body part
    // Allows for more efficient drawBody() method with only one call to drawImage()
    private static int[] xs;
    private static int[] ys;
    private static int[] widths;
    private static int[] heights;
    // Holds the images of each body part
    private Image[] body;
    // Holds the current body part
    private int current;
    private HangManViewer front;

    // Constructor for Body class
    public Body(HangMan h) {
        // Initializes instance of HangManViewer
        front = h.getFront();
        // Sets current body part to the first
        current = 0;
        // Implements each array to hold given information
        xs = new int[6];
        xs[0] = HEAD_X;
        xs[1] = TORSO_X;
        xs[2] = LEFT_LEG_X;
        xs[3] = RIGHT_LEG_X;
        xs[4] = LEFT_ARM_X;
        xs[5] = RIGHT_ARM_X;
        ys = new int[6];
        ys[0] = HEAD_Y;
        ys[1] = TORSO_Y;
        ys[2] = LEFT_LEG_Y;
        ys[3] = RIGHT_LEG_Y;
        ys[4] = LEFT_ARM_Y;
        ys[5] = RIGHT_ARM_Y;
        widths = new int[6];
        widths[0] = HEAD_WIDTH;
        widths[1] = TORSO_WIDTH;
        widths[2] = LEFT_LEG_WIDTH;
        widths[3] = RIGHT_LEG_WIDTH;
        widths[4] = LEFT_ARM_WIDTH;
        widths[5] = RIGHT_ARM_WIDTH;
        heights = new int[6];
        heights[0] = HEAD_HEIGHT;
        heights[1] = TORSO_HEIGHT;
        heights[2] = LEFT_LEG_HEIGHT;
        heights[3] = RIGHT_LEG_HEIGHT;
        heights[4] = LEFT_ARM_HEIGHT;
        heights[5] = RIGHT_ARM_HEIGHT;
        // Initializes each body part's image
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

    // Draws each body part using current to find which body part needs to be drawn next
    public void drawBody(Graphics g) {
        g.drawImage(body[current], xs[current], ys[current], widths[current], heights[current], front);
        // Adds one to current so next body part will be the next in the sequence
        current++;
    }
}