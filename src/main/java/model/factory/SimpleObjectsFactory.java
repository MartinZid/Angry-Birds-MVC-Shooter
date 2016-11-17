package model.factory;

import model.gameObjects.enemies.Enemy;
import model.gameObjects.Missile;
import model.gameObjects.enemies.SimpleEnemy;
import model.strategy.SimpleMovementStrategy;

/**
 *
 * @author Martin
 */
public class SimpleObjectsFactory implements ObjectsFactory {

    @Override
    public Enemy createEnemy(int x, int y) 
    {
        // third parametr is 0 or 1 (there are two enemy's images)
        return new SimpleEnemy(x, y, Math.round((float)Math.random()));
    }

    @Override
    public Missile createMissile(int x, int y, int force, int angle) 
    {
        return new Missile(x, y, angle, force, new SimpleMovementStrategy());
    }
    
}
