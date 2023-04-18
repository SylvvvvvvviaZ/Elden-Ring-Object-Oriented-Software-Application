package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Action that swaps an actor with another actor
 * @version 1.0
 */
public class SwapActorAction extends Action {
    private Actor targetActor;

    /**
     * Constructor
     * @param targetActor the actor that the current actor will become upon this action
     */
    public SwapActorAction(Actor targetActor) {
        this.targetActor = targetActor;
    }

    /**
     * Swap the actors
     * @param actor the actor who will become the new actor
     * @param map the game map
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // Get the original location of the actor
        Location locationOfActor = map.locationOf(actor);
        // Remove the original actor
        map.removeActor(actor);
        // Add the new actor in the same location
        map.addActor(targetActor, locationOfActor);
        return menuDescription(actor);
    }

    /**
    * Returns a description of this action suitable for displaying in a menu.
    * @param actor the actor performing the action
    * @return a String describing the menuDescription
    */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s has become a %s", actor, targetActor);
    }
}