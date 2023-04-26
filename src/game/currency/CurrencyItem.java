package game.currency;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetType;
import game.Resettable;
import game.Status;
import game.actions.PickUpCurrencyAction;

import java.util.Currency;

/**
 * Item for currencies
 *
 * @author dkon0020
 * @version 0.0
 * @see Item
 */
public abstract class CurrencyItem extends Item implements Resettable {
    private final String name;
    private int value;
    private Location location;

    /**
     * Constructor
     *
     * @param name        name of the currency
     * @param displayChar the symbol for the currency
     * @param value       current value of the currency
     */
    public CurrencyItem(String name, Character displayChar, int value) {
        super(name, displayChar, true);
        this.name = name;
        this.value = value;
        addCapability(Status.DROP_ON_PLAYER_ATTACK_ONLY);
        addCapability(Status.IMMEDIATE_PICK_UP);
    }

    /**
     * Gets the name of the currency
     *
     * @return currency's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the currency's current value
     *
     * @return currency value
     */
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s (value: %d)", name, value);
    }

    /**
     * Add a certain amount of value to the currency item
     *
     * @param value the amount to add
     */
    public void addValue(int value) {
        this.value += value;
    }

    /**
     * Remove a certain amount of value from the currency item
     * <br/>
     * If the amount to remove exceeds the value of the currency item, it will go into negative.
     *
     * @param value the amount to remove
     */
    public void removeValue(int value) {
        this.value -= value;
    }

    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        return new PickUpCurrencyAction(this);
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        location = currentLocation;
    }

    /**
     * If the game is reset due to player death, the money should be removed from the ground
     *
     * @param resetType the type of reset
     * @param gameMap   the game map
     */
    @Override
    public void reset(ResetType resetType, GameMap gameMap) {
        if (resetType == ResetType.RESET_ON_DEATH) {
            // Remove the item from the ground if its location is known
            if (location != null) {
                location.removeItem(this);
                return;
            }
            // Otherwise, try to get location of this item to remove it
            for (int x = gameMap.getXRange().min(); x < gameMap.getXRange().max() + 1; x++) {
                for (int y = gameMap.getYRange().min(); y < gameMap.getYRange().max() + 1; y++) {
                    Location location = gameMap.at(x, y);
                    if (location.getItems().contains(this)) {
                        location.removeItem(this);
                        return;
                    }
                }
            }
        }
    }
}
