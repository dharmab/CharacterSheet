package highfive.charactersheet.revisedthirdedition.models;

public class Skill {
    private Ability keyAbility;
    private int rank;
    private int miscModifier;
    private boolean isClassSkill;

    public int getMiscModifier() {
        return miscModifier;
    }

    public void setMiscModifier(int miscModifier) {
        this.miscModifier = miscModifier;
    }

    public Skill(Ability keyAbility) {
        this.keyAbility = keyAbility;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Ability getKeyAbility() {
        return keyAbility;
    }

    public boolean getIsClassSkill() {
        return isClassSkill;
    }

    public void setIsClassSkill(boolean isClassSkill) {
        this.isClassSkill = isClassSkill;
    }
}
