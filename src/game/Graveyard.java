package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Graveyard extends Ground {
    /**
     * Constructor.
     */
    public Graveyard() {
        super('n');
    }

    /**
     * Heavy Skeletal Swordsman can spawn with 27% chance per turn
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) <= 27) {
            location.addActor(new HeavySkeletalSwordsman());
        }
    }
}
