
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Heart extends JPanel implements ActionListener {
  
    private double t = 0;
    private Timer timer; 
     public Heart() {
        setBackground(Color.BLACK);
        timer = new Timer(30, this); 
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
g2.setRenderingHint(
    java.awt.RenderingHints.KEY_ANTIALIASING,
    java.awt.RenderingHints.VALUE_ANTIALIAS_ON
);
        g2.setColor(new Color(100,0,0)); 
        g2.setStroke(new BasicStroke(1));

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        double scale = 10;

        for (double i = 0; i <= t; i += 0.01) {

            double x = 16 * Math.pow(Math.sin(i), 3);
            double y = 13 * Math.cos(i)
                     - 5 * Math.cos(2 * i)
                     - 2 * Math.cos(3 * i)
                     - Math.cos(4 * i);

            int x1 = cx;
            int y1 = cy + 80;

            int x2 = (int) (cx + x * scale);
            int y2 = (int) (cy - y * scale);

            g2.drawLine(x1, y1, x2, y2);
             
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        t += 0.03; 
        if (t > Math.PI * 2) {
            timer.stop();
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animated Heart");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(new Heart());
        frame.setVisible(true);
    }
}

