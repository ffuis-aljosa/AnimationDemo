package animationdemo;

import javax.swing.JFrame;

public class CustomFrame extends JFrame {

    public CustomFrame() {
        CustomPanel panel = new CustomPanel();
       
        add(panel);
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
}
