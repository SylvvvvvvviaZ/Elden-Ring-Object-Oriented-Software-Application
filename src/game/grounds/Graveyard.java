package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.enemies.Enemy;
import game.enemies.HeavySkeletalSwordsman;
import game.RandomNumberGenerator;
import game.enemies.SkeletalBandit;
import game.interfaces.SkeletalSpawnable;
import game.interfaces.Spawnable;

import java.sql.PreparedStatement;

/**
 * Graveyard ground
 *
 * @author dkon0020
 * @version 0.0
 * @see Ground
 */
public class Graveyard extends Ground implements SkeletalSpawnable {
    /**
     * Constructor
     */
    public Graveyard() {
        super('n');
    }

    /**
     * At every turn, there is a 27% chance of spawning HeavySkeletalSwordsman
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        ResetManager resetManager = ResetManager.getInstance();
        spawnFactory(location, resetManager);
//        if (location.x() < location.map().getXRange().max() / 2) {
//            if (!location.containsAnActor() && RandomNumberGenerator.getRandomInt(0, 100) <= 27) {
//                Enemy heavySkeletalSwordsman = new HeavySkeletalSwordsman();
//                ResetManager.getInstance().registerResettable(heavySkeletalSwordsman);
//                location.addActor(heavySkeletalSwordsman);
//            }
//        } else if (location.x() > location.map().getXRange().max() / 2) {
//            if (!location.containsAnActor() && RandomNumberGenerator.getRandomInt(0, 100) <= 27) {
//                Enemy skeletalBandit = new SkeletalBandit();
//                ResetManager.getInstance().registerResettable(skeletalBandit);
//                location.addActor(skeletalBandit);
//            }
//        }
    }
}
