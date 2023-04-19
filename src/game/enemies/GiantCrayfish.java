package game.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.EnemyType;
import game.RandomNumberGenerator;
import game.currency.CurrencyItem;
import game.currency.Rune;

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

    /**
     * Giant Crayfish rewards 500-2374 Runes upon death
     * @return the Runes to be rewarded upon death
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return new Rune(RandomNumberGenerator.getRandomInt(500, 2374));
    }
}
