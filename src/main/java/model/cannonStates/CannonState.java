package model.cannonStates;

import java.util.ArrayList;
import model.factory.ObjectsFactory;
import model.gameObjects.Cannon;
import model.gameObjects.Missile;

/**
 *
 * @author Martin
 */
public interface CannonState {

    public ArrayList<Missile> shoot(ObjectsFactory factory, Cannon cannon);
    
}
