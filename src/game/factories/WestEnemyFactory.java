package game.factories;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.interfaces.EnemyFactory;

public class WestEnemyFactory implements EnemyFactory {
    private Location groundLocation;

    public WestEnemyFactory(Location groundLocation) {
        this.groundLocation = groundLocation;
    }

    @Override
    public void generateSkeletal(GameMap gameMap) {
//        gameMap.addActor(new );
    }

    @Override
    public void generateCanine(GameMap gameMap) {

    }

    @Override
    public void generateCrustacean(GameMap gameMap) {

    }
}
