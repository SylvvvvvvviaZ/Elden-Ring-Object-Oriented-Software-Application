package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Some enemies may become a Pile of Bones
 */
public class PileOfBones extends Actor implements Resettable {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    private Actor formerEntity;

    public PileOfBones(Actor formerEntity) {
        super("Pile of Bones", 'X', 0);
        this.formerEntity = formerEntity;
        behaviours.put(0, new SwapActorBehaviour(formerEntity));
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) return action;
        }
        return new DoNothingAction();
    }

    @Override
    public void reset(ResetType resetType) {

    }
}
