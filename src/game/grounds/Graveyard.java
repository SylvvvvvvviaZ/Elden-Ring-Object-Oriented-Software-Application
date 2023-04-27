package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.MapArea;
import game.ResetManager;
import game.enemies.Enemy;
import game.enemies.HeavySkeletalSwordsman;
import game.RandomNumberGenerator;
import game.enemies.SkeletalBandit;
import game.interfaces.EnemyFactory;
import game.interfaces.SkeletalSpawnable;
import game.interfaces.Spawnable;

import java.sql.PreparedStatement;

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
     */
    public Graveyard(EnemyFactory enemyFactory) {
        super('n', enemyFactory);
    }

    /**
     * At every turn, there is a 27% chance of spawning HeavySkeletalSwordsman
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        spawn(location);
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
