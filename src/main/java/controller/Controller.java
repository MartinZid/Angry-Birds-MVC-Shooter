package controller;

import cz.fit.dpo.mvcshooter.Model;
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
        switch(key) {
            case KeyEvent.VK_UP: 
                model.moveCannonUp();
                break;
            case KeyEvent.VK_DOWN: 
                model.moveCannonDown();
                break;
        }
    }
    
}
