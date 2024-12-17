import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Driver extends JFrame {
  // Logger for logging messages and errors
  protected static Logger logger;

  // Constants for window dimensions and fonts
  private static final int HEIGHT = 150;
  private static final int WIDTH = 300;
  private static final Font labelFont = new Font("monospaced", Font.PLAIN, 35);
  private static final Font buttonFont = new Font("monospaced", Font.PLAIN, 20);
  private static final String windowTitle = "Reminder";

  // Constructor for the main window
  public Driver() {
    setTitle(windowTitle);                   // Set the title of the window
    setSize(WIDTH, HEIGHT);                  // Set the dimensions of the window
    setDefaultCloseOperation(EXIT_ON_CLOSE); // Exit the application on close
    setVisible(true);                        // Make the main window visible
  }

  //****************************************************************************************************
  // Main method to run the application
  public static void main(String[] args) {
    // Check if the system tray is supported
    if (SystemTray.isSupported()) {
      SystemTray tray = SystemTray.getSystemTray(); // Get system tray instance
      Image image = Toolkit.getDefaultToolkit().getImage(
          "iPhoto-3-icon.png"); // Load the system tray icon
      MenuItem exit = new MenuItem("Exit");
      MenuItem about = new MenuItem("About");

      // Action listener for menu item clicks
      ActionListener listener = e -> {
        if (e.getSource().equals(exit)) {
          System.exit(0); // Exit the application
        } else if (e.getSource().equals(about)) {
          logger.log(null, "About"); // Log about action
        }
      };

      // Create popup menu for the tray icon
      PopupMenu popup = new PopupMenu();
      exit.addActionListener(listener); // Add action listener to exit menu item
      about.addActionListener(
          listener);    // Add action listener  to about menu item
      popup.add(about); // Add about item to popup
      popup.add(exit);  // Add exit item to popup

      // Create the tray icon  with the image and popup menu
      TrayIcon trayIcon = new TrayIcon(image, "Sit Stand", popup);
      trayIcon.setImageAutoSize(true); // Automatically resize the image

      // Add action listener to the tray icon
      trayIcon.addActionListener(listener);

      // Try to add the tray icon to the system tray
      try {
        tray.add(trayIcon);
      } catch (AWTException e) {
        Logger.getLogger(Driver.class.getName())
            .log(Level.SEVERE, null, e); // Log error if adding fails
      }
    } else if (!SystemTray.isSupported()) {
      logger.log(
          null,
          "Not Supported"); // Log warning if system tray is not supported.
    }

    // need to get the program to recognize operating system.
    // Start the timer for reminders
    time();
  }

  // Method to setup timer  for popup reminders
  private static void time() {

    Timer timer = new Timer(); // Create new timer
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        // Create a dialog for the reminder
        JFrame f = new JFrame();
        JDialog d = new JDialog(f, windowTitle, true);
        JButton button = new JButton("OK");
        button.setFont(buttonFont); // Set font for  the button
        button.addActionListener(
            e -> d.setVisible((false))); // Close dialog on button click
        d.setLayout(new FlowLayout());   // Set  layout for the dialog
        JLabel label = new JLabel("Time to stand!"); // Reminder message
        label.setFont(labelFont);                    // Set font for the label
        d.add(label);                                // Add label to dialog
        d.add(button);                               // Add button to dialog
        d.setSize(WIDTH, HEIGHT);                    // Set dialog size
        d.setAlwaysOnTop(true);                      // Keep dialog on top
        d.setVisible(true);                          // Show dialog
      }
    };

    // Timer task for the "Time to sit!" reminder
    TimerTask task2 = new TimerTask() {
      @Override
      public void run() {
        // Create dialog for the reminder
        JFrame f = new JFrame();
        JDialog d = new JDialog(f, windowTitle, true);
        JButton button = new JButton("OK");
        button.setFont(buttonFont); // Set font for the button
        button.addActionListener(
            e -> d.setVisible((false))); // Close dialog on button click
        d.setLayout(new FlowLayout());   // Set layout for dialog
        JLabel label = new JLabel("Time to sit!"); // Reminder message
        label.setFont(labelFont);                  // Set font for the label
        d.add(label);                              // Add label to dialog
        d.add(button);                             // Add button to dialog
        d.setSize(WIDTH, HEIGHT);                  // Set dialog size
        d.setAlwaysOnTop(true);                    // Keep dialog on top
        d.setVisible(true);                        // Show dialog
      }
    };

    // Schedule the "Time to stand!" reminder to run every hour, starting after
    // 10 seconds
    timer.scheduleAtFixedRate(
        task, 10000, 3600000); // 10 second delay, then every hour (3600000 ms)
    // Schedule the "Time to sit!" reminder to run every  hour, starting after
    // 20 seconds
    timer.scheduleAtFixedRate(
        task2, 20000, 3600000); // 20 second delay, then every hour (3600000 ms)
  }
}
