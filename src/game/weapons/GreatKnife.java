package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.QuickstepAttackAction;
import game.currency.CurrencyItem;
import game.currency.Rune;
import game.interfaces.Buyable;
import game.interfaces.Sellable;

/**
 * Great Knife weapon item
 *
 * @version 1.0
 */
public class GreatKnife extends WeaponItem implements Buyable, Sellable {
    /**
     * Constructor
     */
    public GreatKnife() {
        super("Great Knife", '/', 75, "slashes", 70);
    }

    /**
     * Great Knife can be bought for 3500 runes
     *
     * @return 3500 runes
     */
    @Override
    public CurrencyItem getBuyPrice() {
        return new Rune(3500);
    }

    /**
     * Insert the weapon into the actor's inventory
     *
     * @param buyer the actor buying the item
     */
    @Override
    public void giveToActor(Actor buyer) {
        buyer.addWeaponToInventory(this);
    }

    /**
     * Great Knife can be sold for 350 runes
     *
     * @return 350 runes
     */
    @Override
    public CurrencyItem getSellPrice() {
        return new Rune(350);
    }

    @Override
    public boolean actorHas(Actor seller) {
        for (WeaponItem weaponItem : seller.getWeaponInventory()) {
            if (weaponItem.getClass() == this.getClass()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove the weapon from the actor's inventory
     *
     * @param seller the actor selling the item
     */
    @Override
    public void takeFromActor(Actor seller) {
        WeaponItem itemToRemove = null;
        for (WeaponItem weaponItem : seller.getWeaponInventory()) {
            if (weaponItem.getClass() == this.getClass()) {
                itemToRemove = weaponItem;
                break;
            }
        }
        if (itemToRemove != null) seller.removeWeaponFromInventory(itemToRemove);
    }

    /**
     * Gets the Great Knife's skill: QuickStep
     *
     * @return the QuickStep action
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new QuickstepAttackAction(target, direction, this);
    }
}
