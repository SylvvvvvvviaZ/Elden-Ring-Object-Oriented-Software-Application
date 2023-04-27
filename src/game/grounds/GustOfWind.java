package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.MapArea;
import game.RandomNumberGenerator;
import game.ResetManager;
import game.enemies.Enemy;
import game.enemies.GiantDog;
import game.enemies.LoneWolf;
import game.interfaces.CanineSpawnable;
import game.interfaces.EnemyFactory;

/**
 * Gust of Wind ground
 * @author dkon0020
 * @version 0.0
 * @see Ground
 */
public class GustOfWind extends Environment {
    /**
     * Constructor
     *
     * @param enemyFactory the enemy factory to spawn actors
     */
    public GustOfWind(EnemyFactory enemyFactory) {
        super('&', enemyFactory);
    }

    /**
     * At every turn, there is a 33% chance of spawning a Lone Wolf
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
        enemyFactory.generateCanine(location);
    }
}
