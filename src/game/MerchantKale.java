package game;

public class MerchantKale extends Trader {
    public MerchantKale() {
        super("Kale", 'K');
        addTradeItem(new Uchigatana(), new Rune(5000));
        
    }
}
