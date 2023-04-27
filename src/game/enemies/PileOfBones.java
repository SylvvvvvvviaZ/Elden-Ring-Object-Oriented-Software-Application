package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.EnemyType;
import game.RandomNumberGenerator;
import game.Status;
import game.behaviours.SwapActorBehaviour;
import game.currency.CurrencyItem;
import game.currency.Rune;
import game.weapons.Grossmesser;

/**
 * Pile of Bones enemy (other enemies can become this after death)
 *
 * @author dkon0020
 * @version 2.0
 * @see Enemy
 */
public class PileOfBones extends Enemy {
    /**
     * Constructor
     *
     * @param formerActor the actor the Pile of Bones used to be
     */
    public PileOfBones(Actor formerActor) {
        super("Pile of Bones", 'X', 1, EnemyType.SKELETAL);
        addCapability(EnemyType.SKELETAL);
        addCapability(Status.UNMOVABLE);
        // Disregard default enemy behaviours
        super.behaviours.clear(); // TODO this seems a little janky
        // Add the behaviours
        super.behaviours.put(0, new SwapActorBehaviour(formerActor));
        System.out.println(behaviours.values());
        // Add the former actor's inventory
        for (WeaponItem weaponItem : formerActor.getWeaponInventory()) {
            addWeaponToInventory(weaponItem);
        }
        for (Item item : formerActor.getItemInventory()) {
            addItemToInventory(item);
        }
    }

    @Override
    public int getSpawnChance() {
        return 0;
    }

    /**
     * Pile of Bones awards 35-892 Runes upon death
     *
     * @return 35-892 Runes
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return new Rune(RandomNumberGenerator.getRandomInt(35, 892));
    }
}
