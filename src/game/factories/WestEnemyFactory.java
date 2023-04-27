package game.factories;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantCrayfish;
import game.enemies.HeavySkeletalSwordsman;
import game.enemies.LoneWolf;
import game.interfaces.EnemyFactory;

public class WestEnemyFactory implements EnemyFactory {
    @Override
    public void generateSkeletal(Location location) {
        spawn(location, new HeavySkeletalSwordsman());
    }

    @Override
    public void generateCanine(Location location) {
        spawn(location, new LoneWolf());
    }

    @Override
    public void generateCrustacean(Location location) {
        spawn(location, new GiantCrayfish());
    }
}
