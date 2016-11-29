package model.gameObjects;

import model.Config;
import model.gameObjects.GameObject;
import model.strategy.MovementStrategy;
import view.GraphicsDrawer;

/**
 *
 * @author Martin
 */
public class Missile extends GameObject {
    
    private final int angle;
    private final int force;
    private int time;
    private final int startX;
    private final int startY;
    private final MovementStrategy strategy;
            
    public Missile(int x, int y, int angle, int force, MovementStrategy strategy)
    {
        super(x, y);
        this.angle = angle;
        this.force = force;
        this.strategy = strategy;
        this.time = 1;
        this.startX = x;
        this.startY = y;
    }
    
    public Missile(Missile m)
    {
        super(m.x, m.y);
        this.angle = m.angle;
        this.force = m.force;
        this.startX = m.startX;
        this.startY = m.startY;
        this.strategy = m.strategy;
        this.time = m.time;
        this.x = m.x;
        this.y = m.y;
    }

    public void move(int gravity)
    {
        time++;
        strategy.move(gravity, this);
    }
    
    public boolean isOnBoard()
    {
        return x <= Config.WINDOW_WIDTH && y <= Config.WINDOW_HEIGHT;
    }
    
    @Override
    public void accept(GraphicsDrawer d) 
    {
       d.visit(this);
    }

    public int getAngle() 
    {
        return angle;
    }

    public int getForce() 
    {
        return force;
    }   
    
    public int getTime() 
    {
        return time;
    }
     public int getStartX() 
     {
         return startX;
     }
     public int getStartY() 
     {
         return startY;
     }

}
