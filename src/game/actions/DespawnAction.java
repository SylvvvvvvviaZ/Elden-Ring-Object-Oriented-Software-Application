package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Action that despawns an actor from the map (used by enemies)
 *
 * @author dkon0020
 * @version 1.0
 * @see Action
 */
public class DespawnAction extends Action {
    /**
     * Remove the actor from the map (despawn it)
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a message describing the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return menuDescription(actor);
    }

    /**
     * Menu description of the action
     *
     * @param actor The actor performing the action.
     * @return a description describing the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s has despawned.", actor);
    }
}
