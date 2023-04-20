package game.archetypes;

import game.weapons.Club;

/**
 * Wretch Combat Archetype
 * @author dkon0020
 * @version 1.0
 * @see CombatArchetypeSealedClass
 */
public final class Wretch extends CombatArchetypeSealedClass {
    /**
     * Constructor
     */
    public Wretch() {
        super(new Club(), 414);
    }
}
