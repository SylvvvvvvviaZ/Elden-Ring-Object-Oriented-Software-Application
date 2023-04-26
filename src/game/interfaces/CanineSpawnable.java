package game.interfaces;

import edu.monash.fit2099.engine.positions.Location;
import game.MapArea;
import game.ResetManager;
import game.enemies.*;

/**
 * Grounds that spawn Canine-type enemies
 *
 * @author dkon0020
 * @version 1.0
 * @see Enemy
 */
public interface CanineSpawnable extends Spawnable {
    /**
     * On the west, Lone Wolves spawn; on the east, Giant Dogs spawn
     *
     * @param location     the location of the ground
     */
    @Override
    default void spawnFactory(Location location) {
        MapArea spawnArea = getGroundArea(location);
        switch (spawnArea) {
            case WEST -> spawn(location, new LoneWolf(), 33);
            case EAST -> spawn(location, new GiantDog(), 4);
        }
    }
}
