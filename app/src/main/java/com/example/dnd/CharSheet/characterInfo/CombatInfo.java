package com.example.dnd.CharSheet.characterInfo;

public class CombatInfo {
    private int initiative;
    private int[] speed;
    private int armourClass;

    private int maxHP;
    private int currHP;
    private int tempHP;
    private int[] hitDice;

    private int deathSavesSuccess;
    private int deathSaveFailure;

    public CombatInfo(int _initiative, int[] _speed, int _armourClass, int _maxHP, int _currHP,
                      int _temp, int[] _hitDice, int _deathSavesSuccess, int _deathSaveFailure){
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