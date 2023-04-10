package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Graveyard ground
 * @author dkon0020
 * @version 0.0
 * @see Ground
 */
public class Graveyard extends Ground {
    /**
     * Constructor
     */
    public Graveyard() {
        super('n');
    }

    /**
     * At every turn, there is a 27% chance of spawning HeavySkeletalSwordsman
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        if (RandomNumberGenerator.getRandomInt(0, 100) <= 27) {
            location.addActor(new HeavySkeletalSwordsman());
        }
    }
}
