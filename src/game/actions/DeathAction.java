package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RuneManager;
import game.Status;
import game.enemies.Enemy;
import game.interfaces.CurrencySource;

import java.util.Currency;

/**
 * An action executed if an actor is killed.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 */
public class DeathAction extends Action {
    private Actor attacker;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map    The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";

        ActionList dropActions = new ActionList();
        // drop all items
        for (Item item : target.getItemInventory()) {
            if (item.hasCapability(Status.DROP_ON_PLAYER_ATTACK_ONLY)) {
                // Item should only be dropped if attacked by player
                if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    // Item can be dropped
                    if (item.hasCapability(Status.IMMEDIATE_PICK_UP)) {
                        // Item should be transferred to player instead of being dropped
                        result += System.lineSeparator() + item.getPickUpAction(attacker).execute(attacker, map);
                    } else {
                        // Drop item as usual
                        dropActions.add(item.getDropAction(target));
                    }
                    continue;
                }
                // Item cannot be dropped
                continue;
            }
            dropActions.add(item.getDropAction(target));
        }
        for (WeaponItem weapon : target.getWeaponInventory())
            dropActions.add(weapon.getDropAction(target));
        for (Action drop : dropActions)
            drop.execute(target, map);
        // remove actor
        map.removeActor(target);
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
