package com.example.dnd.CharSheet.characterInfo.Proficiencies;

public class ChaProficiencies extends AbilityProficiencies {
    public boolean deceptionProficiency;
    public boolean intimidationProficiency;
    public boolean performanceProficiency;
    public boolean persuasionProficiency;

    public ChaProficiencies(boolean _abilityProficient, boolean _deceptionProficiency,
                            boolean _intimidationProficiency, boolean _performanceProficiency,
                            boolean _persuasionProficiency){
        abilityProficient = _abilityProficient;
        deceptionProficiency = _deceptionProficiency;
        intimidationProficiency = _intimidationProficiency;
        performanceProficiency = _performanceProficiency;
        persuasionProficiency = _persuasionProficiency;

        allProficiencies = new boolean[] {abilityProficient, deceptionProficiency,
                intimidationProficiency, performanceProficiency, persuasionProficiency};
    }
}
