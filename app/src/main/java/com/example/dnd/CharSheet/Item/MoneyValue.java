package com.example.dnd.CharSheet.Item;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MoneyValue implements Serializable {
    //conversion vals
    public final int copperToSilver = 10;
    public final int silverToGold = 10;
    public final int goldToPlatinum = 10;

    public final int silverToElectrum = 5;
    public final int electrumToGold = 2;


    public final int COPPER;
    public final int SILVER;
    public final int ELECTRUM;
    public final int GOLD;
    public final int PLATINUM;

    public final boolean USE_ELECTRUM;
    public final boolean USE_PLATINUM;

    public MoneyValue(@JsonProperty("COPPER") int _copper, @JsonProperty("SILVER") int _silver,
                      @JsonProperty("GOLD") int _gold, @JsonProperty("PLATINUM") int _platinum,
                      @JsonProperty("ELECTRUM") int _electrum, @JsonProperty("USE_PLATINUM") boolean _usePlatinum,
                      @JsonProperty("USE_ELECTRUM") boolean _useElectrum){
        COPPER      = _copper;
        SILVER      = _silver;
        ELECTRUM    = _electrum;
        GOLD        = _gold;
        PLATINUM    = _platinum;

        USE_ELECTRUM = _useElectrum;
        USE_PLATINUM = _usePlatinum;
    }

    public MoneyValue addMoney(int copperToAdd, int silverToAdd, int goldToAdd, int platinumToAdd, int electrumToAdd){
        int newCopper = COPPER + copperToAdd;
        int newSilver = SILVER + silverToAdd;
        int newGold = GOLD + goldToAdd;
        int newPlatinum = PLATINUM + platinumToAdd;
        int newElectrum = ELECTRUM + electrumToAdd;

        //Roll over the copper to silver
        newSilver += (int) (newCopper / copperToSilver);
        newCopper = newCopper % copperToSilver;

        //Roll over silver into platinum and platinum into gold if using electrum
        if(USE_ELECTRUM){
            newElectrum += (int) (newSilver / silverToElectrum);
            newSilver = newSilver % copperToSilver;

            newGold += (int) (newElectrum / electrumToGold);
            newElectrum = newElectrum % electrumToGold;
        }

        //Roll silver to gold if not using electrum
        else{
            newGold += (int) (newSilver / silverToGold);
            newSilver = newSilver % silverToGold;
        }

        //Roll gold to platinum if using platinum
        if(USE_PLATINUM){
            newPlatinum += (int) (newGold / goldToPlatinum);
            newGold = newGold % goldToPlatinum;
        }


        return new MoneyValue(newCopper, newSilver, newGold, newPlatinum, newElectrum, USE_PLATINUM, USE_ELECTRUM);
    }

    public MoneyValue removeMoney(int copperToRemove, int silverToRemove, int goldToRemove, int platinumToRemove, int electrumToRemove){
        int newCopper = COPPER - copperToRemove;
        int newSilver = SILVER - silverToRemove;
        int newGold = GOLD - goldToRemove;
        int newPlatinum = PLATINUM - platinumToRemove;
        int newElectrum = ELECTRUM - electrumToRemove;

        if(newCopper < 0){      // convert silver to copper to get copper out of negative
            int neededSilver = 1 + (int) (Math.abs(newCopper) / copperToSilver);
            newCopper += neededSilver * copperToSilver;
            newSilver -= neededSilver;
        }

        if(newSilver < 0){
            //fix negative silver with electrum
            if(USE_ELECTRUM){
                int neededElectrum = 1 + (int) (Math.abs(newSilver) / silverToElectrum);
                newSilver += neededElectrum * silverToElectrum;
                newElectrum -= neededElectrum;

                //fix negative electrum with gold
                if(newElectrum < 0){
                    int neededGold = 1 + (int) (Math.abs(newElectrum) / electrumToGold);
                    newElectrum += neededGold * electrumToGold;
                    newGold -= neededGold;
                }
            }

            //fix negative silver without electrum
            else{
                int neededGold = 1 + (int) (Math.abs(newSilver) / silverToGold);
                newSilver += neededGold * silverToGold;
                newGold -= neededGold;
            }
        }

        if(newGold < 0) {
            //fix negative gold with Platinum
            if(USE_PLATINUM){
                int neededPlatinum = 1 + (int) (Math.abs(newGold) / goldToPlatinum);
                newGold += neededPlatinum * goldToPlatinum;
                newPlatinum -= neededPlatinum;
            }
            //cant fix negative gold if we arent using platinum
        }

        if(USE_PLATINUM){
            if(newPlatinum < 0){
                //cant fix negative Platinum
            }
        }

        return new MoneyValue(newCopper, newSilver, newGold, newPlatinum, newElectrum, USE_PLATINUM, USE_ELECTRUM);
    }
}
