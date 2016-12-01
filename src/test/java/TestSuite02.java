import model.ModelTest;
import model.gameObjects.GameObjectTest;
import model.gameObjects.MissileTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   GameObjectTest.class,
   MissileTest.class,
   ModelTest.class
})

public class TestSuite02 {   
} 