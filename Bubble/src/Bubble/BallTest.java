package Bubble;

import java.awt.Graphics2D;

public class BallTest extends App {
    private Ball[] balls = new Ball[100];

    public BallTest() {
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(getWidth(), getHeight());
        }
    }

    @Override
    public void painting(Graphics2D g) {
        for (int i = 0; i < balls.length; i++) {
            balls[i].move();
            balls[i].paint(g);
        }
    }

    public static void main(String[] args) {
        BallTest ball = new BallTest();
        ball.start();
    }
}
