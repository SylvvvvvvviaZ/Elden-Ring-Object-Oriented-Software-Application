package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.RandomNumberGenerator;
import game.Status;
import game.actions.DespawnAction;

import java.util.Random;

/**
 * Behaviour for despawning actors based on a probability
 *
 * @author dkon0020
 * @version 1.0
 * @see Behaviour
 */
public class DespawnBehaviour implements Behaviour {
    /**
     * The chance that the actor despawns every turn
     */
    private final int despawnChance;

    /**
     * Constructor
     *
     * @param despawnChance the chance of the actor despawning
     */
    public DespawnBehaviour(int despawnChance) {
        this.despawnChance = despawnChance;
    }

    /**
     * If the probability permits, the actor will despawn
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return DespawnAction if the probability permits; otherwise, return null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (!actor.hasCapability(Status.FOLLOWING_PLAYER) &&
                RandomNumberGenerator.getRandomInt(0, 100) <= despawnChance)
            return new DespawnAction();
        return null;
    }
}
