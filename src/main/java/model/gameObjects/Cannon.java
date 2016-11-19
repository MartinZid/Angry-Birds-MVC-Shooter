package model.gameObjects;

import java.util.ArrayList;
import model.Config;
import model.cannonStates.CannonState;
import model.cannonStates.DoubleShootingMode;
import model.cannonStates.SingleShootingMode;
import model.enums.CannonModes;
import model.factory.ObjectsFactory;
import view.GraphicsDrawer;

public class Cannon extends GameObject {

    private int angle;
    private int force;
    private CannonState state;
    private CannonModes mode;
    
    public Cannon(int x, int y) {
        super(x, y);
        angle = Config.CANNON_START_ANGLE;
        force = Config.CANNON_START_FORCE;   
        state = new SingleShootingMode();
        mode = CannonModes.SINGLE_SHOOTING;
    }    
    
    public ArrayList<Missile> shoot(ObjectsFactory factory)
    {
        return state.shoot(factory, this);
    }
    
    public void toogleState()
    {
        if(mode == CannonModes.SINGLE_SHOOTING)
        {
            System.out.println("Double shooting");
            mode = CannonModes.DOUBLE_SHOOTING;
            state = new DoubleShootingMode();
        } else if(mode == CannonModes.DOUBLE_SHOOTING)
        {
            System.out.println("Single shooting");
            mode = CannonModes.SINGLE_SHOOTING;
            state = new SingleShootingMode();
        }
    }
    
    @Override
    public void accept(GraphicsDrawer d) 
    {
        d.visit(this);
    }

    public void forceUp()
    {
        if(force+5 <= Config.CANNON_MAX_FORCE)
            force += 5;
    }
    
    public void forceDown()
    {
        if(force-5 >= 0)
            force -= 5;
    }
    
    public void angleUp()
    {
        if(angle+5 <= Config.CANNON_MAX_ANGLE)
            angle += 5;
    }

    public void angleDown()
    {
        if(angle-5 >= -Config.CANNON_MAX_ANGLE)
            angle -= 5;
    }
    
    public int getAngle()
    {
        return angle;
    }

    public int getForce()
    {
        return force;
    }
    
    public void moveUp() 
    {    
        if(y-5 >= Config.INFO_Y + 35)
            y -= 5;
    }
    
    public void moveDown() {
        if(y+5 <= Config.WINDOW_HEIGHT - 35)
            y += 5;
    }
}
