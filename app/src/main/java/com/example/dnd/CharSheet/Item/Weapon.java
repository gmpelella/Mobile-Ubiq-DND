package com.example.dnd.CharSheet.Item;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Weapon implements Serializable {
    public enum damageTypes {
        ACID, BLUDGEONING, COLD, FIRE, FORCE, LIGHTNING, NECROTIC, PIERCING, POISON,
        PSYCHIC, RADIANT, SLASHING, THUNDER
    }

    public enum weaponType{
        MELEE, RANGED
    }

    public enum weaponProperties{
        AMMUNITION, FINESSE, HEAVY, LIGHT, LOADING, RANGE, REACH, SPECIAL, THROWN,
        TWO_HANDED, VERSATILE
    }

    private final String NAME;
    private final damageTypes DAMAGE_TYPE;
    private final weaponProperties[] PROPERTIES;
    private final int[] DAMAGE_DICE;
    private final MoneyValue PRICE;
    private final int WEIGHT;



    public Weapon(@JsonProperty("name") String _name, @JsonProperty("DAMAGE_TYPE") damageTypes _damageType,
                  @JsonProperty("DAMAGE_DICE") int[] _damageDice, @JsonProperty("PRICE") MoneyValue _price,
                  @JsonProperty("PROPERTIES") weaponProperties[] _properties, @JsonProperty("WEIGHT") int _weight){
        NAME        = _name;
        DAMAGE_TYPE = _damageType;
        DAMAGE_DICE = _damageDice;
        PRICE       = _price;
        PROPERTIES  = _properties;
        WEIGHT      = _weight;
    }
}
