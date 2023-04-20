package game.archetypes;

import game.weapons.Uchigatana;

/**
 * Samurai Combat Archetype
 * @author dkon0020
 * @version 1.0
 * @see CombatArchetypeSealedClass
 */
public final class Samurai extends CombatArchetypeSealedClass {
    /**
     * Constructor
     */
    public Samurai() {
        super(new Uchigatana(), 455);
    }
}
