package model.factory;

import model.gameObjects.enemies.Enemy;
import model.gameObjects.Missile;
import model.gameObjects.enemies.RealisticEnemy;
import model.strategy.RealisticMovementStrategy;

/**
 *
 * @author Martin
 */
public class RealisticObjectsFactory implements ObjectsFactory {

    @Override
    public Enemy createEnemy(int x, int y) 
    {
        // third parametr is 0 or 1 (there are two enemy's images)
        return new RealisticEnemy(x, y, Math.round((float)Math.random()));
    }

    @Override
    public Missile createMissile(int x, int y, int force, int angle) 
    {
        return new Missile(x, y, angle, force, new RealisticMovementStrategy());
    }

}
