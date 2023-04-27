package game.enemies;

import game.EnemyType;
import game.RandomNumberGenerator;
import game.Status;
import game.currency.CurrencyItem;
import game.currency.Rune;
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
        addCapability(EnemyType.SKELETAL);
        addCapability(Status.DIES_TO_PILE_OF_BONES);
    }

    @Override
    public int getSpawnChance() {
        return 27;
    }

    /**
     * Skeletal Bandit rewards 35-892 Runes upon death
     * @return the Runes to be rewarded upon death
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return new Rune(RandomNumberGenerator.getRandomInt(35, 892));
    }
}
