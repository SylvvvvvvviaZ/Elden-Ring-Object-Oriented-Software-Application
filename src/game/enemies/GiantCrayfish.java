package game.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.RandomNumberGenerator;
import game.attackactions.SpecialAttackType;
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
        addCapability(EnemyType.CRUSTACEAN);
        addCapability(SpecialAttackType.SLAM);
    }

    /**
     * Giant Crayfish has a 1% chance of spawning on the east side of the map
     *
     * @return 1%
     */
    @Override
    public int getSpawnChance() {
        return 1;
    }

    /**
     * Giant Crayfish rewards 500-2374 Runes upon death
     *
     * @return the Runes to be rewarded upon death
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return new Rune(RandomNumberGenerator.getRandomInt(500, 2374));
    }
}
