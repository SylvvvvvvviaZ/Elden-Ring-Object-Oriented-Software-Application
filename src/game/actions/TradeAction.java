package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.currency.CurrencyItem;
import game.CurrencyManager;
import game.traders.Trader;

/**
 * Base class for trade-related actions
 *
 * @author dkon0020
 * @version 0.0
 * @see Action
 */
public abstract class TradeAction extends Action {
    /**
     * Trader offering the trade deal
     */
    protected final Trader trader;
    /**
     * Item to be traded
     */
    protected Item item = null;
    /**
     * Weapon to be traded
     */
    protected WeaponItem weaponItem = null;
    /**
     * Price of the trade with currency
     */
    protected final CurrencyItem itemPrice;
    /**
     * Currency Manager instance
     */
    protected final CurrencyManager currencyManager;

    /**
     * Constructor for item
     *
     * @param trader    the trader who will be trading this item
     * @param item      the item to be traded
     * @param itemPrice the price of the item
     */
    public TradeAction(Trader trader, Item item, CurrencyItem itemPrice) {
        this.trader = trader;
        this.item = item;
        this.itemPrice = itemPrice;
        currencyManager = CurrencyManager.getInstance();
    }

    /**
     * Constructor for weapon item
     *
     * @param trader     the trader who will be trading this item
     * @param weaponItem the weapon to be traded
     * @param itemPrice  the price of the weapon
     */
    public TradeAction(Trader trader, WeaponItem weaponItem, CurrencyItem itemPrice) {
        this.trader = trader;
        this.weaponItem = weaponItem;
        this.itemPrice = itemPrice;
        currencyManager = CurrencyManager.getInstance();
    }

    /**
     * Execute the trade action
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return message describing the trade outcome
     */
    public abstract String execute(Actor actor, GameMap map);

    /**
     * Get the description to be displayed to the menu
     *
     * @param actor The actor performing the action.
     * @return message to be displayed to the menu describing the trade
     */
    public abstract String menuDescription(Actor actor);
}
