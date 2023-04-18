package game;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface for items that can be consumed by an actor
 */
public interface Consumable {
    /**
     * The implementation of the item's effect on the player when consumed
     * @param actor the actor who is consuming the item
     */
    void consume(Actor actor);
}
