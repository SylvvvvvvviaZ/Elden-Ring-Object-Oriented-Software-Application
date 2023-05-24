package game.trading;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Remembrance of the Grafted item interface.
 */
public interface RemembranceOfTheGrafted {

    /**
     * Checks if the seller actor has the Remembrance of the Grafted item.
     *
     * @param seller the actor to check for the item
     * @return true if the actor has the item, false otherwise
     */
    boolean actorHas(Actor seller);

    /**
     * Removes the Remembrance of the Grafted item from the seller actor.
     *
     * @param seller the actor selling the item
     */
    void takeFromActor(Actor seller);
}
