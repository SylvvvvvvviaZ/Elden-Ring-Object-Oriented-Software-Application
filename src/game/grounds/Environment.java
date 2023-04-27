package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.MapArea;
import game.interfaces.EnemyFactory;

/**
 * Base class for environments (grounds that spawn actors)
 */
public abstract class Environment extends Ground {
    /**
     * The enemy factory that spawns the actors
     */
    protected EnemyFactory enemyFactory;

    /**
     * Constructor.
     *
     * @param displayChar  character to display for this type of terrain
     * @param enemyFactory the enemy factory to spawn actors
     */
    public Environment(char displayChar, EnemyFactory enemyFactory) {
        super(displayChar);
        this.enemyFactory = enemyFactory;
    }

    /**
     * Spawn actors at the location
     *
     * @param location the location of the environment
     */
    abstract void spawn(Location location);
}
