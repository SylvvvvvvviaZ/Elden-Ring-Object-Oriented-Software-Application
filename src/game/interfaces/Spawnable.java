package game.interfaces;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.MapArea;
import game.RandomNumberGenerator;
import game.ResetManager;
import game.enemies.Enemy;

/**
 * Interface for grounds that spawn enemies
 *
 * @author dkon0020
 * @version 1.0
 * @see Enemy
 * @see Ground
 */
public interface Spawnable {
    /**
     * Attempt to spawn an enemy at the location if probability permits
     *
     * @param enemy        the enemy to spawn
     * @param location     the location of the ground
     * @param probability  the probability of the enemy spawning
     * @param resetManager the reset manager of the game
     */
    default void spawn(Location location, Enemy enemy, int probability, ResetManager resetManager) {
        if (!location.containsAnActor() && RandomNumberGenerator.getRandomInt(0, 100) <= probability) {
            resetManager.registerResettable(enemy);
            location.addActor(enemy);
        }
    }

    /**
     * Get the area of the map that the location is in
     *
     * @param location the location to check
     * @return the map area
     */
    default MapArea getGroundArea(Location location) {
        if (location.x() < location.map().getXRange().max() / 2) {
            return MapArea.WEST;
        } else if (location.x() > location.map().getXRange().max() / 2) {
            return MapArea.EAST;
        } else {
            return MapArea.MIDDLE;
        }
    }

    /**
     * Spawn enemies based on location
     *
     * @param location     the location of the ground
     * @param resetManager the game's reset manager
     */
    void spawnFactory(Location location, ResetManager resetManager);
}
