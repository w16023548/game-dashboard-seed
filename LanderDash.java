import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class LanderDash extends JFrame implements Runnable {
    public static final long serialVersionUID = 2L;
    public static void main ( String[] args ) throws UnknownHostException {
        SwingUtilities.invokeLater( new Runnable() {
                public void run() {
                    new LanderDash(args[0], Integer.parseInt(args[1]));
                }
            });
    }

    /* Information from Lander to Display */
    /* Declare some variables to hold Information
    from the game controller to display
     */
    private float altitude; 
    private float fuel;
    private int flying;
    private int crashed;
    private int orientation; 
    private float throttle;
    private int vx, vy;

    private InetSocketAddress address;

    /*
     * Declare pannels to display Information
     */
    AltitudeDisplay altitudeDisplay = new AltitudeDisplay();
    FuelDisplay fuelDisplay = new FuelDisplay();
    OrientationDisplay orientationDisplay = new OrientationDisplay();
    FlyingDisplay flyingDisplay = new FlyingDisplay();
    CrashedDisplay crashedDisplay = new CrashedDisplay();
    LowFuel lowFuel = new LowFuel(); 
    ThrottleDisplay throttleDisplay = new ThrottleDisplay();

    /* Panel to display IP and port numnber */
    DatagramPanel connection = new DatagramPanel();

    public LanderDash(String ip, int port){
        super("Lunar Lander Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(
            new BoxLayout(getContentPane(),BoxLayout.Y_AXIS) );

        /* Add pannels to window */
        address = new InetSocketAddress(ip, port);
        connection.setAddress(address);
        add( connection ) ;
        add(altitudeDisplay);
        add(fuelDisplay);
        add(throttleDisplay);
        add(orientationDisplay);
        add(flyingDisplay);
        add(crashedDisplay);
        add(lowFuel);

        pack();
        setVisible(true);
        (new Thread(this)).start();
    }

    public void run(){
        try {
            DatagramSocket socket = new DatagramSocket(address);
            while(true){
                /* set up socket for reception */
                if(socket!=null){
                    /* start with fresh datagram packet */
                    byte[] buffer = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive( packet );
                    /* extract message and pick appart into
                    lines and key:value pairs
                     */
                    String message = new String(packet.getData());

                    String[] lines = message.trim().split("\n");
                    for(String l : lines) {
                        String[] pair = l.split(":");

                        /* Act on key value pairs,
                        setting properties to display */
                        //Set and display throttle value 
                        if (pair[0].equals("throttle")) {
                            throttle = Float.parseFloat(pair[1]);
                            throttleDisplay.setThrottle(throttle);
                        }
                        //Set and display altitude value
                        if (pair[0].equals("altitude")) {
                            altitude = Float.parseFloat(pair[1]);
                            altitudeDisplay.setAltitude(altitude);
                        }
                        //Set and display fuel level
                        if(pair[0].equals("fuel")) {

                            fuel = Float.parseFloat(pair[1]);
                            fuelDisplay.setFuel(fuel);

                            if (fuel <=  35) {
                                lowFuel.on();
                            }
                            else {
                                lowFuel.off();
                            }

                        }
                        //Set and display flying value
                        if(pair[0].equals("flying")) {
                            flying = Integer.parseInt(pair[1]); 
                            if(flying == 1) {
                                flyingDisplay.on();
                            }
                            else if(flying == 0) {
                                flyingDisplay.off();
                            }

                        }
                        //set and display crash value
                        if(pair[0].equals("crashed")) {
                            crashed = Integer.parseInt(pair[1]);
                            if(crashed == 1) {
                                crashedDisplay.on();
                            }
                            else if(crashed == 0) {
                                crashedDisplay.off();
                            }
                        }
                        //Set and display velocity x and y
                        if(pair[0].equals("Velocity X")) {
                            vx = Integer.parseInt(pair[1]);
                            orientationDisplay.setVX(vx);
                        }
                        if(pair[0].equals("Velocity Y")) {
                            vy = Integer.parseInt(pair[1]);
                            orientationDisplay.setVY(vy);
                        }
                    }
                }
                try{Thread.sleep(50);}catch(InterruptedException e){}
            }
        }
        catch(Exception e) {
            System.err.println(e);
            System.err.println("in LanderDash.run()");
            System.exit(-1);
        }
    }
}
