package game;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.currency.RuneManager;

/**
 * An item representing Golden Runes.
 * It can be found scattered across the maps, picked up or dropped off by the player.
 * When consumed, it generates a random amount of runes between 200 and 10000.
 */
public class GoldenRunes extends Item {
    /**
     * Constructs a new instance of GoldenRunes.
     * Sets the name of the item as "GoldenRunes" and the display character as '*'.
     */
    public GoldenRunes() {
        super("GoldenRunes", '*', false);
    }

    /**
     * Performs the tick action for GoldenRunes.
     * When consumed, it generates a random amount of runes between 200 and 10,000.
     *
     * @param location The location where the GoldenRunes object is located.
     */
    @Override
    public void tick(Location location) {
        super.tick(location);

        // Randomly generate the amount of runes when consumed
        if (!location.contains(this))
            return;

        // Generate a random number between 200 and 10000
        int amount = (int) (Math.random() * 9801) + 200;
        RuneManager.getInstance().addRunes(amount);
        location.removeItem(this);
    }
}
