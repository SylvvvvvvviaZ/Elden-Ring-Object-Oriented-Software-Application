package game.attackactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * Quickstep weapon skill
 *
 * @author dkon0020
 * @version 1.0
 * @see Action
 */
public class QuickstepAttackAction extends Action {
    private final Actor target;
    private final String direction;
    private final Weapon weapon;

    /**
     * Constructor
     *
     * @param target    the Actor to attack
     * @param direction the direction where the attack should be performed (only
     *                  used for display purposes)
     * @param weapon    the weapon being used to attack
     */
    public QuickstepAttackAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Performs the standard attack action, then moves away from the target
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return the result of the actions
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        // Deal normal attack
        result += new AttackAction(target, direction, weapon).execute(actor, map);
        // Calculate position of attacker with target
        Location actorLocation = map.locationOf(actor);

        // Check actor's surrounding locations to find one without an actor
        xLoop:
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (x == 0 && y == 0) continue; // don't try where the actor is located
                Location location = map.at(actorLocation.x() + x, actorLocation.y() + y);
                if (!location.canActorEnter(actor)) continue; // actor must be able to enter the location
                if (!location.containsAnActor()) {
                    // If no actor is present, the actor shall move to this location
                    result += new MoveActorAction(location, null).execute(actor, map);
                    break xLoop;
                }
            }
        }
        return result;
    }

    /**
     * Gets a description of the action for the menu
     *
     * @param actor The actor performing the action.
     * @return description to display to menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s attacks %s using Quickstep at %s with %s", actor, target, direction, (weapon != null ? weapon : "Intrinsic Weapon"));
    }
}
