package com.example.dnd.CharSheet.characterInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbilitiesAndProficiencies {
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

    public int proficiencyBonus;

    //map of all the (base) proficiencies
    public Map<allProficiencies, Boolean> proficiencyMap = new HashMap<>();
    public Map<allProficiencies.ParentAbility, Integer> abilityLevelMap = new HashMap<>();



    //makes a proficiency set with no proficiencies
    public AbilitiesAndProficiencies(int _proficiencyBonus, int[] abilityLevels){
        for(allProficiencies value : allProficiencies.values()){
            proficiencyMap.put(value, false);
        }

        //TODO: add exceptions here to account for 'indexOutOfBounds' and not crash the whole app
        abilityLevelMap.put(allProficiencies.ParentAbility.STRENGTH, abilityLevels[0]);
        abilityLevelMap.put(allProficiencies.ParentAbility.DEXTERITY, abilityLevels[1]);
        abilityLevelMap.put(allProficiencies.ParentAbility.CONSTITUTION, abilityLevels[2]);
        abilityLevelMap.put(allProficiencies.ParentAbility.INTELLIGENCE, abilityLevels[3]);
        abilityLevelMap.put(allProficiencies.ParentAbility.WISDOM, abilityLevels[4]);
        abilityLevelMap.put(allProficiencies.ParentAbility.CHARISMA, abilityLevels[5]);

        proficiencyBonus = _proficiencyBonus;
    }

    // sets all given proficiencies to false. sets the ability scores to the given vals
    public AbilitiesAndProficiencies(int _proficiencyBonus, int _strLevel, int _dexLevel,
                                     int _conLevel, int _intLevel, int _wisLevel, int _chaLevel){
        for(allProficiencies value : allProficiencies.values()){
            proficiencyMap.put(value, false);
        }

        abilityLevelMap.put(allProficiencies.ParentAbility.STRENGTH, _strLevel);
        abilityLevelMap.put(allProficiencies.ParentAbility.DEXTERITY, _dexLevel);
        abilityLevelMap.put(allProficiencies.ParentAbility.CONSTITUTION, _conLevel);
        abilityLevelMap.put(allProficiencies.ParentAbility.INTELLIGENCE, _intLevel);
        abilityLevelMap.put(allProficiencies.ParentAbility.WISDOM, _wisLevel);
        abilityLevelMap.put(allProficiencies.ParentAbility.CHARISMA, _chaLevel);

        proficiencyBonus = _proficiencyBonus;
    }

    // sets all given proficiencies to true, the rest to false. sets the ability scores to the given vals
    public AbilitiesAndProficiencies(int _proficiencyBonus, List<allProficiencies> availableProficiencies,
                                     int _strLevel, int _dexLevel, int _conLevel, int _intLevel,
                                     int _wisLevel, int _chaLevel){
        for(allProficiencies value : allProficiencies.values()){
            if(availableProficiencies.contains(value)){
                proficiencyMap.put(value, true);
            }else {
                proficiencyMap.put(value, false);
            }
        }

        abilityLevelMap.put(allProficiencies.ParentAbility.STRENGTH, _strLevel);
        abilityLevelMap.put(allProficiencies.ParentAbility.DEXTERITY, _dexLevel);
        abilityLevelMap.put(allProficiencies.ParentAbility.CONSTITUTION, _conLevel);
        abilityLevelMap.put(allProficiencies.ParentAbility.INTELLIGENCE, _intLevel);
        abilityLevelMap.put(allProficiencies.ParentAbility.WISDOM, _wisLevel);
        abilityLevelMap.put(allProficiencies.ParentAbility.CHARISMA, _chaLevel);

        proficiencyBonus = _proficiencyBonus;
    }

    public int getSkillBonus(allProficiencies targetProficiency){
        int currentProficiencyBonus = (proficiencyMap.get(targetProficiency) ? proficiencyBonus : 0);
        int baseAbilityLevel = abilityLevelMap.get(targetProficiency.parentAbility);

        return (int) Math.floor(((baseAbilityLevel - 10)/ 2)) + currentProficiencyBonus;
    }

}
