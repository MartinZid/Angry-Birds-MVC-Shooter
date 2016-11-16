package model.gameObjects.enemies;

import model.gameObjects.GameObject;
import view.GraphicsDrawer;

/**
 *
 * @author Martin
 */
public abstract class Enemy extends GameObject {
    
    public Enemy(int x, int y) 
    {
        super(x, y);
    }

    @Override
    public abstract void accept(GraphicsDrawer d);
    
    public abstract void move();
}
