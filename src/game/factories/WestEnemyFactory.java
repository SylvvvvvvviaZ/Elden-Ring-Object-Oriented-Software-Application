package game.factories;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantCrab;
import game.enemies.GiantCrayfish;
import game.enemies.HeavySkeletalSwordsman;
import game.enemies.LoneWolf;
import game.interfaces.EnemyFactory;

/**
 * A concrete implementation of EnemyFactory that creates enemies that can only be generated in the west map area.
 * The enemies created by this factory are HeavySkeletalSwordsman, LoneWolf and GiantCrayfish.
 */
public class WestEnemyFactory implements EnemyFactory {
    /**
     * Heavy Skeletal Swordsmen spawn on the west side
     *
     * @param location the location to spawn the enemy
     */
    @Override
    public void generateSkeletal(Location location) {
        spawn(location, new HeavySkeletalSwordsman());
    }

    /**
     * Lone Wolves spawn on the west side
     *
     * @param location the location to spawn the enemy
     */
    @Override
    public void generateCanine(Location location) {
        spawn(location, new LoneWolf());
    }

    /**
     * Giant Crayfish spawn on the west side
     *
     * @param location the location to spawn the enemy
     */
    @Override
    public void generateCrustacean(Location location) {
        spawn(location, new GiantCrab());
    }
}
