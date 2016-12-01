package model;

import model.observer.Observer;
import model.gameObjects.enemies.Enemy;
import model.gameObjects.Cannon;
import model.gameObjects.Missile;
import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import model.factory.ObjectsFactory;
import model.factory.RealisticObjectsFactory;
import model.factory.SimpleObjectsFactory;
import model.gameObjects.Collision;
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
    private ArrayList<Collision> collisions;
    private ArrayList<Observer> observers;
    private ObjectsFactory factory;
    private int gravity;
    private int score;
    private ModelInfo modelInfo;
    
    public class Memento
    {
        private final ArrayList<Missile> missiles;
        private Cannon cannon;
        private final ArrayList<Enemy> enemies;
        private final ArrayList<Collision> collisions;  
        private int gravity;
        private int score;
        
        Memento(Model model)
        {
            missiles = new ArrayList<Missile>();
            enemies = new ArrayList<Enemy>();
            collisions = new ArrayList<Collision>();
            setState(model);
        }
        
        private void setState(Model model)
        {
            for(Collision c: model.getCollisions())
            {
                collisions.add(new Collision(c));
            }
            for(Enemy e: model.getEnemies())
            {
                enemies.add(e.copy());
            }
            for(Missile m: model.getMissiles())
            {
                missiles.add(new Missile(m));
            }
            cannon = new Cannon(model.getCannon());
            gravity = model.getGravity();
            score = model.getScore();
        }

        private ArrayList<Missile> getMissiles()
        {
            return missiles;
        }

        private Cannon getCannon()
        {
            return cannon;
        }

        private ArrayList<Enemy> getEnemies()
        {
            return enemies;
        }

        private ArrayList<Collision> getCollisions()
        {
            return collisions;
        }

        private int getGravity()
        {
            return gravity;
        }
        
        private int getScore()
        {
            return score;
        }

    }
    
    public Model(String mode) 
    {
        initAttributes(mode);
        run();
    }
    
    private void initAttributes(String mode) 
    {
        missiles = new ArrayList<Missile>();
        enemies = new ArrayList<Enemy>();
        collisions = new ArrayList<Collision>();
        cannon = new Cannon(Config.CANNON_START_X, Config.CANNON_START_Y);
        observers = new ArrayList<Observer>();
        gravity = mode.equals("SIMPLE") ? 0 : 10;
        score = 0;
        factory = mode.equals("SIMPLE") ? new SimpleObjectsFactory(): 
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
    
    public Memento createMemento()
    {
        System.out.println("Saving...");
        return new Memento(this);
    }
    
    public void setMemento(Memento memento)
    {
        System.out.println("Loading...");
        collisions = new ArrayList<Collision>();
        enemies = new ArrayList<Enemy>();
        missiles = new ArrayList<Missile>();
        
        for(Collision c: memento.getCollisions())
        {
            collisions.add(new Collision(c));
        }
        for(Enemy e: memento.getEnemies())
        {
            enemies.add(e.copy());
        }
        for(Missile m: memento.getMissiles())
        {
            missiles.add(new Missile(m));
        }
        cannon = new Cannon(memento.getCannon());
        gravity = memento.getGravity();
        score = memento.getScore();
    }
    
    private void moveGameObjects() 
    {
        moveMissiles();
        moveEnemies();
        chechCollisions();
        decreaseCollisionsTime();
        notifyObservers();
    }
    
    private void chechCollisions()
    {
        Iterator<Missile> missilesIterator = missiles.iterator();
        while(missilesIterator.hasNext())
        {
            Missile m = missilesIterator.next();
            Iterator<Enemy> enemiesIterator = enemies.iterator();
            while(enemiesIterator.hasNext())
            {
                Enemy e = enemiesIterator.next();
                if(m.collidesWith(e))
                {
                    collisions.add(new Collision(e.getX(), e.getY()));                    
                    enemiesIterator.remove();   
                    missilesIterator.remove();
                    score +=5;
                }
            }
        }
    }
    
    private void decreaseCollisionsTime()
    {
        Iterator<Collision> it = collisions.iterator();
        while(it.hasNext())
        {
            Collision c = it.next();
            c.tickTime();
            if(c.getTime() > Config.COLLISION_LIFE_TIME)
            {
                it.remove();
            }
        }
    }
    
    private void moveMissiles() 
    {
        Iterator<Missile> it = missiles.iterator();
        while(it.hasNext())
        {
            Missile m = it.next();
            m.move(gravity);
            if(!m.isOnBoard())
            {
                it.remove();
            }
        }
    }

    private void moveEnemies()
    {
        Iterator<Enemy> it = enemies.iterator();
        while(it.hasNext())
        {
            Enemy e = it.next();
            e.move(gravity);
            if(!e.isOnBoard())
            {
                it.remove();
            }
        }        
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
    
    public void toogleCannonState()
    {
        cannon.toogleState();
    }    
    
    public void createMissile() 
    {
        missiles.addAll(cannon.shoot(factory));
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
            if(Math.abs(e.getX() - x) < Config.COLLISION_SIZE
                    && Math.abs(e.getY() - y) < Config.COLLISION_SIZE)
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

    public void gravityUp()
    {
        if(gravity < Config.MAX_GRAVITY)
            this.gravity++;
    }
    
    public void gravityDown()
    {
        if(gravity > Config.MIN_GRAVITY)
            this.gravity--;
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
        gameObjects.addAll(collisions);
        gameObjects.add(modelInfo);
        return gameObjects;
    }    

    public ArrayList<Missile> getMissiles()
    {
        return missiles;
    }

    public ArrayList<Enemy> getEnemies()
    {
        return enemies;
    }

    public ArrayList<Collision> getCollisions()
    {
        return collisions;
    }

    public int getGravity()
    {
        return gravity;
    }
    
    public int getScore()
    {
        return score;
    }       
}
