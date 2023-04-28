package game.currency;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface for items that can be used as payment
 * <br/>
 * I don't know how to name this, but it is essentially for objects that can be used as a form of payment when buying
 * things from the trader. It can be used for 'trading' items -- e.g. trading item A for item B would have item A
 * implement this interface. It can, of course, also be used for buying stuff with money (like Runes).
 *
 * @author dkon0020
 * @version 1.0
 */
public interface BuyingCurrency {
    /**
     * Deduct this item from the buying actor -- it might be calling RuneManager or just removing an item from the
     * actor's inventory if 'trading'.
     *
     * @param actor the actor who is buying the item
     * @return true if the deduction was successful; false if the actor cannot afford this deduction (no money)
     */
    boolean deductCurrency(Actor actor);

    /**
     * Get the name of the payment
     *
     * @return name of payment
     */
    String toString();
}
