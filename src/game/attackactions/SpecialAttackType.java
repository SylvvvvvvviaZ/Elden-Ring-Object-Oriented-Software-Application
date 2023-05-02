package game.attackactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * Enumeration of special attack types
 * @author dkon0020
 * @version 1.0
 */
public enum SpecialAttackType {
    /**
     * Slam attack
     */
    SLAM {
        @Override
        public Action getSpecialAttack(Weapon weapon) {
            return new SlamAttackAction(weapon);
        }
    };

    /**
     * Get a freshly instantiated special attack action
     *
     * @param weapon the weapon used with the attack action
     * @return special attack action
     */
    public abstract Action getSpecialAttack(Weapon weapon);
}