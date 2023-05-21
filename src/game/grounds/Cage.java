package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.EnemyFactory;

/**
 * Cage ground
 *
 * @author akya0002
 * @version 1.0
 * @see Ground
 */
public class Cage extends Environment {
    /**
     * Constructor
     *
     * @param enemyFactory the enemy factory to spawn actors
     */
    public Cage(EnemyFactory enemyFactory) {
        super('<', enemyFactory);
    }

    /**
     * Spawns a Dog enemy using the enemy factory in the given location.
     *
     * @param location The location where the enemy is spawned.
     */
    @Override
    void spawn(Location location) {
        enemyFactory.generateDog(location);
    }
}
