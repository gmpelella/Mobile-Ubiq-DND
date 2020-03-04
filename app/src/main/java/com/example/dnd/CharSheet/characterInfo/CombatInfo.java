package com.example.dnd.CharSheet.characterInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CombatInfo implements Serializable {
    private int initiative;
    private int[] speed;
    private int armourClass;

    private int maxHP;
    private int currHP;
    private int tempHP;
    private int[] hitDice;

    private int deathSavesSuccess;
    private int deathSaveFailure;

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
}