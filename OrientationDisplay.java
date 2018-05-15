import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class OrientationDisplay extends JPanel {
    // private static final long serialVersionUID = 42l;

    // JTextField orientation; 

    // public OrientationDisplay() {
        // super( new FlowLayout( FlowLayout.LEFT, 5, 3));
        // add(new JLabel("Orientation:"));
        // orientation = new JTextField(5);
        // add(this.orientation);
    // }

    // public void setOrientation(float angle) {
        // orientation.setText(Float.toString(angle));
    // }
    private static final long serialVersionUID = 42l;
    
    private JLabel vXL, vYL;
    private JTextField vXBox, vYBox;
    
    public OrientationDisplay(){
        super( new FlowLayout( FlowLayout.LEFT, 5, 0));
        
        setBorder( BorderFactory.createTitledBorder("Velocity"));
        
        vXL = new JLabel();
        vXL.setText("X :");
        add(vXL);
        
        vXBox =  new JTextField(5);
        vXBox.setEditable(false);
        add(vXBox);
        
        vYL = new JLabel();
        vYL.setText("Y :");
        add(vYL);
        
        vYBox =  new JTextField(5);
        vYBox.setEditable(false);
        add(vYBox);
    }
    
    public void setVX(int vX){
        vXBox.setText(Integer.toString(vX));
    }
    public void setVY(int vY){
        vYBox.setText(Integer.toString(vY));
    }
}
