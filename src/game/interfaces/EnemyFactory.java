package game.interfaces;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.MapArea;
import game.RandomNumberGenerator;
import game.ResetManager;
import game.enemies.Enemy;

/**
 * Interface for generating enemies on different maps
 */
public interface EnemyFactory {
    /**
     * Attempt to spawn an enemy at the location if probability permits
     *
     * @param enemy        the enemy to spawn
     * @param location     the location of the ground
     */
    default void spawn(Location location, Enemy enemy) {
        if (!location.containsAnActor() && RandomNumberGenerator.getRandomInt(0, 100) <= enemy.getSpawnChance()) {
            ResetManager.getInstance().registerResettable(enemy);
            location.addActor(enemy);
        }
    }
    /**
     * Generate Skeletal-type enemies
     *
     * @param gameMap the game map to generate the enemies
     */
    void generateSkeletal(Location location);

    /**
     * Generate Canine-type enemies
     *
     * @param gameMap the game map to generate the enemies
     */
    void generateCanine(Location location);

    /**
     * Generate Crustacean-type enemies
     *
     * @param gameMap the game map to generate the enemies
     */
    void generateCrustacean(Location location);
}
