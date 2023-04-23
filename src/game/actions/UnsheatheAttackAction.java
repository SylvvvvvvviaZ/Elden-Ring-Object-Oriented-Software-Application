package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.ModifiedWeaponItem;

/**
 * Unsheathe weapon skill
 * @author dkon0020
 * @version 1.0
 * @see Action
 */
public class UnsheatheAttackAction extends Action {
    private final Actor target;
    private final String direction;
    private final WeaponItem weapon;

    /**
     * Constructor
     *
     * @param target    the Actor to attack
     * @param direction the direction where the attack should be performed (only
     *                  used for display purposes)
     * @param weapon    the weapon being used to attack
     */
    public UnsheatheAttackAction(Actor target, String direction, WeaponItem weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Executes the special attack action
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return message describing the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        WeaponItem modifiedWeaponitem = new ModifiedWeaponItem(weapon, weapon.damage() * 2, 60);
        return new AttackAction(target, direction, modifiedWeaponitem).execute(actor, map);
    }

    /**
     * Returns a description of the attack action for the menu
     *
     * @param actor The actor performing the action.
     * @return description for menu output
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s uses Unsheathe!", actor);
    }
}
