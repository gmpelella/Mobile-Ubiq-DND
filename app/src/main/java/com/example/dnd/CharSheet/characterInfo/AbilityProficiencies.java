package com.example.dnd.CharSheet.characterInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbilityProficiencies {
    public int proficiencyBonus;

    //TODO: maybe add armour and weapons proficiencies, tools maybe?
    public enum allProficiencies {
        //Strength Proficiencies
        STRENGTH (ParentAbility.STRENGTH),
        ATHLETICS (ParentAbility.STRENGTH),

        //Dex Proficiencies
        DEXTERITY (ParentAbility.DEXTERITY),
        ACROBATICS (ParentAbility.DEXTERITY),
        SLEIGHT_OF_HAND (ParentAbility.DEXTERITY),
        STEALTH (ParentAbility.DEXTERITY),

        // Con Proficiencies
        CONSTITUTION (ParentAbility.CONSTITUTION),

        // Int Proficiencies
        INTELLIGENCE (ParentAbility.INTELLIGENCE),
        ARACNA (ParentAbility.INTELLIGENCE),
        HISTORY (ParentAbility.INTELLIGENCE),
        INVESTIGATION (ParentAbility.INTELLIGENCE),
        NATURE (ParentAbility.INTELLIGENCE),
        RELIGION (ParentAbility.INTELLIGENCE),

        // Wis Proficiencies
        WISDOM (ParentAbility.WISDOM),
        ANIMAL_HANDLING (ParentAbility.WISDOM),
        INSIGHT (ParentAbility.WISDOM),
        MEDICINE (ParentAbility.WISDOM),
        PERCEPTION (ParentAbility.WISDOM),
        SURVIVAL (ParentAbility.WISDOM),

        // Cha Proficiencies
        CHARISMA (ParentAbility.CHARISMA),
        DECEPTION (ParentAbility.CHARISMA),
        INTIMIDATION (ParentAbility.CHARISMA),
        PERFORMANCE (ParentAbility.CHARISMA),
        PERSUASION (ParentAbility.CHARISMA);

        private ParentAbility parentAbility;

        allProficiencies(ParentAbility parentAbility) {
            this.parentAbility = parentAbility;
        }

        public ParentAbility getParentAbility() {
            return this.parentAbility;
        }

        public enum ParentAbility {
            STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA
        }
    }

    //map of all the (base) proficiencies
    public Map<allProficiencies, Boolean> proficiencyMap = new HashMap<>();
    public Map<allProficiencies.ParentAbility, Integer> abilityModifierMap = new HashMap<>();

    //makes a proficiency set with no proficiencies
    public AbilityProficiencies(int _proficiencyBonus, int[] _modifierArray){
        for(allProficiencies value : allProficiencies.values()){
            proficiencyMap.put(value, false);
        }


        proficiencyBonus = _proficiencyBonus;
    }

    // sets all given proficiencies to true, the rest to false.
    public AbilityProficiencies(List<allProficiencies> availableProficiencies, int _proficiencyBonus){
        for(allProficiencies value : allProficiencies.values()){
            if(availableProficiencies.contains(value)){
                proficiencyMap.put(value, true);
            }else {
                proficiencyMap.put(value, false);
            }
        }

        proficiencyBonus = _proficiencyBonus;
    }


    public int getSkillBonus(allProficiencies targetProficiency){


        return (proficiencyMap.get(targetProficiency) ? proficiencyBonus : 0);
    }
}
