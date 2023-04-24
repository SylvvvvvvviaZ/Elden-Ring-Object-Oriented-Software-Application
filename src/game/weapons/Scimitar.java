package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.currency.CurrencyItem;
import game.currency.Rune;
import game.interfaces.Buyable;
import game.interfaces.Sellable;

/**
 * Scimitar weapon
 *
 * @author dkon0020
 * @version 1.0
 * @see WeaponItem
 */
public class Scimitar extends WeaponItem implements Buyable, Sellable {
    /**
     * Constructor
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "slashes", 88);
    }


    /**
     * Scimitar can be bought for 600 runes
     *
     * @return 600 runes
     */
    @Override
    public CurrencyItem getBuyPrice() {
        return new Rune(600);
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
     * Scimitar can be sold for 100 runes
     *
     * @return 100 runes
     */
    @Override
    public CurrencyItem getSellPrice() {
        return new Rune(100);
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
}