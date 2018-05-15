import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class ThrottleDisplay extends JPanel  {
    private static final long serialVersionUID = 42l;

    /* Create GUI elements to display altitude and related
    information
     */
    JTextField throttle; 

    public ThrottleDisplay() {
        /*
         * Apply layout for the GUI
         */
        super( new FlowLayout( FlowLayout.LEFT, 5, 3));
        add(new JLabel("Throttle:"));
        throttle = new JTextField(5);
        add(this.throttle);
    }

    public void setThrottle(float t) {
        // Update display of throttle with the value retrieve
        throttle.setText( Float.toString(t) );
    }
}
