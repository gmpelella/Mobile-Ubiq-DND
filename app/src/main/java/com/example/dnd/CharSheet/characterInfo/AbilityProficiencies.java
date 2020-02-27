package com.example.dnd.CharSheet.characterInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbilityProficiencies {

    //TODO: maybe add armour and weapons proficiencies, tools maybe?
    public enum allProficiencies{
        STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA,  /* Ability Scores */
        ATHLETICS,                                                          /* Str */
        ACROBATICS, SLEIGHT_OF_HAND, STEALTH,                               /* Dex */
                                                                            /* Con */
        ARACNA, HISTORY, INVESTIGATION, NATURE, RELIGION,                   /* Int */
        ANIMAL_HANDLING, INSIGHT, MEDICINE, PERCEPTION, SURVIVAL,           /* Wis */
        DECEPTION, INTIMIDATION, PERFORMANCE, PERSUASION                    /* Cha */
    }

    //map of all the (base) proficiencies
    public Map<allProficiencies, Boolean> proficiencyMap = new HashMap<>();


    //makes a proficiency set with no proficiencies
    public AbilityProficiencies(){
        for(allProficiencies value : allProficiencies.values()){
            proficiencyMap.put(value, false);
        }
    }

    // sets all given proficiencies to true, the rest to false.
    public AbilityProficiencies(List<allProficiencies> availableProficiencies){
        for(allProficiencies value : allProficiencies.values()){
            if(availableProficiencies.contains(value)){
                proficiencyMap.put(value, true);
            }else {
                proficiencyMap.put(value, false);
            }
        }
    }
}
