package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.currency.CurrencyItem;
import game.currency.Rune;

import java.util.HashMap;

/**
 * Singleton for handling entities in the game holding currency/currencies
 */
public class RuneManager /* implements Resettable */ {
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
        currencyRecord.put(actor, currencyItem.getValue());
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

    public void resetActor(Actor actor, Location lastLocation) {
        if (!currencyRecord.containsKey(actor)) return; // actor has no money :(
        CurrencyItem runes = new Rune(currencyRecord.get(actor));
        currencyRecord.put(actor, 0);
        ResetManager.getInstance().registerResettable(runes);
        lastLocation.addItem(runes);
    }

//    @Override
//    public void reset(ResetType resetType, GameMap gameMap) {
//        if (resetType == ResetType.RESET_ON_DEATH) {
//            // Player has died
//            currencyRecord.forEach( ((actor, quantity) -> {
//                if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
//                    // Their monies should be reset
//                    // Drop all their currencies
//                    // TODO: Drop runes in last-turn location
//                    new Rune(quantity).getDropAction(actor).execute(actor, gameMap);
//                }
//            }));
//        }
//    }
}
