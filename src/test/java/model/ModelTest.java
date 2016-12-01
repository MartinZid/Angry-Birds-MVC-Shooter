package model;

import model.Model.Memento;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Martin
 */
public class ModelTest 
{
    @Test
    public void createMementoTest()
    {
        System.out.println("createMemento");
        Model model = new Model("REAL");
        Memento memento = model.createMemento();

        model.gravityDown(); // gravity is now 9
        model.setMemento(memento);
        int expectedResult = 10;
        int realResult = model.getGravity();
        assertEquals(expectedResult, realResult);
    }
}
