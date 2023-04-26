package game.interfaces;

import edu.monash.fit2099.engine.positions.Location;
import game.MapArea;
import game.ResetManager;
import game.enemies.Enemy;
import game.enemies.HeavySkeletalSwordsman;
import game.enemies.SkeletalBandit;

/**
 * Grounds that spawn Skeletal-type enemies
 *
 * @author dkon0020
 * @version 1.0
 * @see Enemy
 */
public interface SkeletalSpawnable extends Spawnable {
    /**
     * On the west, Heavy Skeletal Swordsmen spawn; on the east, Skeletal Bandits spawn
     *
     * @param location     the location of the ground
     */
    @Override
    default void spawnFactory(Location location) {
        MapArea spawnArea = getGroundArea(location);
        switch (spawnArea) {
            case WEST -> spawn(location, new HeavySkeletalSwordsman(), 27);
            case EAST -> spawn(location, new SkeletalBandit(), 27);
        }
    }
}
