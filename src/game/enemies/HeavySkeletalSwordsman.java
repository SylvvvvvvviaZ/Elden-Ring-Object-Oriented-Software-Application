package game.enemies;

import game.EnemyType;
import game.weapons.Grossmesser;

/**
 * Heavy Skeletal Swordsman enemy
 * @author dkon0020
 * @version 2.0
 * @see Enemy
 */
public class HeavySkeletalSwordsman extends Enemy {
    /**
     * Constructor
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153, EnemyType.SKELETAL, new Grossmesser());
    }
}
