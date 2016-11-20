package model.gameObjects;

import view.GraphicsDrawer;

/**
 *
 * @author Martin
 */
public class Collision extends GameObject {

    private int time;
    
    public Collision(int x, int y) 
    {
        super(x, y);
        time = 0;
    }

    @Override
    public void accept(GraphicsDrawer d) 
    {
        d.visit(this);
    }
    
    public int getTime()
    {
        return time;
    }
    
    public void tickTime()
    {
        time++;
    }
}
