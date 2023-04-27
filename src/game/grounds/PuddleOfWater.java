package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.MapArea;
import game.ResetManager;
import game.enemies.Enemy;
import game.enemies.GiantCrab;
import game.RandomNumberGenerator;
import game.enemies.GiantCrayfish;
import game.interfaces.CrustaceanSpawnable;
import game.interfaces.EnemyFactory;

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
     * At every turn, there is a 2% chance of spawning a Giant Crab
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        spawn(location);
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
