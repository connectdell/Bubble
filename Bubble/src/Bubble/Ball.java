package Bubble;
import java.awt.Color;
import java.awt.Graphics2D;
public class Ball {
    int d;
    double x;
    double y;
    int i;
    int j;
    int k;
    Color color;
    double offsetX;
    double offsetY;
    int width;  // 增加宽度参数
    int height; // 增加高度参数
    // 赋值
    public Ball(int width, int height) {
        this.width = width;   // 初始化宽度参数值
        this.height = height; // 初始化高度参数值
        d = (int)(Math.random() * 50) + 10;
        x = (int)(Math.random() * (width - d));
        y = (int)(Math.random() * (height - d));
        i = (int)(Math.random() * 256);
        j = (int)(Math.random() * 256);
        k = (int)(Math.random() * 256);
        color= new Color(i, j, k);
        offsetX = Math.random() * 5 + 1;  // x坐标随机变量
        offsetY = Math.random() * 5 + 1;  // y坐标随机变量
        offsetX = Math.random() < 0.5 ? -offsetX : offsetX;
        offsetY = Math.random() < 0.5 ? -offsetY : offsetY;
    }
    public void move() {
        x += offsetX;
        y += offsetY;

        if (x <= 0 || x + d >= width) {  // 使用成员变量代替getWidth()方法
            offsetX = -offsetX;
        }
        if (y <= 0 || y + d >= height) {  // 使用成员变量代替getHeight()方法
            offsetY = -offsetY;
        }
    }
    public void paint1(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int)x, (int)y, (int)d, (int)d);
    }
    public void paint(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int)x, (int)y, (int)d,(int)d);
    }
}