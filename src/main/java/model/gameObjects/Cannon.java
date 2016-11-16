package model.gameObjects;

import view.GraphicsDrawer;

public class Cannon extends GameObject {

    private int angle;
    private int force;
    
    public Cannon(int x, int y) {
        super(x, y);
        angle = -20;
        force = 70;        
    }    
    
    @Override
    public void accept(GraphicsDrawer d) 
    {
        d.visit(this);
    }

    public void forceUp()
    {
        if(force+5 <= 100)
            force += 5;
    }
    
    public void forceDown()
    {
        if(force-5 >= 0)
            force -= 5;
    }
    
    public void angleUp()
    {
        if(angle+5 <= 90)
            angle += 5;
    }

    public void angleDown()
    {
        if(angle-5 >= -90)
            angle -= 5;
    }
    
    public int getAngle()
    {
        return angle;
    }

    public int getForce()
    {
        return force;
    }
    
    public void moveUp() {
        this.y -= 5;
    }
    
    public void moveDown() {
        this.y += 5;
    }
}
