package game;

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
    SAMURAI(new Uchigatana(), 455, 'S', "Samurai"),
    BANDIT(new GreatKnife(), 414, 'B', "Bandit"),
    WRETCH(new Club(), 414, 'W', "Wretch");

    private final WeaponItem startingWeapon;
    private final int startingHitPoints;
    private final Character hotKey;
    private final String name;

    /**
     * Constructor
     *
     * @param startingWeapon    the starting weapon
     * @param startingHitPoints the starting hit points
     * @param hotKey            the hotkey for menu selection
     * @param name              the name of the archetype
     */
    CombatArchetype(
            WeaponItem startingWeapon,
            int startingHitPoints,
            Character hotKey,
            String name
    ) {
        this.startingWeapon = startingWeapon;
        this.startingHitPoints = startingHitPoints;
        this.hotKey = hotKey;
        this.name = name;
    }

    /**
     * Get the archetype's starting weapon
     *
     * @return starting weapon
     */
    public WeaponItem getStartingWeapon() {
        return startingWeapon;
    }

    /**
     * Get the archetype's starting hit points
     *
     * @return starting hit points
     */
    public int getStartingHitPoints() {
        return startingHitPoints;
    }

    /**
     * Get the archetype's hot key
     *
     * @return the hotkey
     */
    public Character getHotKey() {
        return hotKey;
    }

    /**
     * Get the archetype's name
     *
     * @return the name of the archetype
     */
    public String getName() {
        return name;
    }
}
