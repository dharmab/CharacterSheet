package highfive.charactersheet.revisedthirdedition;

import highfive.charactersheet.CharacterSheet;

import java.util.List;

public class RevisedThirdEditionCharacterSheet extends CharacterSheet {

    // Biographical info
    private String characterName;
    private String playerName;
    private String characterClass;
    private String race;
    private Alignment alignment;
    private Size size;

    //Ability scores
    private int strength;
    private int dexterity;
    private int constitution;
    private int wisdom;
    private int intelligence;
    private int charisma;

    // Factors for calculating Armor Class
    private int armorBonus;
    private int shieldBonus;
    private int sizeModifier;
    private int naturalArmor;
    private int deflectionModifer;
    private int armorClassMiscModifier;

    private int touchArmorClass;
    private int flatFootedArmorClass;

    private int damageReduction;

    // Hit points
    private int totalHitPoints;
    private int currentHitPoints;
    private int speed;
    private int initiativeMiscModifier;

    // Factors for calculating saving throws
    private int fortitudeBaseSave;
    private int fortitudeMagicModifier;
    private int fortitudeMiscModifier;

    private int reflexBaseSave;
    private int reflexMagicModifier;
    private int reflexMiscModifier;

    private int willBaseSave;
    private int willMagicModifier;
    private int willMiscModifier;

    // Skills
    private Skill appraise = new Skill("Appraise", Ability.INTELLIGENCE);
    private Skill balance = new Skill("Balance", Ability.DEXTERITY);
    private Skill bluff = new Skill("Bluff", Ability.CHARISMA);
    // @TODO complete set of skills

    // @TODO attack

    // @TODO gear

    // @TODO inventory

    // @TODO Feats

    private List<String> languages;

    // @TODO Spells

    // @TODO Constructor method(s)

    // Getters and Setters
    /*
    This is mostly boilerplate, but there are also methods which implement
    logic related to the game rules. For example, rather than store the ability
    modifiers for each class, we can provide getters to derive the ability modifier
    at runtime based on the ability score (as defined in the game rules).

    As a guideline, anything on the character sheet which is calculated by performing
    some kind of math on other values is a candidate for calculating at runtime.
     */

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrengthModifier() {
        return getAbilityModifier(strength);
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterityModifier() {
        return getAbilityModifier(dexterity);
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getConstitutionModifer() {
        return getAbilityModifier(constitution);
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getWisdomModifier() {
        return getAbilityModifier(wisdom);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getIntelligenceModifier() {
        return getAbilityModifier(intelligence);
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharismaModifier() {
        return getAbilityModifier(charisma);
    }

    /**
     * Calculates the ability modifier of an ability.
     *
     * @param ability the integer value of the ability score
     * @return the integer value of the ability modifier
     */
    private int getAbilityModifier(int ability) {
        return (ability - 10) / 2; // Java rounds down implicitly
    }

    // @TODO armor class getters and settings

    public int getTotalHitPoints() {
        return totalHitPoints;
    }

    public void setTotalHitPoints(int totalHitPoints) {
        this.totalHitPoints = totalHitPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getInitiativeMiscModifier() {
        return initiativeMiscModifier;
    }

    public void setInitiativeMiscModifier(int initiativeMiscModifier) {
        this.initiativeMiscModifier = initiativeMiscModifier;
    }

    /**
     * Calculates total initiative. Total initiative is equal
     * to the sum of the Dexterity Modifier and Initiative Misc Modifier.
     * @return the total intitaive
     */
    public int getInitiative() {
        int initiative = this.getDexterityModifier() + initiativeMiscModifier;
        return initiative;
    }
}
