package com.example.dnd.CharSheet;

import com.example.dnd.CharSheet.Item.*;
import com.example.dnd.CharSheet.characterInfo.*;

public class Character {
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
    private Spell[] reddiedSpells;
    private Spell[] spellList;


    //character info that changes on lvl up
    private String[] classes;
    private int level;



    //character info that rarely changes




    public Character(String _name, Race _race, String _background, String _allignment, String playerName,
                    int _level, String[] _classes){
        NAME = _name;
        RACE = _race;
        BACKGROUND = _background;
        ALLIGNMENT = _allignment;
        PLAYER_NAME = playerName;

        level = _level;
    }
}
