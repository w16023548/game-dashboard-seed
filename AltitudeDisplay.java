import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class AltitudeDisplay extends JPanel {
    private static final long serialVersionUID = 42l;

    /* Create GUI elements to display altitude and related
    information
     */
    JTextField altitude; 

    public AltitudeDisplay() {
        /*
         * Apply layout for the GUI
         */
        super( new FlowLayout( FlowLayout.LEFT, 5, 3));
        add(new JLabel("Altitude:"));
        altitude = new JTextField(5);
        add(this.altitude);
    }

    public void setAltitude(float alt) {
        //Update display of altitude with the value retrieve 
        altitude.setText( Float.toString(alt) );
    }
}
