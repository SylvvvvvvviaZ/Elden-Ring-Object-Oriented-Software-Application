package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class PuddleOfWater extends Ground {
    /**
     * Constructor.
     */
    public PuddleOfWater() {
        super('~');
    }

    /**
     * Giant Crabs can spawn with 2% chance per turn
     * 
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 2) {
            location.addActor(new GiantCrab());
        }
    }
}
