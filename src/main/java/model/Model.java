package model;

import model.observer.Observer;
import model.gameObjects.enemies.Enemy;
import model.gameObjects.Cannon;
import model.gameObjects.Missile;
import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import model.factory.ObjectsFactory;
import model.factory.RealisticObjectsFactory;
import model.factory.SimpleObjectsFactory;
import model.gameObjects.GameObject;
import model.gameObjects.ModelInfo;

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
    private ModelInfo modelInfo;
    
    public Model(String mode) 
    {
        initAttributes(mode);
        run();
    }
    
    private void initAttributes(String mode) 
    {
        missiles = new ArrayList<Missile>();
        enemies = new ArrayList<Enemy>();
        cannon = new Cannon(Config.CANNON_START_X, Config.CANNON_START_Y);
        observers = new ArrayList<Observer>();
        gravity = 10;
        factory = mode.equals("SIMPLE")? new SimpleObjectsFactory(): 
                new RealisticObjectsFactory();
        modelInfo = new ModelInfo(this);
    }
    
    private void run() 
    {
        Timer t = new Timer();
        t.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {
                moveGameObjects();
            }
        }, 0, Config.REFRESH_RATE);
        t.schedule(new TimerTask()
        {
            @Override
            public void run() 
            {
                createEnemy();
            }
        }, 0, Config.ENEMY_SPAWN_TIME);
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

    public void moveCannonUp() 
    {
        this.cannon.moveUp();
        notifyObservers();
    }

    public void moveCannonDown() 
    {
        this.cannon.moveDown();
        notifyObservers();
    }
    
    public void forceUp()
    {
        cannon.forceUp();
        notifyObservers();
    }
    
    public void forceDown()
    {
        cannon.forceDown();
        notifyObservers();
    }
    
    public void angleUp()
    {
        cannon.angleUp();
        notifyObservers();
    }

    public void angleDown()
    {
        cannon.angleDown();
        notifyObservers();
    }
    
    public void attachObserver(Observer o) 
    {
        this.observers.add(o);
        System.out.println(observers);
    }
    
    private void notifyObservers() 
    {
        for(Observer o: observers) 
        {
            o.handleAction();
        }
    }
    public void createMissile() 
    {
        missiles.add(factory.createMissile(cannon.getX(), cannon.getY(), 
                cannon.getForce(), cannon.getAngle()));
    }
    
    /**
     * If new enemy should spawn near other enemy +/- 30px, returns true.
     * @param x
     * @param y
     * @return 
     */
    private boolean spawnTooNearOtherEnemy(int x, int y)
    {
        for(Enemy e: enemies)
        {
            if(Math.abs(e.getX() - x) < 30 && Math.abs(e.getY() - y) < 30)
            return true;
        }
        return false;
    }
    
    public void createEnemy()
    {
        //we don't we to stack in cykle
        if(enemies.size() > 50)
            return;
        
        int x;
        int y;
        do {
            x = ThreadLocalRandom.current().nextInt(Config.CANNON_START_X + 50, 
                    Config.WINDOW_WIDTH - 50 + 1);
            y = ThreadLocalRandom.current().nextInt(50, 
                    Config.WINDOW_HEIGHT - 50 + 1);
        } while(spawnTooNearOtherEnemy(x, y));
        
        enemies.add(factory.createEnemy(x, y));
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
        gameObjects.add(modelInfo);
        return gameObjects;
    }    
       
}
