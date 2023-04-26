package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.weapons.Weapon;

public enum SpecialAttackType {
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