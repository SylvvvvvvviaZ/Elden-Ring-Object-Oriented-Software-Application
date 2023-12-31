package game.trading;

import edu.monash.fit2099.engine.actors.Actor;
import game.currency.BuyingCurrency;
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
    BuyingCurrency getBuyPrice();

    /**
     * Implementation of giving the item to the buyer actor
     *
     * @param buyer the actor buying the item
     */
    void giveToActor(Actor buyer);
}
