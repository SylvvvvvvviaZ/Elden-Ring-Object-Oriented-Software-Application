package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.EnemyFactory;

/**
 * Graveyard ground
 *
 * @author dkon0020
 * @version 0.0
 * @see Ground
 */
public class Graveyard extends Environment {
    /**
     * Constructor
     *
     * @param enemyFactory the enemy factory to spawn actors
     */
    public Graveyard(EnemyFactory enemyFactory) {
        super('n', enemyFactory);
    }

    /**
     * Spawns a Skeletal-type enemy using the enemy factory in the given location.
     *
     * @param location The location where the enemy is spawned.
     */
    @Override
    void spawn(Location location) {
        enemyFactory.generateSkeletal(location);
    }
}
