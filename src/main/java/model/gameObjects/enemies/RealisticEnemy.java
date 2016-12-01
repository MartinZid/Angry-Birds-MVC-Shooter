package model.gameObjects.enemies;

import view.GraphicsDrawer;

/**
 *
 * @author Martin
 */
public class RealisticEnemy extends Enemy{

    public RealisticEnemy(int x, int y, int type) 
    {
        super(x, y, type);
    }

    @Override
    public void move(int gravity)
    {
        y += Math.round(0.1 * gravity);
    }

    @Override
    public Enemy copy()
    {
        RealisticEnemy e = new RealisticEnemy(this.x, this.y, this.type);
        return e;
    }

}
