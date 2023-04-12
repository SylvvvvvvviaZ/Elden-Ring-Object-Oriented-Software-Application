package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Action for picking up currency items that uses the CurrencyManager to update balances
 * @author dkon0020
 * @version 0.0
 * @see PickUpAction
 */
public class PickUpCurrencyAction extends PickUpAction {
    private final CurrencyItem item;
    public PickUpCurrencyAction(CurrencyItem item) {
        super(item);
        this.item = item;
    }

    /**
     * Picks up the currency item, and updates the actor's balance
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return menu printout of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        CurrencyManager.getInstance().addMoney(actor, item);
        return super.execute(actor, map);
    }

    /**
     * Gets the menu description for the pick-up action
     * @param actor The actor performing the action.
     * @return description for the pick-up action
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s picks up the %s with %d value", actor.toString(), item.toString(), item.getValue());
    }
}
