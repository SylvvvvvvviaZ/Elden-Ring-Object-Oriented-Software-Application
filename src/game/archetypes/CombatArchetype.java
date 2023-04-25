package game.archetypes;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;

import java.util.ArrayList;

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

        @Override
        public Character getHotKey() {
            return 'S';
        }

        @Override
        public String getName() {
            return "Samurai";
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

        @Override
        public Character getHotKey() {
            return 'B';
        }

        @Override
        public String getName() {
            return "Bandit";
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

        @Override
        public Character getHotKey() {
            return 'W';
        }

        @Override
        public String getName() {
            return "Wretch";
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

    /**
     * Get the archetype option's hotkey
     *
     * @return the hotkey for the menu
     */
    public abstract Character getHotKey();

    /**
     * Get the archetype's name to be displayed
     *
     * @return archetype name
     */
    public abstract String getName();

    public static CombatArchetype askForClass(Display display) {
        // Print out every archetype available
        for (CombatArchetype archetype : CombatArchetype.values()) {
            display.println(String.format("%s. %s", archetype.getHotKey(), archetype.getName()));
        }
        ArrayList<Character> archetypeOptions = new ArrayList<>();
        for (int i = 0; i < CombatArchetype.values().length; i++) {
            archetypeOptions.add(CombatArchetype.values()[i].getHotKey());
        }
        display.println("=== SELECT ONE ===");
        Character input = display.readChar();
        while (!archetypeOptions.contains(input)) {
            input = display.readChar();
        }
        // TODO: maybe improve this conascence
        switch (input) {
            case 'S' -> { return SAMURAI; }
            case 'B' -> { return BANDIT; }
            case 'W' -> { return WRETCH; }
        }
        return null;
    }
}
