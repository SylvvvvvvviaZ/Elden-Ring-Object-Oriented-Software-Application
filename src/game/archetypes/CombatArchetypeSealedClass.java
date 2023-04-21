package game.archetypes;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Base class for Combat Archetype definitions
 *
 * @author dkon0020
 * @version 1.0
 */
public abstract sealed class CombatArchetypeSealedClass permits Samurai, Bandit, Wretch {
    /**
     * The weapon that the player starts off with
     */
    private final WeaponItem startingWeapon;
    /**
     * The number of hit points that the player starts off with
     */
    private final int startingHitPoints;

    /**
     * Constructor
     *
     * @param startingWeapon the weapon that the player starts off with
     * @param startingHitPoints the number of hit points that the player starts off with
     */
    public CombatArchetypeSealedClass(WeaponItem startingWeapon, int startingHitPoints) {
        this.startingWeapon = startingWeapon;
        this.startingHitPoints = startingHitPoints;
    }

    /**
     * Gets the weapon that the player starts off with
     * @return the weapon that the player starts off with
     */
    public WeaponItem getStartingWeapon() {
        return startingWeapon;
    }

    /**
     * Gets the number of hit points that the player starts off with
     * @return the number of hit points that the player starts off with
     */
    public int getStartingHitPoints() {
        return startingHitPoints;
    }
}
