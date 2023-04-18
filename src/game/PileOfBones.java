package game;

import java.util.HashMap;
import java.util.Map;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Pile of Bones enemy (other enemies can become this after death)
 */
public class PileOfBones extends Actor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor
     * @param formerActor the actor the Pile of Bones used to be
     */
    public PileOfBones(Actor formerActor) {
        super("Pile of Bones", 'X', 1);
        // Because Pile of Bones is an undead enemy, it will remember who it used to be
        // Add the behaviours
        behaviours.put(0, new SwapActorBehaviour(formerActor));
    }


    /**
     * At each turn, the Pile of Bones will check whether it is time to revive its former self
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) return action;
        }
        return new DoNothingAction();
    }
}
