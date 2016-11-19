package model.cannonStates;

import java.util.ArrayList;
import model.Config;
import model.factory.ObjectsFactory;
import model.gameObjects.Cannon;
import model.gameObjects.Missile;

/**
 *
 * @author Martin
 */
public class DoubleShootingMode implements CannonState{

    @Override
    public ArrayList<Missile> shoot(ObjectsFactory factory, Cannon cannon)
    {
        ArrayList<Missile> missiles = new ArrayList<Missile>();
        missiles.add(factory.createMissile(cannon.getX(), cannon.getY(), cannon.getForce(), 
                cannon.getAngle() + Config.DOUBLE_SHOOTING_MISSILES_ANGLE_DIFFERENCE));
        missiles.add(factory.createMissile(cannon.getX(), cannon.getY(), cannon.getForce(), 
                cannon.getAngle() - Config.DOUBLE_SHOOTING_MISSILES_ANGLE_DIFFERENCE));
        return missiles;
    }

}
