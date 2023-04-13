package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.HashMap;

/**
 * Base class for a trader actor
 *
 * @author dkon0020
 * @version 0.0
 * @see Actor
 */
public abstract class Trader extends Actor {
    private final HashMap<Item, CurrencyItem> buyableInventory;
    private final HashMap<Item, CurrencyItem> sellableInventory;

    /**
     * Constructor
     *
     * @param name        name of the trader
     * @param displayChar the display character for the trader
     */
    public Trader(String name, Character displayChar) {
        super(name, displayChar, 0);
        buyableInventory = new HashMap<>();
        sellableInventory = new HashMap<>();
    }

    /**
     * (Disabled function)
     * <br/>
     * Add an item to be traded by the trader for a certain price
     * <br/>
     * Note: the allowed trades for the item are defined in the item's capability
     * set.
     *
     * @param item      the item to be traded
     * @param itemPrice the price of the trade
     */
    private void addTradeItem(Item item, CurrencyItem itemPrice) {
        if (item.hasCapability(Trade.BUYABLE))
            buyableInventory.put(item, itemPrice);
        if (item.hasCapability(Trade.SELLABLE))
            sellableInventory.put(item, itemPrice);
    }

    /**
     * Adds a buyable item to the trader's inventory
     * 
     * @param item      the item that can be sold
     * @param itemPrice the price of the item
     */
    public void addBuyableItem(Item item, CurrencyItem itemPrice) {
        if (item.hasCapability(Trade.BUYABLE))
            buyableInventory.put(item, itemPrice);
    }

    /**
     * Adds a sellable item to the trader's inventory
     * 
     * @param item      the item that can be bought
     * @param itemPrice the price of the item
     */
    public void addSellableItem(Item item, CurrencyItem itemPrice) {
        if (item.hasCapability(Trade.SELLABLE))
            sellableInventory.put(item, itemPrice);
    }

    /**
     * Removes an item from the trader's offerings
     *
     * @param item item to be removed
     */
    public void removeTradeItem(Item item) {
        buyableInventory.remove(item);
        sellableInventory.remove(item);
    }

    /**
     * The merchant does not do anything
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting
     *                   things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the action to do for the turn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * Returns a list of trade actions for the items available in the merchant's
     * inventory
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return ActionList of trading actions available to this merchant
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        buyableInventory.forEach((item, currencyItem) -> {
            actions.add(new BuyTradeAction(this, item, currencyItem));
        });
        sellableInventory.forEach((item, currencyItem) -> {
            actions.add(new SellTradeAction(this, item, currencyItem));
        });
        return actions;
    }
}
