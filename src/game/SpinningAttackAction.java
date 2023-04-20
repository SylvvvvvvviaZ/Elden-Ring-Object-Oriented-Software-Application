package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AreaAttackAction;

/**
 * A special action that allows an actor to perform an area attack on multiple targets around them using a weapon.
 */
public class SpinningAttackAction extends AreaAttackAction {

    /**
    * Constructor for the SpinningAttack class.
    * @param weapon - the weapon used for the spinning attack
    */
    public SpinningAttackAction(Weapon weapon) {
        super(weapon);
    }

    /**
     * Returns a string describing the Spinning Attack action.
     * @param actor The actor performing the action.
     * @return A string describing the Spinning Attack action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s executes Spinning Attack!", actor.toString());
    }   
}
