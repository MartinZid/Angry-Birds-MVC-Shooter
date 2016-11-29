package model.gameObjects.enemies;

import model.Config;
import model.gameObjects.GameObject;
import view.GraphicsDrawer;

/**
 *
 * @author Martin
 */
public abstract class Enemy extends GameObject {
    
    protected int type;
    
    public Enemy(int x, int y, int type) 
    {
        super(x, y);
        this.type = type;
    }
    
    @Override
    public void accept(GraphicsDrawer d)
    {
        d.visit(this);
    }
    
    public abstract void move(int gravity);

    public int getType()
    {
        return type;
    }
    
    public boolean isOnBoard()
    {
        return x <= Config.WINDOW_WIDTH && y <= Config.WINDOW_HEIGHT;
    }
    
    public abstract Enemy copy();
}
