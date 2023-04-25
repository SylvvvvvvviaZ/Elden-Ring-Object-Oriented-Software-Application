package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.ResetManager;
import game.enemies.Enemy;
import game.enemies.GiantDog;
import game.enemies.LoneWolf;

/**
 * Gust of Wind ground
 * @author dkon0020
 * @version 0.0
 * @see Ground
 */
public class GustOfWind extends Ground {
    /**
     * Constructor
     */
    public GustOfWind() {
        super('&');
    }

    /**
     * At every turn, there is a 33% chance of spawning a Lone Wolf
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        if (location.x() < location.map().getXRange().max() / 2) {
            if (!location.containsAnActor() && RandomNumberGenerator.getRandomInt(0, 100) <= 33) {
                Enemy loneWolf = new LoneWolf();
                ResetManager.getInstance().registerResettable(loneWolf);
                location.addActor(loneWolf);
            }
        } else if (location.x() > location.map().getXRange().max() / 2) {
            if (!location.containsAnActor() && RandomNumberGenerator.getRandomInt(0, 100) <= 4) {
                Enemy giantDog = new GiantDog();
                ResetManager.getInstance().registerResettable(giantDog);
                location.addActor(giantDog);
            }
        }
    }
}
