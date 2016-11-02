package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.view.GraphicsDrawer;

/**
 *
 * @author Martin
 */
public class Collision extends GameObject{

    public Collision(int x, int y) {
        super(x, y);
    }

    @Override
    public void accept(GraphicsDrawer d) {
        d.visit(this);
    }
    
}
