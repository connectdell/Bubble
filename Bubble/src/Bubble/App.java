package Bubble;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class App extends JFrame {
    private static final long serialVersionUID = -4664152594554232786L;
    private int interval = 1000/100;
    private Panel panel;
    public App() {
        panel = new Panel();
        add(panel);

        setSize(800,620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void addKeyListener(KeyListener l) {
        panel.addKeyListener(l);
        panel.setFocusable(true);
        panel.setRequestFocusEnabled(true);
    }
    public void addMouseLintener(MouseAdapter l) {
        panel.addMouseListener(l);
        panel.addMouseMotionListener(l);
        panel.addMouseWheelListener(l);
    }
    public App(String title) {
        this();
        setTitle(title);
    }
    public void setSize(int width, int height) {
        super.setSize(width, height);
        setLocationRelativeTo(null);
    }
    public void setInterval(int interval) {
        this.interval = interval;
    }
    public void start() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                running();
                panel.repaint();
            }
        }, interval, interval);
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
    private class Panel extends JPanel{
        private static final long serialVersionUID = 8365407815677076591L;

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            painting((Graphics2D)g);
        }
    }
}