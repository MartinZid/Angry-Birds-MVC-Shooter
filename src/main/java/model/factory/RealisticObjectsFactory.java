package model.factory;

import model.gameObjects.enemies.Enemy;
import model.gameObjects.Missile;

/**
 *
 * @author Martin
 */
public class RealisticObjectsFactory implements ObjectsFactory {

    @Override
    public Enemy createEnemy(int x, int y) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Missile createMissile(int x, int y, int force, int angle) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
