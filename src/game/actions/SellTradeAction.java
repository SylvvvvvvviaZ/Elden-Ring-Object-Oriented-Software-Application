package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.RuneManager;
import game.interfaces.Sellable;

/**
 * Action for an actor to sell an item to a trader
 *
 * @author dkon0020
 * @version 0.0
 * @see TradeAction
 */
public class SellTradeAction extends Action {
    private final RuneManager runeManager;
    private final Sellable item;

    /**
     * Constructor for item
     *
     * @param item the item to be traded
     */
    public SellTradeAction(Sellable item) {
        this.runeManager = RuneManager.getInstance();
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
        // Check whether the actor has the item being sold
        if (!actor.getItemInventory().contains(item) && !actor.getWeaponInventory().contains(item)) {
            return String.format("%s cannot sell %s because they do not own one.", actor, item);
        }
        // Remove item from actor's inventory
        item.takeFromActor(actor);
        runeManager.addMoney(actor, item.getSellPrice());
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s sells %s for %d %s", actor, item, item.getSellPrice().getValue(), item.getSellPrice().getName());
    }
}
