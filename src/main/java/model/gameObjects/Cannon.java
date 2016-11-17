package model.gameObjects;

import model.Config;
import view.GraphicsDrawer;

public class Cannon extends GameObject {

    private int angle;
    private int force;
    
    public Cannon(int x, int y) {
        super(x, y);
        angle = Config.CANNON_START_ANGLE;
        force = Config.CANNON_START_FORCE;        
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
