package game.traders;

import game.currency.Rune;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Grossmesser;
import game.weapons.Uchigatana;

public class MerchantKale extends Trader {
    public MerchantKale() {
        super("Kale", 'K');
        addBuyableItem(new Uchigatana(), new Rune(5000));
        addBuyableItem(new GreatKnife(), new Rune(3500));
        addBuyableItem(new Club(), new Rune(600));
        addSellableItem(new Uchigatana(), new Rune(500));
        addSellableItem(new GreatKnife(), new Rune(350));
        addSellableItem(new Club(), new Rune(100));
        addSellableItem(new Grossmesser(), new Rune(100));
    }
}
