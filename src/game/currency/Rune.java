package game.currency;

import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetType;
import game.Resettable;

/**
 * Class for the Runes currency
 * @author dkon0020
 * @version 0.0
 * @see CurrencyItem
 */
public class Rune extends CurrencyItem {
    public Rune(int value) {
        super("Rune", '$', value);
    }
}
