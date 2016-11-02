package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.view.Canvas;
import java.util.ArrayList;

/**
 *
 * @author Martin
 */
public class Model {
    
    private ArrayList<Missile> missiles;
    private Cannon cannon;
    private ArrayList<Enemy> enemies;
    private ArrayList<Observer> observers;
    
    public Model() 
    {
        this.missiles = new ArrayList<Missile>();
        this.enemies = new ArrayList<Enemy>();
        this.cannon = new Cannon(100, 100);
        this.observers = new ArrayList<Observer>();
    }
    
    public Cannon getCannon() 
    {
        return this.cannon;
    }

    public void moveCannonUp() {
        this.cannon.moveUp();
        notifyObservers();
    }

    public void moveCannonDown() {
        this.cannon.moveDown();
        notifyObservers();
    }

    public void attachObserver(Observer o) {
        System.out.println("Attach observer " + o);
        this.observers.add(o);
        System.out.println(observers);
    }
    
    private void notifyObservers() {
        System.out.println("Notify: " + observers);
        for(Observer o: observers) {
            o.handleAction();
        }
    }
       
}
