package game.archetypes;

import game.weapons.Club;

/**
 * Wretch Combat Archetype
 * @author dkon0020
 * @version 1.0
 * @see CombatArchetype
 */
public final class Wretch extends CombatArchetype {
    /**
     * Constructor
     */
    public Wretch() {
        super(new Club(), 414);
    }

    @Override
    public Character getHotKey() {
        return 'W';
    }

    @Override
    public String getName() {
        return "Wretch";
    }
}
