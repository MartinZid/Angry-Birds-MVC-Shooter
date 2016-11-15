package model.factory;

import model.gameObjects.enemies.Enemy;
import model.gameObjects.Missile;
import model.strategy.SimpleMovementStrategy;

/**
 *
 * @author Martin
 */
public class SimpleObjectsFactory implements ObjectsFactory{

    @Override
    public Enemy createEnemy(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Missile createMissile(int x, int y, int force, int angle) {
        return new Missile(x, y, angle, force, new SimpleMovementStrategy());
    }
    
}
