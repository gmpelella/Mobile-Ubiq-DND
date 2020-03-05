package com.example.dnd.CharSheet;

import com.example.dnd.CharSheet.Item.*;
import com.example.dnd.CharSheet.characterInfo.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

public class Character implements Serializable {
    //Character info that can be looked at but not changed
    public final String NAME;
    @JsonSerialize(as = Race.class)
    public final Race RACE;
    public final String BACKGROUND;
    public final String ALLIGNMENT;
    public final String PLAYER_NAME;

    //character info that can change randomly
    public int experience;
    public CombatInfo combatInfo;


    public Weapon[] weapons;
    public Spell[] readiedSpells; //spelling fix
    public Spell[] spellList;


    //character info that changes on lvl up
    public String[] classes;
    public int level;
    public AbilitiesAndProficiencies abilityScores;


    //character info that rarely changes



    public Character(@JsonProperty("NAME") String _name, @JsonProperty("RACE") Race _race,
                     @JsonProperty("BACKGROUND") String _background, @JsonProperty("ALLIGNMENT") String _allignment,
                     @JsonProperty("PLAYER_NAME") String playerName, @JsonProperty("level") int _level,
                     @JsonProperty("classes") String[] _classes, @JsonProperty("experience") int _experience,
                     @JsonProperty("combatInfo") CombatInfo _combatInfo, @JsonProperty("weapons") Weapon[] _weapons,
                     @JsonProperty("spellList") Spell[] _spells, @JsonProperty("readiedSpels") Spell[] _readiedSpells,
                     @JsonProperty("abilityScores") AbilitiesAndProficiencies _abilities){
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

    @JsonIgnore
    public String getFirstClass(){
        return classes[0];
    }

    public int getLevel(){
        return level;
    }
}
