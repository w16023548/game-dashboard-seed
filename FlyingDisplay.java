import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

class FlyingDisplay extends JPanel {
    public static final long serialVersionUID = 2L;
    
    
    // Create the image icons 
    ImageIcon[] indicator = {
            new ImageIcon("led-grey.png"),
            new ImageIcon("led-green.png")
        };

    JLabel icon = new JLabel();

    public FlyingDisplay() {
        /*
         * Apply layout for the GUI
         */
        super( new FlowLayout( FlowLayout.LEFT, 5, 3));
        add(new JLabel ("Flying: "));
        add(icon);
        icon.setIcon(indicator[0]);
    }
    //Display Green icon when it's flying
    public void on(){
        icon.setIcon(indicator[1]);
    }
    //Hide green icon when it's not flying
    public void off(){
        icon.setIcon(indicator[0]);
    }
}
