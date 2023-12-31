package game.factories;

import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.reset.ResetManager;
import game.enemies.Enemy;

/**
 * Interface for factories that generate enemies on maps
 */
public interface EnemyFactory {
    /**
     * Attempt to spawn an enemy at the location if probability permits
     *
     * @param enemy    the enemy to spawn
     * @param location the location of the ground
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
     * @param location the location to spawn the enemy
     */
    void generateSkeletal(Location location);

    /**
     * Generate Canine-type enemies
     *
     * @param location the location to spawn the enemy
     */
    void generateCanine(Location location);

    /**
     * Generate Crustacean-type enemies
     *
     * @param location the location to spawn the enemy
     */
    void generateCrustacean(Location location);

    /**
     * Generate Dog
     *
     * @param location the location to spawn the enemy
     */
    void generateDog(Location location);

    /**
     * Generate GodrickSoldier
     *
     * @param location the location to spawn the enemy
     */
    void generateSoldier(Location location);
}
