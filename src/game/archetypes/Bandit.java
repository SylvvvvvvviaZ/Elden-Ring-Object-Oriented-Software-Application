package game.archetypes;

import game.weapons.GreatKnife;

/**
 * Bandit Combat Archetype
 * @author dkon0020
 * @version 1.0
 * @see CombatArchetypeClass
 */
public final class Bandit extends CombatArchetypeClass {
    /**
     * Constructor
     */
    public Bandit() {
        super(new GreatKnife(), 414);
    }

    @Override
    public Character getHotKey() {
        return 'B';
    }

    @Override
    public String getName() {
        return "Bandit";
    }
}
