package model;

import model.observer.Observer;
import model.gameObjects.enemies.Enemy;
import model.gameObjects.Cannon;
import model.gameObjects.Missile;
import view.Canvas;
import java.util.ArrayList;
import java.util.*;
import model.factory.ObjectsFactory;
import model.factory.RealisticObjectsFactory;
import model.factory.SimpleObjectsFactory;
import model.gameObjects.GameObject;

/**
 *
 * @author Martin
 */
public class Model {
    
    private ArrayList<Missile> missiles;
    private Cannon cannon;
    private ArrayList<Enemy> enemies;
    private ArrayList<Observer> observers;
    private ObjectsFactory factory;
    private int gravity;
    
    public Model(String mode) 
    {
        missiles = new ArrayList<Missile>();
        enemies = new ArrayList<Enemy>();
        cannon = new Cannon(100, 100);
        observers = new ArrayList<Observer>();
        gravity = 10;
        if(mode.equals("SIMPLE"))
            factory = new SimpleObjectsFactory();
        else
            factory = new RealisticObjectsFactory();
        run();
    }
    
    private void run()
    {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                moveGameObjects();
            }
        }, 0, 20);
    }
    
    private void moveGameObjects() 
    {
        moveMissiles();
        moveEnemies();
        notifyObservers();
    }
    
    private void moveMissiles()
    {
        for(Missile m: missiles)
        {
            m.move(gravity);
        }
    }

    private void moveEnemies()
    {
        for(Enemy e: enemies)
        {
            e.move();
        }
    }
    
    public Cannon getCannon() 
    {
        return this.cannon;
    }
    
    public ArrayList<GameObject> getAllGameObjects()
    {
        ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
        gameObjects.add(cannon);
        gameObjects.addAll(enemies);
        gameObjects.addAll(missiles);
        return gameObjects;
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
        this.observers.add(o);
        System.out.println(observers);
    }
    
    private void notifyObservers() {
        for(Observer o: observers) {
            o.handleAction();
        }
    }
    public void createMissile() {
        missiles.add(factory.createMissile(cannon.getX(), cannon.getY(), 20, 0));
    }
       
}
