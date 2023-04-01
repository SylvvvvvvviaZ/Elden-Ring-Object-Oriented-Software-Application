package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class GustOfWind extends Ground {

    /**
     * Constructor.
     */
    public GustOfWind() {
        super('&');
    }

    /**
     * Lone Wolf can spawn with 33% chance per turn
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 33) {
            location.addActor(new LoneWolf());
        }
    }
}
