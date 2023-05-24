package game.currency;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.ResetManager;

import java.util.HashMap;

/**
 * Singleton for handling entities in the game holding currency/currencies
 */
public class RuneManager {
    /**
     * Instance of the Currency Manager
     */
    private static RuneManager instance;
    /**
     * Record of actors' currency holdings
     */
    private final HashMap<Actor, Integer> currencyRecord;

    /**
     * Gets an instance of Currency Manager
     *
     * @return instance of Currency Manager
     */
    public static RuneManager getInstance() {
        if (instance == null) instance = new RuneManager();
        return instance;
    }

    /**
     * Constructor
     */
    private RuneManager() {
        currencyRecord = new HashMap<>();
    }

    /**
     * Gets the Rune balance for an actor
     *
     * @param actor the actor whose balance to check
     * @return a quantity of Runes, or 0 if the actor has never held Runes
     */
    public int getBalance(Actor actor) {
        if (!currencyRecord.containsKey(actor)) return 0;
        return currencyRecord.get(actor);
    }

    /**
     * Checks whether the actor has enough of a currency in their balance
     *
     * @param actor        the actor whose balance to check
     * @param currencyItem the currency and value to check
     * @return true if the actor has enough of that currency in their balance; false otherwise
     */
    public boolean hasSufficientBalance(Actor actor, CurrencyItem currencyItem) {
        return currencyRecord.get(actor) >= currencyItem.getValue();
    }

    /**
     * Adds value of the given currency for the given actor
     *
     * @param actor        the actor whose balance to update
     * @param currencyItem the currency item to add
     */
    public void addMoney(Actor actor, CurrencyItem currencyItem) {
        if (currencyRecord.containsKey(actor)) {
            currencyRecord.put(actor, currencyRecord.get(actor) + currencyItem.getValue());
        } else {
            currencyRecord.put(actor, currencyItem.getValue());
        }
    }

    /**
     * Removes value of the given currency from the given actor
     * <br/>
     * If the balance is insufficient to cover the subtraction, it will return false.
     *
     * @param actor        the actor whose balance to update
     * @param currencyItem the currency item to remove
     * @return true if the actor's balance has been updated, false if the actor does not hold this currency item or balance is insufficient
     */
    public boolean removeMoney(Actor actor, CurrencyItem currencyItem) {
        if (!currencyRecord.containsKey(actor)) return false;
        if (currencyRecord.get(actor) < currencyItem.getValue()) return false;
        currencyRecord.put(actor, currencyRecord.get(actor) - currencyItem.getValue());
        return true;
    }

    /**
     * Resets the currency holdings for an actor (drops currency on the ground)
     *
     * @param actor        the actor whose currency to reset
     * @param lastLocation the last location of the actor (where the currency will be dropped)
     */
    public void resetActor(Actor actor, Location lastLocation) {
        if (!currencyRecord.containsKey(actor) || currencyRecord.get(actor) == 0) return; // actor has no money :(
        CurrencyItem runes = new Rune(currencyRecord.get(actor));
        currencyRecord.put(actor, 0);
        ResetManager.getInstance().registerResettable(runes);
        lastLocation.addItem(runes);
    }

    public void addRunes(int amount) {
    }
}
