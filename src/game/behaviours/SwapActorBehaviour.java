package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SwapActorAction;

/**
 * A behaviour that causes the actor to swap positions with a target actor after a certain number of turns.
 */
public class SwapActorBehaviour implements Behaviour {
    private int turnCount;
    private final int turnCountLimit;
    private Actor targetActor;

    /**
     * Constructs a new SwapActorBehaviour with the specified target actor.
     *
     * @param targetActor the actor to swap positions with
     * @param swapAtTurn  the number of turns at which to revive former actor
     */
    public SwapActorBehaviour(Actor targetActor, int swapAtTurn) {
        this.turnCount = 0;
        this.targetActor = targetActor;
        this.turnCountLimit = swapAtTurn;
    }

    /**
     * Returns an action to be performed by the actor. If the turn count has reached * 3, a SwapActorAction is returned.
     * Otherwise returm the null.
     *
     * @param actor the actor performing the behaviour
     * @param map   the game map on which the actor is located
     * @return an Action to be performed by the actor, otherwise just return null.
     */

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (turnCount == turnCountLimit) {
            return new SwapActorAction(targetActor);
        }
        turnCount += 1;
        return null;
    }
}