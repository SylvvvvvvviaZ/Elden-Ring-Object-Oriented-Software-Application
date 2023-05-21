package game.enemies;

import game.RandomNumberGenerator;
import game.currency.CurrencyItem;
import game.currency.Rune;
import game.weapons.Scimitar;

/**
 * Godrick Soldier enemy
 *
 * @author akya0002
 * @version 1.0
 * @see Enemy
 */
public class GodrickSoldier extends Enemy {
    /**
     * Constructor
     */
    public GodrickSoldier() {
        super("GodrickSoldier", 'p', 198, EnemyType.CASTLE, new Scimitar());
        addCapability(EnemyType.CASTLE);
    }

    /**
     * Dog has a 45% chance of spawning from barrack in Stormveil Castle
     *
     * @return 45%
     */
    @Override
    public int getSpawnChance() {
        return 45;
    }

    /**
     * Dog rewards 38-70 Runes upon death
     *
     * @return the Runes to be rewarded upon death
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return new Rune(RandomNumberGenerator.getRandomInt(38, 70));
    }
}
