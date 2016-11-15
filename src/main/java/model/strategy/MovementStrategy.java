package model.strategy;

import model.gameObjects.Missile;

/**
 *
 * @author Martin
 */
public interface MovementStrategy {
    public void move(int gravity, Missile m);
}
