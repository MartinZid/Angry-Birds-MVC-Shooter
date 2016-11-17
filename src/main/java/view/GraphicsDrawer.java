package view;

import model.gameObjects.ModelInfo;
import model.gameObjects.Collision;
import model.gameObjects.enemies.Enemy;
import model.gameObjects.Missile;
import model.gameObjects.Cannon;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class GraphicsDrawer {
    private static final int INFO_X = 5;
    private static final int INFO_Y = 15;
    
    private BufferedImage cannonImage;
    private BufferedImage enemyImage1;
    private BufferedImage enemyImage2;
    private BufferedImage missileImage;
    private BufferedImage collisionImage;
    private Graphics g;
 

    public GraphicsDrawer() 
    {
        try {
            cannonImage = ImageIO.read(getClass().getResourceAsStream("/images/cannon.png"));
            enemyImage1 = ImageIO.read(getClass().getResourceAsStream("/images/enemy1.png"));
            enemyImage2 = ImageIO.read(getClass().getResourceAsStream("/images/enemy2.png"));
            missileImage = ImageIO.read(getClass().getResourceAsStream("/images/missile.png"));
            collisionImage = ImageIO.read(getClass().getResourceAsStream("/images/collision.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
    
    public void setGraphics(Graphics g) 
    {
        this.g = g;
    }
        
    
    public void visit(Cannon cannon) 
    {
        g.drawImage(cannonImage, 
              cannon.getX() - cannonImage.getWidth()/2, 
              cannon.getY() - cannonImage.getHeight()/2, null);
    }
    
    
    public void visit(Missile missile) 
    {
        g.drawImage(missileImage, 
                missile.getX() - missileImage.getWidth()/2,
                missile.getY() - missileImage.getWidth()/2, null);
    }
    
    public void visit(Enemy enemy) 
    {
        BufferedImage enemyImage = enemy.getType() == 1 ? 
                enemyImage1:
                enemyImage2;
        g.drawImage(enemyImage, 
                enemy.getX(),
                enemy.getY(), null);
    }
    
    public void visit(Collision collision) 
    {        
        g.drawImage(collisionImage,
                collision.getX(),
                collision.getY(), null);
    }
    
    public void visit(ModelInfo info) 
    {
        g.drawString(info.toString(), info.getX(), info.getY());
    }
    
}
