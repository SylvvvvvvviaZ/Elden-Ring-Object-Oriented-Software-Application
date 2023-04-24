package game.interfaces;

import edu.monash.fit2099.engine.actors.Actor;
import game.currency.CurrencyItem;

/**
 * Interface for items that can be bought
 *
 * @author dkon0020
 * @version 1.0
 */
public interface Buyable {
    /**
     * Gets the buy price of the item
     *
     * @return the buy price
     */
    CurrencyItem getBuyPrice();

    /**
     * Implementation of giving the item to the buyer actor
     *
     * @param buyer the actor buying the item
     */
    void giveToActor(Actor buyer);
}
