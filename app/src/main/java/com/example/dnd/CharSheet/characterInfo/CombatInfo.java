package com.example.dnd.CharSheet.characterInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CombatInfo implements Serializable {
    public int initiative;
    public int[] speed;
    public int armourClass;

    public int maxHP;
    public int currHP;
    public int tempHP;
    public int[] hitDice;

    public int deathSavesSuccess;
    public int deathSaveFailure;

    public CombatInfo(@JsonProperty("initiative") int _initiative, @JsonProperty("speed") int[] _speed,
                      @JsonProperty("armourClass") int _armourClass, @JsonProperty("maxHP") int _maxHP,
                      @JsonProperty("currHP") int _currHP, @JsonProperty("tempHP") int _temp,
                      @JsonProperty("hitDice") int[] _hitDice, @JsonProperty("deathSavesSuccess") int _deathSavesSuccess,
                      @JsonProperty("deathSavesFailure") int _deathSaveFailure){
        initiative = _initiative;
        speed = _speed;
        armourClass = _armourClass;
        maxHP = _maxHP;
        currHP = _currHP;
        tempHP = _temp;
        hitDice = _hitDice;
        deathSavesSuccess = _deathSavesSuccess;
        deathSaveFailure = _deathSaveFailure;
    }

    @JsonIgnore
    public int getFirstSpeed() {return speed[0];}
}