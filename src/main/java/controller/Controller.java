package controller;

import model.Model;
import java.awt.event.KeyEvent;

/**
 *
 * @author Martin
 */
public class Controller {
    
    private Model model;
    
    public Controller(Model model)
    {
        this.model = model;
    }

    public void keyPressed(int key)
    {
        System.out.println("Key pressed: " + key);
        switch(key) {
            case KeyEvent.VK_UP: 
                model.moveCannonUp();
                break;
            case KeyEvent.VK_DOWN: 
                model.moveCannonDown();
                break;
            case KeyEvent.VK_SPACE:
                model.createMissile();
                break;
        }
    }
    
}
