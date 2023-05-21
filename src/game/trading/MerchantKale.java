package game.trading;

import game.weapons.*;

/**
 * Class for the Merchant Kale
 * @see Trader
 */
public class MerchantKale extends Trader {
    /**
     * Constructor
     */
    public MerchantKale() {
        super("Kale", 'K');
        addBuyableItem(new Uchigatana());
        addBuyableItem(new GreatKnife());
        addBuyableItem(new Club());
        addSellableItem(new Uchigatana());
        addSellableItem(new GreatKnife());
        addSellableItem(new Club());
        addSellableItem(new Grossmesser());
        addBuyableItem(new Scimitar());
        addSellableItem(new Scimitar());
        addSellableItem(new RiversOfBlood());
    }
}
