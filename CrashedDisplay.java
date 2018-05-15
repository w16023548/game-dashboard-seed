import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

class CrashedDisplay extends JPanel {
    public static final long serialVersionUID = 2L;

    // Create the image icons
    ImageIcon[] indicator = {
            new ImageIcon("led-grey.png"),
            new ImageIcon("led-red.png")
        };

    JLabel icon = new JLabel();

    public CrashedDisplay() {
        /*
         * Apply layout for the GUI
         */
        super( new FlowLayout( FlowLayout.LEFT, 5, 3));
        add(new JLabel ("Crashed: "));
        add(icon);
        icon.setIcon(indicator[0]);
    }
    //Display red icon when it's crashed
    public void on(){
        icon.setIcon(indicator[1]);
    }
    //hide red icon if it's not crash
    public void off(){
        icon.setIcon(indicator[0]);
    }
}
