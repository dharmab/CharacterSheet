package highfive.charactersheet.revisedthirdedition;

public class Skill {
    private Ability keyAbility;
    private int rank;
    private int miscModifier;
    private boolean isClassSkill;

    public Skill(Ability keyAbility) {
        this.keyAbility = keyAbility;
        this.rank = 0;
        this.miscModifier = 0;
        this.isClassSkill = false;
    }

    public int getMiscModifier() {
        return miscModifier;
    }

    public void setMiscModifier(int miscModifier) {
        this.miscModifier = miscModifier;
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
