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
                   System.out.println("Tray Icon - Mouse Clicked!");
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
