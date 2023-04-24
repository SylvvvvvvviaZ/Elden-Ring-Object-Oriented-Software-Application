package game.actions;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * Base class for area-based attacks (attacks that target actors in the surroundings)
 */
public abstract class AreaAttackAction extends Action {
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

        // Iterate through the 8 surrounding locations
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                // Don't add the location of myself
                if (xOffset == 0 && yOffset == 0) {
                    continue;
                }
                // Check that the location is within the map
                if (!map.getXRange().contains(actorLocation.x() + xOffset) || !map.getYRange().contains(actorLocation.y() + yOffset)) {
                    continue;
                }
                Location targetLocation = map.at(actorLocation.x() + xOffset, actorLocation.y() + yOffset);
                // check if the target location is valid
                if (targetLocation != null && targetLocation.containsAnActor()) {
                    String direction = "";
                    direction += switch (yOffset) {
                        case -1 -> "north";
                        case 1 -> "south";
                        default -> "";
                    };
                    direction += switch (xOffset) {
                        case -1 -> "west";
                        case 1 -> "east";
                        default -> "";
                    };
                    Actor target = map.getActorAt(targetLocation);
                    attackActions.add(new AttackAction(target, direction, weapon));
                    // targets.add(map.getActorAt(targetLocation));
                }
            }
        }

        StringBuilder result = new StringBuilder();

        // Iterate through the AttackActions to run the area attack
        for (AttackAction attack : attackActions) {
            result.append(attack.execute(actor, map));
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
