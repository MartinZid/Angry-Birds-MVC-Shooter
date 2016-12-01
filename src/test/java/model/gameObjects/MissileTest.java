package model.gameObjects;

import model.Config;
import model.strategy.SimpleMovementStrategy;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;  


/**
 *
 * @author Martin
 */
public class MissileTest
{
    /**
     * Test of isOnBoard method, of class Missile.
     */
    @Test
    public void testIsOnBoard()
    {
        System.out.println("isOnBoard");
        Missile instance = new Missile(20, 30, 0, 60, mock(SimpleMovementStrategy.class));
        boolean expResult = true;
        boolean result = instance.isOnBoard();
        assertEquals(expResult, result);
        
        instance = new Missile(Config.WINDOW_WIDTH+30, 30, 0, 60, mock(SimpleMovementStrategy.class));
        expResult = false;
        result = instance.isOnBoard();
        assertEquals(expResult, result);
        
        instance = new Missile(40, Config.WINDOW_HEIGHT+1, 0, 60, mock(SimpleMovementStrategy.class));
        expResult = false;
        result = instance.isOnBoard();
        assertEquals(expResult, result);        
    }
}
