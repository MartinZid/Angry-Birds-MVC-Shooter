package model.gameObjects;
import model.Config;
import view.GraphicsDrawer;

/**
 *
 * @author Martin
 */
public abstract class GameObject {
    
    protected int x;
    protected int y;

    public GameObject(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }
    
    public boolean collidesWith(GameObject o)
    {
        return Math.abs(this.x - o.getX()) <= Config.COLLISION_SIZE &&
                Math.abs(this.y - o.getY()) <= Config.COLLISION_SIZE;
    }
    
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y) 
    {
        this.y = y;
    }
    
    public abstract void accept(GraphicsDrawer d);
    
    
}
