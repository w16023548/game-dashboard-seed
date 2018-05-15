import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class FuelDisplay extends JPanel {
    private static final long serialVersionUID = 42l;

    /* Create GUI elements to display fuel state
    and related information
     */
    JTextField fuel; 

    public FuelDisplay() {
        /*
         * Apply layout for the GUI
         */
        super( new FlowLayout( FlowLayout.LEFT, 5, 3));
        add(new JLabel("Fuel:"));
        fuel = new JTextField(5);
        add(this.fuel);
    }

    public void setFuel(float percent) {
        //Update display of fuel with the value retrieve  
        fuel.setText(Float.toString(percent));
    }
}
