package game;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.HashMap;

/**
 * Singleton for handling entities in the game holding currency/currencies
 */
public class CurrencyManager {
    /**
     * Instance of the Currency Manager
     */
    private static CurrencyManager instance;
    private final HashMap<Actor, HashMap<Class<? extends CurrencyItem>, Integer>> currencyRecord;

    /**
     * Gets an instance of Currency Manager
     *
     * @return instance of Currency Manager
     */
    public static CurrencyManager getInstance() {
        if (instance == null) instance = new CurrencyManager();
        return instance;
    }

    /**
     * Constructor
     */
    private CurrencyManager() {
        currencyRecord = new HashMap<>();
    }

    /**
     * Checks whether the actor has enough of a currency in their balance
     * @param actor the actor whose balance to check
     * @param currencyItem the currency and value to check
     * @return true if the actor has enough of that currency in their balance; false otherwise
     */
    public boolean hasSufficientBalance(Actor actor, CurrencyItem currencyItem) {
        return currencyRecord.get(actor).get(currencyItem.getClass()) >= currencyItem.getValue();
    }

    /**
     * Adds value of the given currency for the given actor
     *
     * @param actor        the actor whose balance to update
     * @param currencyItem the currency item to add
     */
    public void addMoney(Actor actor, CurrencyItem currencyItem) {
        if (currencyRecord.get(actor).containsKey(currencyItem.getClass())) {
            // If actor has this currency item, update the balance
            currencyRecord.get(actor).put(
                    currencyItem.getClass(),
                    currencyRecord.get(actor).get(currencyItem.getClass()) + currencyItem.getValue()
            );
        } else {
            // If the actor does not have this currency item, make a new entry for it
            currencyRecord.get(actor).put(currencyItem.getClass(), currencyItem.getValue());
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
        if (currencyRecord.get(actor).containsKey(currencyItem.getClass())) {
            if (currencyRecord.get(actor).get(currencyItem.getClass()) < currencyItem.getValue()) return false;
            currencyRecord.get(actor).put(
                    currencyItem.getClass(),
                    currencyRecord.get(actor).get(currencyItem.getClass()) - currencyItem.getValue()
            );
            return true;
        }
        return false;
    }

}
