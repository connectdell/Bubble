package Bubble;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;

public class App extends JFrame {
    private static final long serialVersionUID = -4664152594554232786L;
    private int interval = 1000 / 100;
    private Panel panel;

    public App() {
        panel = new Panel();
        add(panel);

        setTitle("Game Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public void addKeyListener(KeyListener l) {
        panel.addKeyListener(l);
        panel.requestFocusInWindow();
    }

    public void addMouseListener(MouseAdapter l) {
        panel.addMouseListener(l);
        panel.addMouseMotionListener(l);
        panel.addMouseWheelListener(l);
        panel.requestFocusInWindow();
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void start() {
        Timer timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running();
                panel.repaint();
            }
        });
        timer.start();
        setVisible(true);
    }

    /**
     * 重写此方法会自动执行
     */
    public void running() {
    }

    /**
     * 重写此方法，绘制自定义组件
     */
    public void painting(Graphics2D g) {
    }

    private class Panel extends JPanel {
        private static final long serialVersionUID = 8365407815677076591L;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            painting((Graphics2D) g);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 620);
        }
    }
}
