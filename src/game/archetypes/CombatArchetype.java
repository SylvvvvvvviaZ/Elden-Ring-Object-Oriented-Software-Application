package game.archetypes;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;

/**
 * Enumeration implementation of the Combat Archetypes
 *
 * @author dkon0020
 * @version 1.0
 */
public enum CombatArchetype {
    SAMURAI {
        @Override
        public WeaponItem getStartingWeapon() {
            return new Uchigatana();
        }

        @Override
        public int getStartingHitPoints() {
            return 455;
        }
    },
    BANDIT {
        @Override
        public WeaponItem getStartingWeapon() {
            return new GreatKnife();
        }

        @Override
        public int getStartingHitPoints() {
            return 414;
        }
    },
    WRETCH {
        @Override
        public WeaponItem getStartingWeapon() {
            return new Club();
        }

        @Override
        public int getStartingHitPoints() {
            return 414;
        }
    };

    /**
     * Get the player's starting weapon item
     *
     * @return starting weapon item
     */
    public abstract WeaponItem getStartingWeapon();

    /**
     * Get the player's starting hit points
     *
     * @return starting hit points
     */
    public abstract int getStartingHitPoints();
}
