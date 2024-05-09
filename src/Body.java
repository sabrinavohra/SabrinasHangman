// Sabrina Vohra

import javax.swing.*;
import java.awt.*;

public class Body {
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
        front = h.getFront();
        current = 0;
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
    }

    public int getCurrent() {
        return current;
    }

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