package game.interfaces;

import game.currency.CurrencyItem;

/**
 * Interface for Actors that reward currency
 * @author dkon0020
 * @version 1.0
 */
public interface CurrencySource {
    CurrencyItem rewardCurrency();
}
