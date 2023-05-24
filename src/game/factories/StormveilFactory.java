package game.factories;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.*;

/**
 * Enemy factory for the Stormveil Castle
 */
public class StormveilFactory implements EnemyFactory{

/**
 * Spawns Skeletal type enemy
 *
 * @param location the location to spawn the enemy
 */
    public void generateSkeletal(Location location) {
    }

    /**
     * Spawns Canine type enemy
     *
     * @param location the location to spawn the enemy
     */
    @Override
    public void generateCanine(Location location) {
    }

    /**
     * Spawns Crustacean type enemy
     *
     * @param location the location to spawn the enemy
     */
    @Override
    public void generateCrustacean(Location location) {
    }

    /**
     * Spawns Dog
     *
     * @param location the location to spawn the enemy
     */
    public void generateDog(Location location) {spawn(location, new Dog());}

    /**
     * Spawns GodrickSoldier
     *
     * @param location the location to spawn the enemy
     */
    public void generateSoldier(Location location) {spawn(location, new GodrickSoldier());}
}
