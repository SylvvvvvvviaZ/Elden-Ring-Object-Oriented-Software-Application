package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.SpinningAttackAction;
import game.currency.CurrencyItem;
import game.currency.Rune;
import game.interfaces.Sellable;

/*
A class that represents a Grossmesser, a curved sword that can perform targeted and spinning attacks.
*/
public class Grossmesser extends WeaponItem implements Sellable {

    /**
     * Constructor
     * Set its damage, accuracy, and verb for the targeted attack.
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "slash", 85);
    }

    @Override
    public Action getSkill(Actor actor) {
        return new SpinningAttackAction(this);
    }

    /**
     * Grossmesser can be sold for 100 runes
     *
     * @return 100 runes
     */
    @Override
    public CurrencyItem getSellPrice() {
        return new Rune(100);
    }

    /**
     * Remove the weapon from the actor's inventory
     * @param seller the actor selling the item
     */
    @Override
    public void takeFromActor(Actor seller) {
        seller.removeWeaponFromInventory(this);
    }
}




