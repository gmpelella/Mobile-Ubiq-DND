package com.example.dnd.CharSheet.characterInfo;

//TODO: maybe move this into AbilityProficiencies. IDK, working on a mapping to unite these two
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

    public AbilityScores(int _strScore, int _dexScore, int _conScore, int _intScore, int _wisScore,
                         int _chaScore) {
        strScore = baseStr = _strScore;
        dexScore = baseDex = _dexScore;
        conScore = baseCon = _conScore;
        intScore = baseInt = _intScore;
        wisScore = baseWis = _wisScore;
        chaScore = baseCha = _chaScore;
    }

    public AbilityScores(int[] _scores){
        strScore = baseStr = _scores[0];
        dexScore = baseDex = _scores[1];
        conScore = baseCon = _scores[2];
        intScore = baseInt = _scores[3];
        wisScore = baseWis = _scores[4];
        chaScore = baseCha = _scores[5];
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
