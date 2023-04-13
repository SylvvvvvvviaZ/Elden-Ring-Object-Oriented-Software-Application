package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.HashMap;
import java.util.Map;

public class HeavySkeletalSwordsman extends Actor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.behaviours.put(999, new WanderBehaviour());

        addCapability(EnemyType.SKELETAL);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            if (otherActor.getWeaponInventory().isEmpty()) {
              actions.add(new AttackAction(this, direction));
            } else {
              actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(0)));
            }

        }
        return actions;
    }

    public WeaponItem getWeaponItem() {
      return new Grossmesser();
    }

}
