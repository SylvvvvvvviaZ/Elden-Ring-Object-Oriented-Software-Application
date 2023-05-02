package game.attackactions;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.AoeCapable;

/**
 * Base class for area-based attacks (attacks that target actors in the surroundings)
 */
public abstract class AreaAttackAction extends Action implements AoeCapable {
    private final Weapon weapon;

    /**
     * Instantiates the base attack class with the weapon to be used
     *
     * @param weapon the weapon to be used for the attack
     */
    public AreaAttackAction(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Executes the spinning attack action by finding all the targets around the actor, performing the attack on each target,
     * and returning the result of the action as a string.
     *
     * @param actor the actor performing the area attack
     * @param map   the game map
     * @return a string containing the results of the attacks
     */
    public String execute(Actor actor, GameMap map) {
        List<AttackAction> attackActions = new ArrayList<>(8);

        // The location of the actor attacking others
        Location actorLocation = map.locationOf(actor);

        for (Location targetLocation : getSurroundingLocations(map, actorLocation)) {
            // check if the target location is valid
            if (targetLocation != null && targetLocation.containsAnActor()) {
                String direction = getDirection(actorLocation, targetLocation);
                Actor target = map.getActorAt(targetLocation);
                // AOE attacks do not care about enemy types, so just add them straightaway
                attackActions.add(new AttackAction(target, direction, weapon));
            }
        }

        StringBuilder result = new StringBuilder();

        // Iterate through the AttackActions to run the area attack
        for (AttackAction attack : attackActions) {
            result.append(System.lineSeparator()).append(attack.execute(actor, map));
        }

        return result.toString();
    }

    /**
     * Generates a string representation of the area attack
     *
     * @param actor the actor performing the attack
     * @return a string representation of the attack
     */
    @Override
    public abstract String menuDescription(Actor actor);
}
