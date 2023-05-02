package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.*;
import game.attackactions.AttackAction;
import game.actions.DespawnAction;
import game.behaviours.*;
import game.currency.CurrencyItem;
import game.currency.CurrencySource;
import game.reset.ResetType;
import game.reset.Resettable;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all enemies that contains enemies' common properties
 *
 * @author dkon0020
 * @version 1.0
 * @see Actor
 */
public abstract class Enemy extends Actor implements CurrencySource, Resettable {
    /**
     * Behaviours of the enemy are used to execute AI-like operations
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();
    /**
     * The enemy's special intrinsic weapon (if any)
     */
    private IntrinsicWeapon intrinsicWeapon;

    /**
     * Get the chance of the enemy spawning
     *
     * @return spawn chance of enemy
     */
    public abstract int getSpawnChance();

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
        this.behaviours.put(1, new DespawnBehaviour(10));
        this.behaviours.put(997, new AttackBehaviour());
        // Follow behaviour will slot into 998 when a player instance is captured
        this.behaviours.put(999, new WanderBehaviour());
        // Insert death reward to inventory
        if (rewardCurrency() != null) addItemToInventory(rewardCurrency());
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
            // If a/the player is close by, "capture" the player's instance to be used for FollowBehaviour
            if (!hasCapability(Status.UNMOVABLE)) behaviours.put(998, new FollowBehaviour(otherActor));
            // Other actor attacks enemies
            // Check whether the actor has a non-intrinsic weapon
            for (WeaponItem weaponItem : otherActor.getWeaponInventory()) {
                actions.add(new AttackAction(this, direction, weaponItem));
                if (weaponItem.getSkill(otherActor) != null) {
                    actions.add(weaponItem.getSkill(otherActor));
                }
                if (weaponItem.getSkill(this, direction) != null) {
                    actions.add(weaponItem.getSkill(this, direction));
                }
                actions.add(new AttackAction(this, direction));
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

    /**
     * Enemies will drop a certain currency upon death
     * <br/>
     * By default, no award is given.
     *
     * @return the amount of currency to be awarded to the player
     */
    @Override
    public CurrencyItem rewardCurrency() {
        return null;
    }

    /**
     * Enemies despawn from the game map upon reset by default
     *
     * @param resetType the type of reset being performed
     * @param gameMap   the game map
     */
    @Override
    public void reset(ResetType resetType, GameMap gameMap) {
        new DespawnAction().execute(this, gameMap);
    }
}
