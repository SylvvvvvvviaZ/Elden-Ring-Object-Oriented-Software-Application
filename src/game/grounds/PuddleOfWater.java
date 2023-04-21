package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.GiantCrab;
import game.RandomNumberGenerator;

/**
 * Puddle of Water ground
 * @author dkon0020
 * @version 0.0
 * @see Ground
 */
public class PuddleOfWater extends Ground {
    /**
     * Constructor
     */
    public PuddleOfWater() {
        super('~');
    }

    /**
     * At every turn, there is a 2% chance of spawning a Giant Crab
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        if (RandomNumberGenerator.getRandomInt(0, 100) <= 2) {
            location.addActor(new GiantCrab());
        }
    }
}
