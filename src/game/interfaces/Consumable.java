package game.interfaces;

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

    /**
     * Gets the number of uses so far for this consumable
     * @return number of uses
     */
     int useCount();

    /**
     * Gets the max number of uses for this consumable
     * @return max number of uses
     */
    int maxUseCount();
}
