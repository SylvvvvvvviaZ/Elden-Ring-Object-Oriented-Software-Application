package game.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.EnemyType;

/**
 * Giant Dog enemy
 *
 * @author dkon0020
 * @version 2.0
 * @see Enemy
 */
public class GiantDog extends Enemy {
    /**
     * Constructor
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693, EnemyType.CANINE, new IntrinsicWeapon(314, "slams", 90));
    }
}
