package game.traders;

import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Grossmesser;
import game.weapons.Uchigatana;

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
    }
}
