package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.EnemyType;
import game.Player;
import game.RandomNumberGenerator;
import game.Status;
import game.actions.AttackAction;
import game.actions.DespawnAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all enemies that contains enemies' common properties
 *
 * @author dkon0020
 * @version 1.0
 * @see Actor
 */
public abstract class Enemy extends Actor {
    /**
     * Behaviours of the enemy are used to execute AI-like operations
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();
    /**
     * The enemy's special intrinsic weapon (if any)
     */
    private IntrinsicWeapon intrinsicWeapon;

    /**
     * Constructor
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param enemyType   the enemy's type
     */
    public Enemy(String name, char displayChar, int hitPoints, EnemyType enemyType) {
        super(name, displayChar, hitPoints);
        // Add enemy type
        addCapability(enemyType);
        // Add the common behaviours of enemies
        this.behaviours.put(997, new AttackBehaviour());
        this.behaviours.put(998, new FollowBehaviour(Player.getInstance()));
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * Constructor with a special intrinsic weapon
     *
     * @param name            the name of the Actor
     * @param displayChar     the character that will represent the Actor in the display
     * @param hitPoints       the Actor's starting hit points
     * @param enemyType       the enemy's type
     * @param intrinsicWeapon the enemy's special intrinsic weapon
     */
    public Enemy(String name, char displayChar, int hitPoints, EnemyType enemyType, IntrinsicWeapon intrinsicWeapon) {
        this(name, displayChar, hitPoints, enemyType);
        this.intrinsicWeapon = intrinsicWeapon;
    }

    /**
     * Constructor with a default weapon
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param enemyType   the enemy's type
     * @param weapon      the enemy's default weapon
     */
    public Enemy(String name, char displayChar, int hitPoints, EnemyType enemyType, WeaponItem weapon) {
        this(name, displayChar, hitPoints, enemyType);
        addWeaponToInventory(weapon);
    }

    /**
     * Constructor with special intrinsic weapon <b>and</b> default weapon
     *
     * @param name            the name of the Actor
     * @param displayChar     the character that will represent the Actor in the display
     * @param hitPoints       the Actor's starting hit points
     * @param enemyType       the enemy's type
     * @param intrinsicWeapon the enemy's special intrinsic weapo
     * @param weapon          the enemy's default weapon
     */
    public Enemy(String name, char displayChar, int hitPoints, EnemyType enemyType, IntrinsicWeapon intrinsicWeapon, WeaponItem weapon) {
        this(name, displayChar, hitPoints, enemyType);
        this.intrinsicWeapon = intrinsicWeapon;
        addWeaponToInventory(weapon);
    }


    /**
     * At each turn, the enemy will go through its behaviours, and select one to perform
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the action that the enemy will perform this turn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // At each turn, the enemy has a 10% chance of being despawned
        if (RandomNumberGenerator.getRandomInt(0, 100) <= 10) {
            return new DespawnAction();
        }
        // Iterate through the available behaviours, and get the first one that has an action
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            // Check whether an action was available from the behaviour
            if (action != null) return action;
        }
        // If no behaviour has an available action, the enemy does nothing
        return new DoNothingAction();
    }

    /**
     * Get the actions that can be done to the enemy, depending on the other entity
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions that are doable to this enemy
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Other actor attacks enemies
            // Check whether the actor has a non-intrinsic weapon
            if (otherActor.getWeaponInventory().isEmpty()) {
                actions.add(new AttackAction(this, direction));
            } else {
                actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(0)));
            }
        }
        return actions;
    }

    /**
     * Gets the enemy's intrinsic weapon
     *
     * @return the special intrinsic weapon if available; otherwise, the default Actor intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        if (intrinsicWeapon == null) return super.getIntrinsicWeapon();
        return intrinsicWeapon;
    }
}
