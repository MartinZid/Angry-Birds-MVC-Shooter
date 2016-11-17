package model.gameObjects.enemies;

import model.gameObjects.GameObject;
import view.GraphicsDrawer;

/**
 *
 * @author Martin
 */
public abstract class Enemy extends GameObject {
    
    private int type;
    
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
    
    public abstract void move();

    public int getType()
    {
        return type;
    }
}
