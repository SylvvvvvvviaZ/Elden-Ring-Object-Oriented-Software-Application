package game.trading;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.currency.BuyingCurrency;
import game.currency.CurrencyItem;

import java.util.HashMap;

/**
 * Base class for a trader actor
 *
 * @author dkon0020
 * @version 0.0
 * @see Actor
 */
public abstract class Trader extends Actor {
    /**
     * The trader's inventory of items that can be bought
     */
    private final HashMap<Buyable, BuyingCurrency> buyableInventory;
    /**
     * The trader's inventory of items that can be sold
     */
    private final HashMap<Sellable, CurrencyItem> sellableInventory;

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
     * Adds a buyable item to the trader's inventory
     *
     * @param item the item that can be bought
     */
    public void addBuyableItem(Buyable item) {
        buyableInventory.put(item, item.getBuyPrice());
    }

    /**
     * Adds a sellable item to the trader's inventory
     *
     * @param item the item that can be sold
     */
    public void addSellableItem(Sellable item) {
        sellableInventory.put(item, item.getSellPrice());
    }

    /**
     * Removes an item from the trader's offerings
     *
     * @param item item to be removed
     */
    public void removeTradeItem(RemembranceOfTheGrafted item) {
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
        buyableInventory.forEach((item, currencyItem) -> actions.add(new BuyTradeAction(item)));
        sellableInventory.forEach((item, currencyItem) -> actions.add(new SellTradeAction(item)));
        return actions;
    }
}
