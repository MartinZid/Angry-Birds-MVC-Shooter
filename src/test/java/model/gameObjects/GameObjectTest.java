package model.gameObjects;

import model.Config;
import model.gameObjects.enemies.SimpleEnemy;
import model.strategy.SimpleMovementStrategy;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Martin
 */
public class GameObjectTest
{
    
    /**
     * Test of collidesWith method, of class GameObject.
     */
    @Test
    public void testCollidesWith()
    {
        System.out.println("collidesWith");
        GameObject o1 = new Missile(40, 50, 0, 0, mock(SimpleMovementStrategy.class));
        GameObject o2 = new SimpleEnemy(0, 0, 0);
        boolean expResult = false;
        boolean result = o2.collidesWith(o1);
        assertEquals(expResult, result);
        
        o1 = new Missile(0, 0, 0, 0, mock(SimpleMovementStrategy.class));
        o2 = new SimpleEnemy(0 + Config.COLLISION_SIZE, 0, 0);
        expResult = true;
        result = o2.collidesWith(o1);
        assertEquals(expResult, result);
        
        o1 = new Missile(0 + Config.COLLISION_SIZE, 200 - Config.COLLISION_SIZE, 0, 0, mock(SimpleMovementStrategy.class));
        o2 = new SimpleEnemy(0, 200, 0);
        expResult = true;
        result = o2.collidesWith(o1);
        assertEquals(expResult, result);        
    }
}
