import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class Driver {
    public static void main(String[] args){

        systemTray();

        Timer timer  = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("test");
            }
        };
       timer.scheduleAtFixedRate(task, 1800000, 1800000);
    }

    private static void systemTray(){
       if(SystemTray.isSupported()){
           SystemTray tray = SystemTray.getSystemTray();
           Image image = Toolkit.getDefaultToolkit().getImage("icon.png");
           MouseListener mouseListener = new MouseListener() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   System.out.println("Tray Icon - Mouse Clicked!");import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class Driver extends JFrame {
    private static final int HEIGHT = 350;
    private static final int WIDTH = 450;

    public Driver(){
        setTitle("Reminder");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContent();
        setVisible(true);
    }

    //****************************************************************************************************
    private void createContent(){

    }

    public static void main(String[] args) {
        OSUtils os = new OSUtils();

        //Checks if Operating system is Mac OS X. Pop up will be handled differently if it is.
        if (os.isMac()) {
            System.out.println("Mac");
            time();
        } else {
//            systemTray();
            time();
        }
    }

    //runs the timer for the popups
    private static void time(){
        Timer timer  = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("test");
            }
        };
       timer.scheduleAtFixedRate(task, 1800000, 1800000);
    }

    //Is to put the app in the status tray on non-Mac devices
//    private static void systemTray(){
//       if(SystemTray.isSupported()){
//           SystemTray tray = SystemTray.getSystemTray();
//           Image image = Toolkit.getDefaultToolkit().getImage("icon.png");
//           MouseListener mouseListener = new MouseListener() {
//               @Override
//               public void mouseClicked(MouseEvent e) {
//                   System.out.println("Tray Icon - Mouse Clicked!");
//               }
//
//               @Override
//               public void mousePressed(MouseEvent e) {
//                    System.out.println("Tray Icon - Mouse Pressed!");
//               }
//
//               @Override
//               public void mouseReleased(MouseEvent e) {
//                    System.out.println("Tray Icon - Mouse released!");
//               }
//
//               @Override
//               public void mouseEntered(MouseEvent e) {
//                    System.out.println("Tray Icon - Mouse entered!");
//               }
//
//               @Override
//               public void mouseExited(MouseEvent e) {
//                    System.out.println("Tray Icon - Mouse exited!");
//               }
//           };
//
////           ActionListener exitListener = new ActionListener() {
////               @Override
////               public void actionPerformed(ActionEvent e) {
////                   System.out.println("Exiting...");
////                   System.exit(0);
////               }
////           };
//       }
//    }
}
               }

               @Override
               public void mousePressed(MouseEvent e) {
                    System.out.println("Tray Icon - Mouse Pressed!");
               }

               @Override
               public void mouseReleased(MouseEvent e) {
                    System.out.println("Tray Icon - Mouse released!");
               }

               @Override
               public void mouseEntered(MouseEvent e) {
                    System.out.println("Tray Icon - Mouse entered!");
               }

               @Override
               public void mouseExited(MouseEvent e) {
                    System.out.println("Tray Icon - Mouse exited!");
               }
           };

           ActionListener exitListener = new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   System.out.println("Exiting...");
                   System.exit(0);
               }
           };
       }
    }

    private static void osx(){

    }
}
