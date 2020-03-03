package com.example.dnd.CharSheet;

import com.example.dnd.CharSheet.Item.*;
import com.example.dnd.CharSheet.characterInfo.*;

import java.io.Serializable;

public class Character implements Serializable {
    //Character info that can be looked at but not changed
    public final String NAME;
    public final Race RACE;
    public final String BACKGROUND;
    public final String ALLIGNMENT;
    public final String PLAYER_NAME;

    //character info that can change randomly
    private int experience;
    private CombatInfo combatInfo;


    private Weapon[] weapons;
    private Spell[] readiedSpells; //spelling fix
    private Spell[] spellList;


    //character info that changes on lvl up
    private String[] classes;
    private int level;
    private AbilitiesAndProficiencies abilityScores;


    //character info that rarely changes



    public Character(String _name, Race _race, String _background, String _allignment, String playerName,
                    int _level, String[] _classes, int _experience, CombatInfo _combatInfo, Weapon[] _weapons,
                     Spell[] _spells, Spell[] _readiedSpells, AbilitiesAndProficiencies _abilities){
        NAME = _name;
        RACE = _race;
        BACKGROUND = _background;
        ALLIGNMENT = _allignment;
        PLAYER_NAME = playerName;

        level = _level;
        classes = _classes;

        experience = _experience;
        combatInfo = _combatInfo;
        weapons = _weapons;
        spellList = _spells;
        readiedSpells = _readiedSpells;
        abilityScores = _abilities;
    }
}
