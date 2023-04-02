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
        if (location.x() < location.map().getXRange().max() / 2) {
            // West side spawns HSSs
            if (RandomNumberGenerator.getRandomInt(100) <= 27) {
                location.addActor(new HeavySkeletalSwordsman());
            }
        } else {
            // East side spawns Skeletal Bandits
            if (RandomNumberGenerator.getRandomInt(100) <= 10) {
                location.addActor(new SkeletalBandit());
            }
        }
    }
}
