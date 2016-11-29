package model.gameObjects.enemies;

import view.GraphicsDrawer;

/**
 *
 * @author Martin
 */
public class SimpleEnemy extends Enemy {

    public SimpleEnemy(int x, int y, int type) {
        super(x, y, type);
    }

    @Override
    public void move(int gravity) {}

    @Override
    public Enemy copy()
    {
        SimpleEnemy e = new SimpleEnemy(this.x, this.y, this.type);
        return e;
    }

}
