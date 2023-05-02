package game.currency;

/**
 * Interface for Actors that reward currency
 *
 * @author dkon0020
 * @version 1.0
 */
public interface CurrencySource {
    /**
     * Returns the amount of currency to be rewarded
     *
     * @return some amount of currency
     */
    CurrencyItem rewardCurrency();
}
