package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.EnemyType;
import game.behaviours.SwapActorBehaviour;
import game.weapons.Grossmesser;

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
        super("Pile of Bones", 'X', 1, EnemyType.SKELETAL, new Grossmesser());
        addCapability(EnemyType.SKELETAL);
        // Disregard default enemy behaviours
        super.behaviours.clear(); // TODO this seems a little janky
        // Add the behaviours
        super.behaviours.put(0, new SwapActorBehaviour(formerActor));
    }
}
