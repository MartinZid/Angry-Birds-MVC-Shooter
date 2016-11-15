package model.factory;

import model.gameObjects.enemies.Enemy;
import model.gameObjects.Missile;

/**
 *
 * @author Martin
 */
public interface ObjectsFactory {
    public Enemy createEnemy(int x, int y);
    public Missile createMissile(int x, int y, int force, int angle);
}
