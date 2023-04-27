package game.factories;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantCrayfish;
import game.enemies.GiantDog;
import game.enemies.SkeletalBandit;
import game.interfaces.EnemyFactory;

public class EastEnemyFactory implements EnemyFactory {

    @Override
    public void generateSkeletal(Location location) {
        spawn(location, new SkeletalBandit());
    }

    @Override
    public void generateCanine(Location location) {
        spawn(location, new GiantDog());
    }

    @Override
    public void generateCrustacean(Location location) {
        spawn(location, new GiantCrayfish());
    }
}
