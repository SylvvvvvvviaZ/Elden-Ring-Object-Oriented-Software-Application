package game;

import java.util.HashMap;
import java.util.Map;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class GiantCrab extends Actor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public GiantCrab() {
        super("Giant Crab", 'C', 407);
        behaviours.put(998, new FollowBehaviour(Player.getInstance()));
        behaviours.put(999, new WanderBehaviour());

        addCapability(EnemyType.CRUSTACEAN);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        actions.add(new SlamAttack());
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.findCapabilitiesByType(EnemyType.class) != this.findCapabilitiesByType(EnemyType.class)) {
            if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                actions.add(new AttackAction(this, direction));
            }
        }
        return actions;
    }

    /**
     * Giant Crab can slam with 208 damage and 90% accuracy
     *
     * @return Giant Crab's slam intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slam", 90);
    }
}
