package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.CurrencyManager;
import game.currency.CurrencyItem;
import game.Trade;
import game.interfaces.Buyable;
import game.traders.Trader;

/**
 * Action for an actor to buy an item from a trader
 *
 * @author dkon0020
 * @version 0.0
 * @see TradeAction
 */
public class BuyTradeAction extends Action {
    private final CurrencyManager currencyManager;
    private final Buyable item;

    /**
     * Constructor for item
     *
     * @param item the item to be traded
     */
    public BuyTradeAction(Buyable item) {
        this.currencyManager = CurrencyManager.getInstance();
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
        // Check that the buyer has enough money
        if (!currencyManager.hasSufficientBalance(actor, item.getBuyPrice()))
            return String.format("%s cannot be bought because %s does not have enough money.", item, actor);
        // Process the transaction
        // Deduct money
        currencyManager.removeMoney(actor, item.getBuyPrice());
        // Give the buyer the new item
        item.giveToActor(actor);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s has been purchased by %s for %d %s", item, actor, item.getBuyPrice().getValue(), item.getBuyPrice().getName());
    }
}
