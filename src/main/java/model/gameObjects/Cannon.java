package model.gameObjects;

import view.GraphicsDrawer;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Cannon extends GameObject{

    public Cannon(int x, int y) {
        super(x, y);
    }    

    @Override
    public void accept(GraphicsDrawer d) 
    {
        d.visit(this);
    }
    
    public void moveUp() {
        this.y -= 5;
    }
    
    public void moveDown() {
        this.y += 5;
    }
}
