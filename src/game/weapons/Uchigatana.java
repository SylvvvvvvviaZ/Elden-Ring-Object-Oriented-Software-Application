package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.attackactions.UnsheatheAttackAction;
import game.currency.CurrencyItem;
import game.currency.Rune;
import game.trading.Buyable;
import game.trading.Sellable;

/**
 * Uchigatana weapon
 * @version 2.0
 * @see WeaponItem
 */
public class Uchigatana extends WeaponItem implements Buyable, Sellable {
    /**
     * Constructor
     */
    public Uchigatana(){
        super("Uchigatana", ')', 115, "slashes", 80);
    }

    /**
     * Uchigatana can be bought for 5000 runes
     * @return 5000 runes
     */
    @Override
    public CurrencyItem getBuyPrice() {
        return new Rune(5000);
    }

    /**
     * Insert the weapon into the actor's inventory
     * @param buyer the actor buying the item
     */
    @Override
    public void giveToActor(Actor buyer) {
        buyer.addWeaponToInventory(this);
    }

    /**
     * Uchigatana can be sold for 500 runes
     * @return 500 runes
     */
    @Override
    public CurrencyItem getSellPrice() {
        return new Rune(500);
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

    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAttackAction(target, direction, this);
    }
}
