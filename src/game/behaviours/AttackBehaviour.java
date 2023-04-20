package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.EnemyType;

import java.util.List;

/**
 * Behaviour that determines whether Actors can/should attack another nearby
 * Actor
 *
 * @version 1.0
 * @see Behaviour
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Checks the surroundings for attackable Actors, then returns the corresponding
     * AttackAction if applicable
     *
     * @param actor the actor who is attacking
     * @param map   the game map
     * @return the Action to be carried out if available, or null otherwise
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        // The location of the actor attacking others
        Location actorLocation = map.locationOf(actor);

        // Iterate through the 8 surrounding locations
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                // Don't add the location of myself
                if (xOffset == 0 && yOffset == 0) {
                    continue;
                }

                // Get the location
                Location targetLocation = map.at(actorLocation.x() + xOffset, actorLocation.y() + yOffset);
                if (targetLocation != null) {
                    // If the location exists on the map
                    Actor actorAtLocation = map.getActorAt(targetLocation);
                    if (actorAtLocation != null) {
                        // If an actor exists at this location, see whether it can be attacked
                        Boolean isOfSameType = false;
                        // Get the EnemyTypes of this actor and the target actor
                        List<EnemyType> otherActorTypes = actorAtLocation.findCapabilitiesByType(EnemyType.class);
                        List<EnemyType> actorTypes = actor.findCapabilitiesByType(EnemyType.class);
                        // Check whether they possess the same EnemyType capability
                        for (EnemyType actorType : actorTypes) {
                            for (EnemyType otherActorType : otherActorTypes) {
                                if (actorType == otherActorType) isOfSameType = true;
                                break;
                            }
                        }

                        if (!isOfSameType) {
                            // If they are not of the same type, the actor can proceed with the attack
                            return new SpecialAttackBehaviour().getAction(actor, map);
                        }
                    }
                }
            }
        }
        // No suitable actor to attack, so no action will be returned
        return null;
    }
}
