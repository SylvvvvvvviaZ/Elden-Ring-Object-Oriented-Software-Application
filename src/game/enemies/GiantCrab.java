package game.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.EnemyType;

/**
 * Giant Crab enemy
 *
 * @author dkon0020
 * @version 2.0
 * @see Enemy
 */
public class GiantCrab extends Enemy {
    /**
     * Constructor
     */
    public GiantCrab() {
        super("Giant Crab", 'C', 407, EnemyType.CRUSTACEAN, new IntrinsicWeapon(208, "slams", 90));
    }
}
