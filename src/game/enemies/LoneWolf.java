package game.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.RandomNumberGenerator;
import game.currency.CurrencyItem;
import game.currency.Rune;

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
        addCapability(EnemyType.CANINE);
    }

    @Override
    public int getSpawnChance() {
        return 33;
    }

    /**
     * Lone Wolf rewards 55-1470 Runes upon death
     * @return the Runes to be rewarded upon death
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return new Rune(RandomNumberGenerator.getRandomInt(55, 1470));
    }
}
