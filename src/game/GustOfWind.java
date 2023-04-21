package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
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
        if (RandomNumberGenerator.getRandomInt(0, 100) <= 33) {
            location.addActor(new LoneWolf());
        }
    }
}
