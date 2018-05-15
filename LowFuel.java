import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

class LowFuel extends JPanel {
    public static final long serialVersionUID = 2L;

    // Create the image icons
    ImageIcon[] indicator = {
            new ImageIcon("led-grey.png"),
            new ImageIcon("led-orange.png")
        };

    JLabel icon = new JLabel();

    public LowFuel() {
        /*
         * Apply layout for the GUI
         */
        super( new FlowLayout( FlowLayout.LEFT, 5, 3));
        add(new JLabel ("Low Fuel: "));
        add(icon);
        icon.setIcon(indicator[0]);
    }
    //Display orange icon when fuel is low 
    public void on(){
        icon.setIcon(indicator[1]);
    }
    //Hide orange icon if fuel is not low 
    public void off(){
        icon.setIcon(indicator[0]);
    }
}
