package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.EnemyType;
import game.Player;
import game.Status;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.weapons.Scimitar;

import java.util.HashMap;
import java.util.Map;

/**
 * A subclass of Actor that represents a skeletal bandit.
 */
public class SkeletalBandit extends Actor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor for the SkeletalBandit class.
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184);
        // Add the behaviours of the enemy
        this.behaviours.put(997, new AttackBehaviour());
        this.behaviours.put(998, new FollowBehaviour(Player.getInstance()));
        this.behaviours.put(999, new WanderBehaviour());
        // Add the enemy's type
        addCapability(EnemyType.SKELETAL);
    }
    /**
     * Returns the next action to be taken by the actor.
     * 
     * @param actions The list of possible Actions
     * @param lastAction The Action that was performed last turn.
     * @param map The map containing the Actor.
     * @param display The Display where the map is drawn.
     * @return The Action to be performed.
     */
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
      return new Scimitar();
    }

}
