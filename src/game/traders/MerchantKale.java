package game.traders;

import game.weapons.*;

public class MerchantKale extends Trader {
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
    }
}
