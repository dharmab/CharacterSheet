package highfive.charactersheet.revisedthirdedition;

import highfive.charactersheet.CharacterSheet;

import java.util.HashMap;
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
    private HashMap<String, Skill> skills = new HashMap<String, Skill>();

    private void populateSkills() {
        skills.put("Appraise", new Skill(Ability.INTELLIGENCE));
        skills.put("Balance", new Skill(Ability.DEXTERITY));
        skills.put("Bluff", new Skill(Ability.CHARISMA));
        skills.put("Climb", new Skill(Ability.STRENGTH));
        skills.put("Concentration", new Skill(Ability.CONSTITUTION));
        skills.put("Craft", new Skill(Ability.INTELLIGENCE));
        skills.put("Decipher Script", new Skill(Ability.INTELLIGENCE));
        skills.put("Diplomacy", new Skill(Ability.CHARISMA));
        skills.put("Disable Device", new Skill(Ability.INTELLIGENCE));
        skills.put("Disguise", new Skill(Ability.CHARISMA));
        skills.put("Escape Artist", new Skill(Ability.DEXTERITY));
        skills.put("Forgery", new Skill(Ability.INTELLIGENCE));
        skills.put("Gather Information", new Skill(Ability.CHARISMA));
        skills.put("Handle Animal", new Skill(Ability.CHARISMA));
        skills.put("Heal", new Skill(Ability.WISDOM));
        skills.put("Hide", new Skill(Ability.DEXTERITY));
        skills.put("Intimidate", new Skill(Ability.CHARISMA));
        skills.put("Jump", new Skill(Ability.STRENGTH));
        skills.put("Knowledge", new Skill(Ability.INTELLIGENCE));
        skills.put("Listen", new Skill(Ability.WISDOM));
        skills.put("Move Silently", new Skill(Ability.DEXTERITY));
        skills.put("Open Lock", new Skill(Ability.DEXTERITY));
        skills.put("Perform", new Skill(Ability.CHARISMA));
        skills.put("Profession", new Skill(Ability.WISDOM));
        skills.put("Ride", new Skill(Ability.DEXTERITY));
        skills.put("Search", new Skill(Ability.INTELLIGENCE));
        skills.put("Sense Motive", new Skill(Ability.WISDOM));
        skills.put("Sleight of Hand", new Skill(Ability.DEXTERITY));
        skills.put("Spellcraft", new Skill(Ability.INTELLIGENCE));
        skills.put("Spot", new Skill(Ability.WISDOM));
        skills.put("Survival", new Skill(Ability.WISDOM));
        skills.put("Swim", new Skill(Ability.STRENGTH));
        skills.put("Tumble", new Skill(Ability.DEXTERITY));
        skills.put("Use Magic Device", new Skill(Ability.CHARISMA));
        skills.put("Use Rope", new Skill(Ability.DEXTERITY));
    }

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
     * @return the total initiative
     */
    public int getInitiative() {
        return getDexterityModifier() + initiativeMiscModifier;
    }
}
