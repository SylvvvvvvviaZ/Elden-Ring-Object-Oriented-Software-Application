package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.enemies.Enemy;
import game.enemies.GiantCrab;
import game.RandomNumberGenerator;
import game.enemies.GiantCrayfish;

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
        if (location.x() < location.map().getXRange().max() / 2) {
            if (!location.containsAnActor() && RandomNumberGenerator.getRandomInt(0, 100) <= 2) {
                Enemy giantCrab = new GiantCrab();
                ResetManager.getInstance().registerResettable(giantCrab);
                location.addActor(giantCrab);
            }
        } else if (location.x() > location.map().getXRange().max() / 2) {
            if (!location.containsAnActor() && RandomNumberGenerator.getRandomInt(0, 100) <= 2) {
                Enemy giantCrayfish = new GiantCrayfish();
                ResetManager.getInstance().registerResettable(giantCrayfish);
                location.addActor(giantCrayfish);
            }
        }
    }
}
