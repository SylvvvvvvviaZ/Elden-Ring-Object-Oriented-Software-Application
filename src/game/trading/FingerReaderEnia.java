package game.trading;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.currency.CurrencyItem;
import game.currency.Rune;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;

/**
 * Class for the Finger Reader Enia E trader.
 * Accepts the Remembrance of the Grafted from the player to be exchanged for either the Axe of Godrick or Grafted Dragon.
 * The player cannot purchase weapons from this trader, but they can still sell anything that is sellable to this trader.
 */
public class FingerReaderEnia extends Trader {
    /**
     * Constructor
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia E", 'E');
    }

    /**
     * Allows the trader to exchange the Remembrance of the Grafted for either the Axe of Godrick or Grafted Dragon.
     *
     * @param remembrance the Remembrance of the Grafted item
     */
    public <RemembranceOfTheGrafted> void exchangeRemembrance(RemembranceOfTheGrafted remembrance) {
        if (remembrance == null)
            return;

        // Remove the Remembrance of the Grafted from the player's inventory
        removeTradeItem((Item) remembrance);

        // Determine which weapon to give based on player's choice
        WeaponItem weaponToGive;
        if (Math.random() < 0.5)
            weaponToGive = new AxeOfGodrick();
        else
            weaponToGive = new GraftedDragon();

        // Add the chosen weapon to the trader's inventory
        addSellableItem((Sellable) weaponToGive);
    }
}
