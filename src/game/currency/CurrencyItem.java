package game.currency;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import game.actions.PickUpCurrencyAction;

/**
 * Item for currencies
 * @author dkon0020
 * @version 0.0
 * @see Item
 */
public abstract class CurrencyItem extends Item {
    private final String name;
    private int value;

    /**
     * Constructor
     * @param name name of the currency
     * @param displayChar the symbol for the currency
     * @param value current value of the currency
     */
    public CurrencyItem(String name, Character displayChar, int value) {
        super(name, displayChar, true);
        this.name = name;
        this.value = value;
    }

    /**
     * Gets the name of the currency
     * @return currency's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the currency's current value
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
     * @param value the amount to add
     */
    public void addValue(int value) {
        this.value += value;
    }

    /**
     * Remove a certain amount of value from the currency item
     * <br/>
     * If the amount to remove exceeds the value of the currency item, it will go into negative.
     * @param value the amount to remove
     */
    public void removeValue(int value) {
        this.value -= value;
    }

    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        return new PickUpCurrencyAction(this);
    }
}

