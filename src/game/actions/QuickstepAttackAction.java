package game.actions;

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
        Location targetLocation = map.locationOf(target);
        int xDiff = targetLocation.x() - actorLocation.x();
        int yDiff = targetLocation.y() - actorLocation.y();
        // Move away from the target
        result += new MoveActorAction(new Location(map, actorLocation.x() - xDiff, actorLocation.y() - yDiff), null)
                .execute(actor, map);
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
        return String.format("%s performs Quickstep!", actor);
    }
}
