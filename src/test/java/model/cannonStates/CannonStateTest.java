package model.cannonStates;

import java.util.ArrayList;
import model.factory.ObjectsFactory;
import model.gameObjects.Cannon;
import model.gameObjects.Missile;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Martin
 */
public class CannonStateTest
{
    /**
     * Test of shoot method, of class DoubleShootingMode.
     */
    @Test
    public void testShoot()
    {
        System.out.println("shoot");
        ObjectsFactory factory = mock(ObjectsFactory.class);
        Cannon cannon = mock(Cannon.class);
        
        CannonState instance = new DoubleShootingMode();
        int expectedSize = 2;
        ArrayList<Missile> result = instance.shoot(factory, cannon);
        assertEquals(expectedSize, result.size());
        
        instance = new SingleShootingMode();
        expectedSize = 1;
        result = instance.shoot(factory, cannon);
        assertEquals(expectedSize, result.size());
    }
    
}
