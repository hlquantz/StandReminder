import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver extends JFrame {
    private static final int HEIGHT = 150;
    private static final int WIDTH = 300;
    private static final Font labelFont = new Font("monospaced", Font.PLAIN, 35);
    private static final Font buttonFont = new Font("monospaced", Font.PLAIN, 20);

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

        if(SystemTray.isSupported()){
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage("iPhoto-3-icon.png");
            MenuItem exit = new MenuItem("Exit");
            MenuItem about = new MenuItem("About");
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(exit)) {
                        System.exit(0);
                    } else if (e.getSource().equals(about)) {
                        System.out.println("About");
                    }
                }
            };
            PopupMenu popup = new PopupMenu();

            exit.addActionListener(listener);
            about.addActionListener(listener);
            popup.add(about);
            popup.add(exit);

            TrayIcon trayIcon = new TrayIcon(image, "Sit Stand", popup);
            trayIcon.setImageAutoSize(true);

            trayIcon.addActionListener(listener);

            try{
                tray.add(trayIcon);
            }catch (AWTException e){
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, e);
//                System.err.println(e);
            }
        }else if (!SystemTray.isSupported()){
            System.out.println("not supported");
        }

        //Checks if Operating system is Mac OS X. Pop up will be handled differently if it is.
        if (os.isMac()) {
            time();
        } else {
            time();
        }
    }

    //runs the timer for the popups
    private static void time(){

        Timer timer  = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                JDialog d = new JDialog(f, "Reminder", true);
                JButton button = new JButton("OK");
                button.setFont(buttonFont);
                button.addActionListener(e -> d.setVisible((false)));
                d.setLayout(new FlowLayout());
                JLabel label = new JLabel("Time to stand!");
                label.setFont(labelFont);
                d.add(label);
                d.add(button);
                d.setSize(WIDTH,HEIGHT);
                d.setAlwaysOnTop(true);
                d.setVisible(true);
                //System.out.println("test");
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                JDialog d = new JDialog(f, "Reminder", true);
                JButton button = new JButton("OK");
                button.setFont(buttonFont);
                button.addActionListener(e -> d.setVisible((false)));
                d.setLayout(new FlowLayout());
                JLabel label = new JLabel("Time to sit!");
                label.setFont(labelFont);
                d.add(label);
                d.add(button);
                d.setSize(WIDTH,HEIGHT);
                d.setAlwaysOnTop(true);
                d.setVisible(true);
            }
        };
       timer.scheduleAtFixedRate(task, 10000, 3600000);
       timer.scheduleAtFixedRate(task2, 20000, 3600000);
    }

}
