package controller;

import model.Model;
import java.awt.event.KeyEvent;
import model.memento.Caretaker;

/**
 *
 * @author Martin
 */
public class Controller {
    
    private final Model model;
    private final Caretaker caretaker;
    
    public Controller(Model model)
    {
        this.model = model;
        this.caretaker = new Caretaker(model);
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
            case KeyEvent.VK_LEFT:
                model.forceDown();
                break;
            case KeyEvent.VK_RIGHT:
                model.forceUp();
                break;
            case KeyEvent.VK_D:
                model.angleUp();
                break;
            case KeyEvent.VK_A:
                model.angleDown();
                break;
            case KeyEvent.VK_SHIFT:
                model.toogleCannonState();
                break;
            case KeyEvent.VK_F6:
                caretaker.save();
                break;
            case KeyEvent.VK_F7:
                caretaker.load();
                break;
        }
    }
    
}
