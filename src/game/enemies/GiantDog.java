package game.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.EnemyType;
import game.RandomNumberGenerator;
import game.currency.CurrencyItem;
import game.currency.Rune;

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
        addCapability(EnemyType.CANINE);
    }

    /**
     * Giant Dog rewards 313-1808 Runes upon death
     * @return the Runes to be rewarded upon death
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return new Rune(RandomNumberGenerator.getRandomInt(313, 1808));
    }
}
