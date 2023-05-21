package game.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.RandomNumberGenerator;
import game.currency.CurrencyItem;
import game.currency.Rune;

/**
 * Dog enemy
 *
 * @author akya0002
 * @version 1.0
 * @see Enemy
 */
public class Dog extends Enemy {
    /**
     * Constructor
     */
    public Dog() {
        super("Dog", 'a', 104, EnemyType.CASTLE, new IntrinsicWeapon(101, "bites", 93));
        addCapability(EnemyType.CASTLE);
        //addCapability(SpecialAttackType.SLAM);
    }

    /**
     * Dog has a 37% chance of spawning from cage in Stormveil Castle
     *
     * @return 37%
     */
    @Override
    public int getSpawnChance() {
        return 37;
    }

    /**
     * Dog rewards 52-1390 Runes upon death
     *
     * @return the Runes to be rewarded upon death
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return new Rune(RandomNumberGenerator.getRandomInt(52, 1390));
    }
}
