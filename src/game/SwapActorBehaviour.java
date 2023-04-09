package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class SwapActorBehaviour implements Behaviour {
    /**
     * Number of turns this behaviour as existed
     */
    private int turnCount;
    /**
     * The Actor that the original entity will become if a number of turns have passed
     */
    private final Actor targetEntity;

    public SwapActorBehaviour(Actor targetEntity) {
        turnCount = 0;
        this.targetEntity = targetEntity;
    }

    /**
     * If the entity has lasted for 3 turns, revive its former entity (targetEntity)
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return the SwapActorAction if 3 turns have passed, or null if it is not yet time
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        turnCount += 1;
        return turnCount >= 3 ? new SwapActorAction(targetEntity) : null;
    }
}
