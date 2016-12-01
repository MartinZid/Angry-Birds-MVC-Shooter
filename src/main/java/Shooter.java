import model.Model;
import view.MainWindow;
import javax.swing.SwingUtilities;

/**
 *
 * @author stue
 */
public class Shooter {
    
    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                String mode = "REAL";
                //String mode = "SIMPLE";
                new MainWindow(new Model(mode)).setVisible(true);
            }
        });
    }
}
