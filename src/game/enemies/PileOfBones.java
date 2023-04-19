package game.enemies;

import java.util.HashMap;
import java.util.Map;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.EnemyType;
import game.behaviours.Behaviour;
import game.behaviours.SwapActorBehaviour;

/**
 * Pile of Bones enemy (other enemies can become this after death)
 * @author dkon0020
 * @version 2.0
 * @see Enemy
 */
public class PileOfBones extends Enemy {
    /**
     * Constructor
     * @param formerActor the actor the Pile of Bones used to be
     */
    public PileOfBones(Actor formerActor) {
        super("Pile of Bones", 'X', 1, EnemyType.SKELETAL);
        // Disregard default enemy behaviours
        super.behaviours.clear(); // TODO this seems a little janky
        // Add the behaviours
        super.behaviours.put(0, new SwapActorBehaviour(formerActor));
    }
}
