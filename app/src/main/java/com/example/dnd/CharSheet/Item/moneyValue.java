package com.example.dnd.CharSheet.Item;

public class moneyValue {
    //conversion vals
    public final int copperToSilver = 10;
    public final int silverToGold = 10;
    public final int goldToPlatinum = 10;

    public final int silverToElectrum = 5;
    public final int electrumtoGold = 2;


    public final int COPPER;
    public final int SILVER;
    public final int ELECTRUM;
    public final int GOLD;
    public final int PLATINUM;

    public moneyValue(int _copper, int _silver, int _electrum, int _gold, int _platinum){
        COPPER      = _copper;
        SILVER      = _silver;
        ELECTRUM    = _electrum;
        GOLD        = _gold;
        PLATINUM    = _platinum;
    }


}
