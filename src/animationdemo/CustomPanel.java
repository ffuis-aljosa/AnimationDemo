package animationdemo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CustomPanel extends JPanel implements ActionListener {

    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 600;
    
    Ellipse2D.Double ball;
    
    private int speedX = 3;
    private int speedY = 3;
    private int directionX = 1;
    private int directionY = 1;
    
    public CustomPanel() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(null);
        setBackground(Color.WHITE);
        
        ball = new Ellipse2D.Double(0, 0, 60, 60);
        
        Timer timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setPaint(Color.RED);
        
        g2.fill(ball);
        
        g2.setPaint(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        
        g2.draw(ball);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ball.y + ball.height >= PANEL_HEIGHT)
            directionY = -1;
        if (ball.x + ball.width >= PANEL_WIDTH)
            directionX = -1;
        if (ball.y <= 0)
            directionY = 1;
        if (ball.x <= 0)
            directionX = 1;
        
        ball.x += directionX * speedX;
        ball.y += directionY * speedY;
        
        repaint();
    }
    
}
