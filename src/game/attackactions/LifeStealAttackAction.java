package game.attackactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.weapons.ModifiedWeaponItem;

import static java.lang.Math.ceil;

/**
 * Corpse Piler weapon skill
 * @author akya0002
 * @version 1.0
 * @see Action
 */
public class LifeStealAttackAction extends Action {
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
    public LifeStealAttackAction(Actor target, String direction, WeaponItem weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Attacks the target, and heals the weapon holder with a fraction of damage dealt
     * Attack has increased damage when done by player.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return message describing the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        int dmg = (int) ceil(weapon.damage()*1.5);
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            dmg = (int) ceil(weapon.damage()*2);
        }
        actor.heal((int) ceil(weapon.damage()*0.1));
        WeaponItem modifiedWeaponitem = new ModifiedWeaponItem(weapon, dmg, 80);
        result += new AttackAction(target, direction, modifiedWeaponitem).execute(actor, map);

        return result;
    }

    /**
     * Returns a description of the attack action for the menu
     *
     * @param actor The actor performing the action.
     * @return description for menu output
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s attacks %s using LifeSteal at %s with %s", actor, target, direction, (weapon != null ? weapon : "Intrinsic Weapon"));
    }
}
