package game.interfaces;

import edu.monash.fit2099.engine.positions.Location;
import game.MapArea;
import game.ResetManager;
import game.enemies.*;

/**
 * Grounds that spawn Crustacean-type enemies
 *
 * @author dkon0020
 * @version 1.0
 * @see Enemy
 */
public interface CrustaceanSpawnable extends Spawnable {

    /**
     * On the west, Giant Crabs spawn; on the east, Giant Crayfish spawn
     *
     * @param location     the location of the ground
     */
    @Override
    default void spawnFactory(Location location) {
        MapArea spawnArea = getGroundArea(location);
        switch (spawnArea) {
            case WEST -> spawn(location, new GiantCrab(), 2);
            case EAST -> spawn(location, new GiantCrayfish(), 2);
        }
    }
}
