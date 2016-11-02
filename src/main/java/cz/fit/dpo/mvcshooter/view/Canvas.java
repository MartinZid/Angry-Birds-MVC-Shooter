package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.Cannon;
import cz.fit.dpo.mvcshooter.Model;
import cz.fit.dpo.mvcshooter.Observer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel implements Observer { 
    GraphicsDrawer drawer = new GraphicsDrawer();
    private Model model;

    public Canvas(int x, int y, int width, int height, Model model) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);   
        this.model = model;
        makeMeObserver();
    }
    
    private void makeMeObserver() {
        model.attachObserver(this);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);    
        drawer.setGraphics(g);
        model.getCannon().accept(drawer);
    }

    @Override
    public void handleAction() {
        repaint();
    }
    
}
