package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.attackactions.LifeStealAttackAction;
import game.currency.CurrencyItem;
import game.currency.Rune;
import game.trading.Sellable;

/**
 * RiversOfBlood weapon
 * @author akya0002
 * @version 1.0
 * @see WeaponItem
 */
public class RiversOfBlood extends WeaponItem implements Sellable {
    /**
     * Constructor
     */
    public RiversOfBlood(){
        super("RiversOfBlood", ']', 120, "slashes", 80);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new LifeStealAttackAction(target, direction, this);
    }
    /**
     * RiversOfBlood can be sold for 570 runes
     * @return 570 runes
     */
    @Override
    public CurrencyItem getSellPrice() {
        return new Rune(570);
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
}
