package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.RuneManager;
import game.currency.BuyingCurrency;
import game.interfaces.Buyable;

/**
 * Action for an actor to buy an item from a trader
 *
 * @author dkon0020
 * @version 0.0
 * @see TradeAction
 */
public class BuyTradeAction extends Action {
    private final Buyable item;

    /**
     * Constructor for item
     *
     * @param item the item to be traded
     */
    public BuyTradeAction(Buyable item) {
        this.item = item;
    }

    /**
     * Executes the buying action
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return message indicating outcome
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // Process the transaction
        BuyingCurrency buyPrice = item.getBuyPrice();
        // Deduct money
        if (!buyPrice.deductCurrency(actor)) {
            // Player cannot afford to buy this item
            return String.format("%s cannot be bought because %s cannot afford this payment of %s.", item, actor, item.getBuyPrice());
        }
//        if (!RuneManager.getInstance().removeMoney(actor, item.getBuyPrice())) {
//            // Actor does not have enough money
//            return String.format("%s cannot be bought because %s does not have enough money.", item, actor);
//        }
        // Give the buyer the new item
        item.giveToActor(actor);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s purchases %s for %s.", actor, item, item.getBuyPrice());
    }
}
