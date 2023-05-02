package game.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.RandomNumberGenerator;
import game.attackactions.SpecialAttackType;
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
        addCapability(SpecialAttackType.SLAM);
    }

    /**
     * Giant Dog has a 4% chance of spawning on the east side of the map
     *
     * @return 4%
     */
    @Override
    public int getSpawnChance() {
        return 4;
    }

    /**
     * Giant Dog rewards 313-1808 Runes upon death
     *
     * @return the Runes to be rewarded upon death
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return new Rune(RandomNumberGenerator.getRandomInt(313, 1808));
    }
}
