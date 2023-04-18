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

public class GiantCrayfish extends Actor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803);
        this.behaviours.put(997, new AttackBehaviour());
        this.behaviours.put(998, new FollowBehaviour(Player.getInstance()));
        this.behaviours.put(999, new WanderBehaviour());

        addCapability(EnemyType.CRUSTACEAN);
    }

    
    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
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

    
    /**
    * Returns a list of allowable actions for an actor to attack another actor in a given direction on a map.
    * @param otherActor the actor being attacked
    * @param direction the direction the attacking actor is facing
    * @param map the map the actors are on
    * @return a list of allowable actions for the attacking actor
    */
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
     * Giant Crayfish can slam with 527 damage and 100% accuracy
     *
     * @return Giant Crayfish's slam intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slams", 100);
    }
}
