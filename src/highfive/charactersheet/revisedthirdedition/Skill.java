package highfive.charactersheet.revisedthirdedition;

public class Skill {
    private String skillName;
    private Ability keyAbility;
    private int rank;
    private int miscModifier;

    public int getMiscModifier() {
        return miscModifier;
    }

    public void setMiscModifier(int miscModifier) {
        this.miscModifier = miscModifier;
    }

    public Skill(String skillName, Ability keyAbility) {
        this.skillName = skillName;
        this.keyAbility = keyAbility;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSkillName() {
        return skillName;
    }

    public Ability getKeyAbility() {
        return keyAbility;
    }
}
