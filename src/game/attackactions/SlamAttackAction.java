package game.attackactions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.attackactions.AreaAttackAction;

/**
 * Special attack method used by Crustacean-type enemies
 */
public class SlamAttackAction extends AreaAttackAction {
    /**
     * Instantiates the special attack with the weapon
     *
     * @param weapon the weapon to be used for the attack
     */
    public SlamAttackAction(Weapon weapon) {
        super(weapon);
    }

    /**
     * Generates a message to be displayed to the console for the attack
     *
     * @return string message for the attack
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s executes Slam Attack!", actor.toString());
    }
}
