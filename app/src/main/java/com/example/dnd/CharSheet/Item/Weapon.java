package com.example.dnd.CharSheet.Item;



public class Weapon {
    public enum damageTypes{
        ACID, BLUDGEONING, COLD, FIRE, FORCE, LIGHTNING, NECROTIC, PIERCING, POISON,
        PSYCHIC, RADIANT, SLASHING, THUNDER;
    }

    public enum weaponType{
        MELEE, RANGED;
    }

    public enum weaponProperties{
        AMMUNITION, FINESSE, HEAVY, LIGHT, LOADING, RANGE, REACH, SPECIAL, THROWN,
        TWO_HANDED, VERSATILE;
    }

    private final String NAME;
    private final damageTypes DAMAGE_TYPE;
    private final weaponProperties[] PROPERTIES;
    private final int[] DAMAGE_DICE;
    private final moneyValue PRICE;
    private final int WEIGHT;



    Weapon(String _name, damageTypes _damageType, int[] _damageDice, moneyValue _price,
           weaponProperties[] _properties, int _weight){
        NAME        = _name;
        DAMAGE_TYPE = _damageType;
        DAMAGE_DICE = _damageDice;
        PRICE       = _price;
        PROPERTIES  = _properties;
        WEIGHT      = _weight;
    }
}
