package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Action that swaps
 */
public class SwapActorAction extends Action {
    private Actor targetEntity;

    public SwapActorAction(Actor targetEntity) {
        this.targetEntity = targetEntity;
    }

    /**
     * Removes the Pile of Bones, and revives the former Actor at the same location
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location entityLocation = map.locationOf(actor);
        map.removeActor(actor);
        map.addActor(targetEntity, entityLocation);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return this + " has become " + targetEntity.toString();
    }
}
