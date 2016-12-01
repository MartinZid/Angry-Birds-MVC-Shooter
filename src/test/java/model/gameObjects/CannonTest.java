package model.gameObjects;

import model.factory.SimpleObjectsFactory;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Martin
 */
public class CannonTest
{
    /**
     * Test of toogleState method, of class Cannon.
     */
    @Test
    public void testToogleState()
    {
        System.out.println("toogleState");
        int expected;
        Cannon instance = new Cannon(0, 0);
        
        int singleShooting = instance.shoot(mock(SimpleObjectsFactory.class)).size();
        expected = 1;
        assertEquals(expected, singleShooting);
       
        instance.toogleState();
        
        int doubleShooting = instance.shoot(mock(SimpleObjectsFactory.class)).size();
        expected = 2;
        assertEquals(expected, doubleShooting);
    }    
}
