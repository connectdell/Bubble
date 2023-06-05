package Bubble;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
    private int d;
    private double x;
    private double y;
    private int i;
    private int j;
    private int k;
    private Color color;
    private double offsetX;
    private double offsetY;
    private int width;
    private int height;

    public Ball(int width, int height) {
        this.width = width;
        this.height = height;
        initialize();
    }

    private void initialize() {
        d = (int) (Math.random() * 50) + 10;
        x = (int) (Math.random() * (width - d));
        y = (int) (Math.random() * (height - d));
        i = (int) (Math.random() * 256);
        j = (int) (Math.random() * 256);
        k = (int) (Math.random() * 256);
        color = new Color(i, j, k);
        offsetX = Math.random() * 5 + 1;
        offsetY = Math.random() * 5 + 1;
        offsetX = Math.random() < 0.5 ? -offsetX : offsetX;
        offsetY = Math.random() < 0.5 ? -offsetY : offsetY;
    }

    public void move() {
        x += offsetX;
        y += offsetY;

        if (x <= 0 || x + d >= width) {
            offsetX = -offsetX;
        }
        if (y <= 0 || y + d >= height) {
            offsetY = -offsetY;
        }
    }

    public void paint(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, d, d);
    }
}
