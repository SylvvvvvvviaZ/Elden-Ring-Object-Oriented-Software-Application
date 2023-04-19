package game.enemies;

import game.EnemyType;
import game.weapons.Scimitar;

/**
 * Skeletal Bandit enemy
 * @author dkon0020
 * @version 2.0
 * @see Enemy
 */
public class SkeletalBandit extends Enemy {
    /**
     * Constructor
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184, EnemyType.SKELETAL, new Scimitar());
    }
}
