/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter;
import cz.fit.dpo.mvcshooter.view.GraphicsDrawer;

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
    
    /**
     * @return the x
     */
    public int getX()
    {
        return x;
    }

    /**
     * @return the y
     */
    public int getY()
    {
        return y;
    }
    
    public abstract void accept(GraphicsDrawer d);
    
    
}
