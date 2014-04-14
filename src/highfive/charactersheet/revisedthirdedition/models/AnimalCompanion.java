package highfive.charactersheet.revisedthirdedition.models;

import java.util.HashMap;

public class AnimalCompanion {
    String name;
    String typeOfAnimal;
    Size size;
    int initiative;
    int speed;
    int hitDice;
    int currentHP;
    int HP;
    String protectiveItem;
    int AC;
    int touchAC;
    int flatFootedAC;
    int naturalArmorAdjustment;
    int baseAttack;
    int grappleAttackBonus;
    String spaceUsed;
    int reachLength;
    int fortitudeBonus;
    int reflexBonus;
    int willBonus;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    HashMap<String, SpecialAbility> specialAbilities;
    HashMap<String, SpecialAbility> tricks;
    HashMap<String, Skill> skills;
    HashMap<String, Feat> feats;

    public AnimalCompanion() {
        this.name = "Animal";
        this.specialAbilities = new HashMap<String, SpecialAbility>();
        this.tricks = new HashMap<String, SpecialAbility>();
        this.skills = new HashMap<String, Skill>();
        this.feats = new HashMap<String, Feat>();
    }

    public AnimalCompanion(String name) {
        this.name = name;
        this.specialAbilities = new HashMap<String, SpecialAbility>();
        this.tricks = new HashMap<String, SpecialAbility>();
        this.skills = new HashMap<String, Skill>();
        this.feats = new HashMap<String, Feat>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        if (HP < 0){
            throw new IllegalArgumentException("Total HP cannot be less than 1");
        }
        this.HP = HP;
    }

    public String getProtectiveItem() {
        return protectiveItem;
    }

    public void setProtectiveItem(String protectiveItem) {
        this.protectiveItem = protectiveItem;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public int getTouchAC() {
        return touchAC;
    }

    public void setTouchAC(int touchAC) {
        this.touchAC = touchAC;
    }

    public int getFlatFootedAC() {
        return flatFootedAC;
    }

    public void setFlatFootedAC(int flatFootedAC) {
        this.flatFootedAC = flatFootedAC;
    }

    public int getNaturalArmorAdjustment() {
        return naturalArmorAdjustment;
    }

    public void setNaturalArmorAdjustment(int naturalArmorAdjustment) {
        this.naturalArmorAdjustment = naturalArmorAdjustment;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getGrappleAttackBonus() {
        return grappleAttackBonus;
    }

    public void setGrappleAttackBonus(int grappleAttackBonus) {
        this.grappleAttackBonus = grappleAttackBonus;
    }

    public String getSpaceUsed() {
        return spaceUsed;
    }

    public void setSpaceUsed(String spaceUsed) {
        this.spaceUsed = spaceUsed;
    }

    public int getReachLength() {
        return reachLength;
    }

    public void setReachLength(int reachLength) {
        this.reachLength = reachLength;
    }

    public int getFortitudeBonus() {
        return fortitudeBonus;
    }

    public void setFortitudeBonus(int fortitudeBonus) {
        this.fortitudeBonus = fortitudeBonus;
    }

    public int getReflexBonus() {
        return reflexBonus;
    }

    public void setReflexBonus(int reflexBonus) {
        this.reflexBonus = reflexBonus;
    }

    public int getWillBonus() {
        return willBonus;
    }

    public void setWillBonus(int willBonus) {
        this.willBonus = willBonus;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public HashMap<String, SpecialAbility> getSpecialAbilities() {
        return specialAbilities;
    }

    public void addToSpecialAbilities(String name, SpecialAbility specialAbility) {
        this.specialAbilities.put(name, specialAbility);
    }

    public void removeFromSpecialAbilities(String specialAbility) {
        if (!specialAbilities.containsKey(specialAbility)) {
            throw new IllegalArgumentException(specialAbility + " does not exist");
        }
        this.specialAbilities.remove(specialAbility);
    }

    public HashMap<String, SpecialAbility> getTricks() {
        return tricks;
    }

    public void addToTricks(String name, SpecialAbility trick) {
        this.tricks.put(name, trick);
    }

    public void removeFromTricks(String trick) {
        if (!tricks.containsKey(trick)) {
            throw new IllegalArgumentException(trick + " does not exist");
        }
        this.tricks.remove(trick);
    }

    public HashMap<String, Skill> getSkills() {
        return skills;
    }

    public void addToSkills(String name, Skill skill) {
        if (skills.containsKey(name)) {
            throw new IllegalArgumentException("This skill is already present");
        }
        skills.put(name, skill);
    }

    public void removeFromSkills(String skill) {
        if (!skills.containsKey(skill)) {
            throw new IllegalArgumentException("This skill is not in the list");
        }
        skills.remove(skill);
    }

    public HashMap<String, Feat> getFeats() {
        return feats;
    }

    public void addToFeats(String name, Feat feat) {
        if (skills.containsKey(name)) {
            throw new IllegalArgumentException("This feat is already present");
        }
        feats.put(name, feat);
    }

    public void removeFromFeats(String feat) {
        if (!skills.containsKey(feat)) {
            throw new IllegalArgumentException("This feat is not in the list");
        }
        skills.remove(feat);
    }

    private int getSizeAttackAndArmorClassModifier() {
        switch (size) {
            case FINE:
                return 8;
            case DIMINUTIVE:
                return 4;
            case TINY:
                return 2;
            case SMALL:
                return 1;
            case MEDIUM:
                return 0;
            case LARGE:
                return -1;
            case HUGE:
                return -2;
            case GARGANTUAN:
                return -4;
            case COLOSSAL:
                return -8;
            default:
                return 0;
        }
    }
}
