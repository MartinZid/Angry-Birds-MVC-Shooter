package model.gameObjects;

import model.Config;
import model.Model;
import view.GraphicsDrawer;

/**
 *
 * @author Martin
 */
public class ModelInfo extends GameObject {

    private final Model model;
    
    public ModelInfo(Model model) 
    {
        super(Config.INFO_X, Config.INFO_Y);
        this.model = model;
    }
    
    @Override
    public String toString()
    {
        String str = "Angle: " + model.getCannon().getAngle()*(-1) + 
                " Force: " + model.getCannon().getForce() + 
                " Gravity: " + model.getGravity() + 
                " Score: " + model.getScore();
        return str;
    }

    @Override
    public void accept(GraphicsDrawer d) 
    {
        d.visit(this);
    }
    
}
