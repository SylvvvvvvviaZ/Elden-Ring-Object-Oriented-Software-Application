package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Action for an actor to sell an item to a trader
 *
 * @author dkon0020
 * @version 0.0
 * @see TradeAction
 */
public class SellTradeAction extends TradeAction {
    /**
     * Constructor for item
     *
     * @param trader    the trader who will be trading this item
     * @param item      the item to be traded
     * @param itemPrice the price of the item
     */
    public SellTradeAction(Trader trader, Item item, CurrencyItem itemPrice) {
        super(trader, item, itemPrice);
    }

    /**
     * Constructor for weapon item
     *
     * @param trader     the trader who will be trading this item
     * @param weaponItem the weapon to be traded
     * @param itemPrice  the price of the weapon
     */
    public SellTradeAction(Trader trader, WeaponItem weaponItem, CurrencyItem itemPrice) {
        super(trader, weaponItem, itemPrice);
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
        // Check that the item can be bought (in practice, this should never fail)
        if (!item.hasCapability(Trade.SELLABLE))
            return String.format("%s cannot be sold because it is not sellable.", item);
        // Process the transaction
        // Remove item from actor's inventory
        if (item != null) actor.removeItemFromInventory(item);
        if (weaponItem != null) actor.removeWeaponFromInventory(weaponItem);
        // Pay the seller for the item
        currencyManager.addMoney(actor, itemPrice);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s has been sold by %s for %d %s", item, actor, itemPrice.getValue(), itemPrice.getName());
    }
}
