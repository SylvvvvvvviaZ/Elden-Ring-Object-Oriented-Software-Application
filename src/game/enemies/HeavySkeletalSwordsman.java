package game.enemies;

import game.EnemyType;
import game.RandomNumberGenerator;
import game.Status;
import game.currency.CurrencyItem;
import game.currency.Rune;
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
        addCapability(EnemyType.SKELETAL);
        addCapability(Status.DIES_TO_PILE_OF_BONES);
    }

    @Override
    public int getSpawnChance() {
        return 27;
    }

    /**
     * Heavy Skeletal Swordsman rewards 35-892 Runes upon death
     * @return the Runes to be rewarded upon death
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return new Rune(RandomNumberGenerator.getRandomInt(35, 892));
    }
}
