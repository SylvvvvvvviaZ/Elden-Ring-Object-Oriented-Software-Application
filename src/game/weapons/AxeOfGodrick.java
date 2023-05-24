package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.currency.CurrencyItem;
import game.currency.Rune;
import game.trading.Sellable;

/**
 * Axe of Godrick weapon.
 * Starting weapon for Godrick.
 * Deals 142 damage with 84% attack accuracy.
 * Special skill: Damages anything in the holder's surroundings.
 * Not purchasable, but sellable for 100 runes.
 */
public class AxeOfGodrick extends WeaponItem implements Sellable {

    /**
     * Constructor for AxeOfGodrick.
     * Sets the name as "Axe of Godrick", display character as 'T', damage as 142, and attack accuracy as 84%.
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "slashes", 84);
    }

    /**
     * Axe of Godrick can be sold for 100 runes.
     *
     * @return 100 runes as the sell price.
     */
    @Override
    public CurrencyItem getSellPrice() {
        return new Rune(100);
    }

    /**
     * Checks if the actor has the Axe of Godrick.
     *
     * @param seller the actor to check for the weapon.
     * @return true if the actor has the Axe of Godrick, false otherwise.
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


    @Override
    public void takeFromActor(Actor seller) {

    }
}
