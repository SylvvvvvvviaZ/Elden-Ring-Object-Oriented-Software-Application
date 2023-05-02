package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.EnemyFactory;

/**
 * Puddle of Water ground
 * @author dkon0020
 * @version 0.0
 * @see Ground
 */
public class PuddleOfWater extends Environment {
    /**
     * Constructor
     *
     * @param enemyFactory the enemy factory to spawn actors
     */
    public PuddleOfWater(EnemyFactory enemyFactory) {
        super('~', enemyFactory);
    }

    /**
     * Spawns a Canine-type enemy using the enemy factory in the given location.
     *
     * @param location The location where the enemy is spawned.
     */
    @Override
    void spawn(Location location) {
        enemyFactory.generateCrustacean(location);
    }
}
