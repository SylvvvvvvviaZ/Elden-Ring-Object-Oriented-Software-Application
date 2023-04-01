package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Heavy Skeletal Swordsman may become a Pile of Bones
 * @see HeavySkeletalSwordsman
 */
public class PileOfBones extends Actor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Number of turns the Pile of Bones has existed.
     * After 3 turns of no hits, the Pile of Bones will become an HSS again.
     */
    private int turns = 0;
    public PileOfBones() {
        super("Pile of Bones", 'X', 0);
        this.behaviours.put(999, new WanderBehaviour());
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // TODO


        // Increment turn count
        turns += 1;
        return null;
    }
}
