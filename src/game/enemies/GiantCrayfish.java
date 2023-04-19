package game.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.EnemyType;

/**
 * Giant Crayfish enemy
 *
 * @author dkon0020
 * @version 2.0
 * @see Enemy
 */
public class GiantCrayfish extends Enemy {
    /**
     * Constructor
     */
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803, EnemyType.CRUSTACEAN, new IntrinsicWeapon(527, "slams", 100));
    }
}
