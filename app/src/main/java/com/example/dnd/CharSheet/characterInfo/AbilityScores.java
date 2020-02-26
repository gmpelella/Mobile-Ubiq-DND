package com.example.dnd.CharSheet.characterInfo;

public class AbilityScores {
    public enum abilityScoreTypes{
        STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA
    }

    // Base Ability scores, might be useful
    private int baseStr;
    private int baseDex;
    private int baseCon;
    private int baseInt;
    private int baseWis;
    private int baseCha;

    // Ability scores after modifiers
    public int strScore;
    public int dexScore;
    public int conScore;
    public int intScore;
    public int wisScore;
    public int chaScore;

    // saving throws
    public boolean strSavingProficient;
    public boolean dexSavingProficient;
    public boolean conSavingProficient;
    public boolean intSavingProficient;
    public boolean wisSavingProficient;
    public boolean chaSavingProficient;

    public AbilityScores(int _strScore, int _dexScore, int _conScore, int _intScore, int _wisScore,
                         int _chaScore, boolean _strProficient, boolean _dexProficient,
                         boolean _conProficient, boolean _intProficient, boolean _wisProficient,
                         boolean _chaProficient) {
        strScore = baseStr = _strScore;
        dexScore = baseDex = _dexScore;
        conScore = baseCon = _conScore;
        intScore = baseInt = _intScore;
        wisScore = baseWis = _wisScore;
        chaScore = baseCha = _chaScore;

        strSavingProficient = _strProficient;
        dexSavingProficient = _dexProficient;
        conSavingProficient = _conProficient;
        intSavingProficient = _intProficient;
        wisSavingProficient = _wisProficient;
        chaSavingProficient = _chaProficient;
    }

    public AbilityScores(int[] _scores, boolean[] _proficiencies){
        strScore = baseStr = _scores[0];
        dexScore = baseDex = _scores[1];
        conScore = baseCon = _scores[2];
        intScore = baseInt = _scores[3];
        wisScore = baseWis = _scores[4];
        chaScore = baseCha = _scores[5];

        strSavingProficient = _proficiencies[0];
        dexSavingProficient = _proficiencies[1];
        conSavingProficient = _proficiencies[2];
        intSavingProficient = _proficiencies[3];
        wisSavingProficient = _proficiencies[4];
        chaSavingProficient = _proficiencies[5];
    }

    public int getAbilityModifier(abilityScoreTypes score){
        int selectedScore = 0;
        switch(score){
            case STRENGTH:
                selectedScore = strScore;
                break;
            case DEXTERITY:
                selectedScore = dexScore;
                break;
            case CONSTITUTION:
                selectedScore = conScore;
                break;
            case INTELLIGENCE:
                selectedScore = intScore;
                break;
            case WISDOM:
                selectedScore = wisScore;
                break;
            case CHARISMA:
                selectedScore = chaScore;
                break;
        }

        return (int) Math.floor(((selectedScore - 10)/ 2));
    }
}
