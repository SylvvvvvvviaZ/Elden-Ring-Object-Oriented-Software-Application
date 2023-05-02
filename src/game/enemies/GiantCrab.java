package game.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.RandomNumberGenerator;
import game.attackactions.SpecialAttackType;
import game.currency.CurrencyItem;
import game.currency.Rune;

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
        addCapability(EnemyType.CRUSTACEAN);
        addCapability(SpecialAttackType.SLAM);
    }

    @Override
    public int getSpawnChance() {
        return 2;
    }

    /**
     * Giant Crab rewards 318-4961 Runes upon death
     * @return the Runes to be rewarded upon death
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return new Rune(RandomNumberGenerator.getRandomInt(318, 4961));
    }
}
