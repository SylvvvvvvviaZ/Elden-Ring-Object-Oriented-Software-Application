package game.trading;

import edu.monash.fit2099.engine.actors.Actor;
import game.currency.CurrencyItem;

/**
 * Interface for items that can be sold
 *
 * @author dkon0020
 * @version 1.0
 */
public interface Sellable {
    /**
     * Gets the sell price of the item
     *
     * @return the sell price
     */
    CurrencyItem getSellPrice();

    /**
     * Check whether the actor has the item
     *
     * @param seller the seller whose inventory to check
     * @return whether the actor possesses the item
     */
    boolean actorHas(Actor seller);

    /**
     * Implementation of removing the item from the seller actor
     *
     * @param seller the actor selling the item
     */
    void takeFromActor(Actor seller);
}
