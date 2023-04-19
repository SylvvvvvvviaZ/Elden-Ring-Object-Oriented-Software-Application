package game.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.EnemyType;

/**
 * Lone Wolf enemy
 *
 * @author Adrian Kristanto, dkon0020
 * @version 2.0
 * @see Enemy
 */
public class LoneWolf extends Enemy {
    /**
     * Constructor
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102, EnemyType.CANINE, new IntrinsicWeapon(97, "bites", 95));
    }
}
