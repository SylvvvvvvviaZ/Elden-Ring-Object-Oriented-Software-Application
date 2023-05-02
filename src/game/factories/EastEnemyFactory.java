package game.factories;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantCrayfish;
import game.enemies.GiantDog;
import game.enemies.SkeletalBandit;

/**
 * Enemy factory for the east side of the map
 */
public class EastEnemyFactory implements EnemyFactory {

    /**
     * Skeletal Bandits spawn on the east side
     *
     * @param location the location to spawn the enemy
     */
    @Override
    public void generateSkeletal(Location location) {
        spawn(location, new SkeletalBandit());
    }

    /**
     * Giant Dogs spawn on the east side
     *
     * @param location the location to spawn the enemy
     */
    @Override
    public void generateCanine(Location location) {
        spawn(location, new GiantDog());
    }

    /**
     * Giant Crayfish spawn on the east side
     *
     * @param location the location to spawn the enemy
     */
    @Override
    public void generateCrustacean(Location location) {
        spawn(location, new GiantCrayfish());
    }
}
