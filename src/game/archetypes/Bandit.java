package game.archetypes;

import game.weapons.GreatKnife;

/**
 * Bandit Combat Archetype
 * @author dkon0020
 * @version 1.0
 * @see CombatArchetypeSealedClass
 */
public final class Bandit extends CombatArchetypeSealedClass {
    /**
     * Constructor
     */
    public Bandit() {
        super(new GreatKnife(), 414);
    }
}
