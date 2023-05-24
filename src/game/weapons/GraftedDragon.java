package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.currency.CurrencyItem;
import game.currency.Rune;
import game.trading.Sellable;

/**
 * Grafted Dragon weapon.
 * Obtained during the second phase, replacing the Axe of Godrick.
 * Deals 89 damage with 90% attack accuracy.
 * Special skill: Damages anything in the holder's surroundings.
 * Not purchasable, but sellable for 200 runes.
 */
public class GraftedDragon extends WeaponItem implements Sellable {

    /**
     * Constructor for GraftedDragon.
     * Sets the name as "Grafted Dragon", display character as 'N', damage as 89, and attack accuracy as 90%.
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "slashes", 90);
    }

    /**
     * Grafted Dragon can be sold for 200 runes.
     *
     * @return 200 runes as the sell price.
     */
    @Override
    public CurrencyItem getSellPrice() {
        return new Rune(200);
    }

    /**
     * Checks if the actor has the Grafted Dragon.
     *
     * @param seller the actor to check for the weapon.
     * @return true if the actor has the Grafted Dragon, false otherwise.
     */
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
     * Takes the Grafted Dragon from the seller actor.
     *
     * @param seller the actor from whom to take the weapon.
     */
    @Override
    public void takeFromActor(Actor seller) {
        seller.removeItemFromInventory(this);
    }
}
