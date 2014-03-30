package highfive.charactersheet.revisedthirdedition;

import highfive.charactersheet.CharacterSheet;

import java.util.*;

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

    //base attack modifier

    private int baseAttack;

    // Skills
    private HashMap<String, Skill> skills = new HashMap<String, Skill>();

    //Inventory
    private HashMap<String, Inventory> inventories = new HashMap<String, Inventory>();

    /**
     * Creates a default inventory. Default constructor of an Inventory sets name to "Gear"
     */
    private void createDefaultInventory(){
        inventories.put("Gear", new Inventory("Gear"));
    }

    /**
     * Adds an Inventory to the sheet
     * @param key the name of the Inventory. The parameter will also name the Inventory
     */
    public void addInventory(String key){
        inventories.put(key, new Inventory(key));
    }

    /**
     * Deletes an Inventory from the sheet, removing all items with it.
     * @param key the name of the Inventory
     */
    public void deleteInventory(String key){
        inventories.remove(key);
    }

    /**
     * Adds an item to a specified Inventory
     * @param inventory the key of the Inventory to add the item to
     * @param itemName item's name
     * @param itemWeight item's weight
     */
    public void addToInventory(String inventory, String itemName, double itemWeight){
        addToInventory(inventory, new Item(itemName, itemWeight));
    }

    /**
     * Adds an item from a specified Inventory
     * @param key the key of the Inventory to remove the item from
     * @param item item's name
     */
    public void addToInventory(String key, Item item){
        if (inventories.containsKey(key)) {
            Inventory inv = inventories.get(key);
            inv.add(item);
            inventories.replace(key, inv);
        } else {
            Inventory inv = new Inventory(key);
            inv.add(item);
            inventories.put(key, inv);
        }
    }

    /**
     * Populate the skills with the standard skills from the
     * DnD 3.5 character sheet.
     */
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

    public int getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(int armorBonus) {
        this.armorBonus = armorBonus;
    }

    public int getShieldBonus() {
        return shieldBonus;
    }

    public void setShieldBonus(int shieldBonus) {
        this.shieldBonus = shieldBonus;
    }

    public int getNaturalArmor() {
        return naturalArmor;
    }

    public void setNaturalArmor(int naturalArmor) {
        this.naturalArmor = naturalArmor;
    }

    public int getDeflectionModifer() {
        return deflectionModifer;
    }

    public void setDeflectionModifer(int deflectionModifer) {
        this.deflectionModifer = deflectionModifer;
    }

    public int getArmorClassMiscModifier() {
        return armorClassMiscModifier;
    }

    public void setArmorClassMiscModifier(int armorClassMiscModifier) {
        this.armorClassMiscModifier = armorClassMiscModifier;
    }

    private HashSet<String> languages;

    private HashSet<Feat> feats;

    private HashSet<SpecialAbility> specialAbilities;

    public Collection<String> getLanguages() {
        return languages;
    }

    public boolean addLanguage(String language) {
        return languages.add(language);
    }

    public boolean removeLanguage(String language) {
        return languages.remove(language);
    }

    // @TODO Spells

    // Constructor
    public RevisedThirdEditionCharacterSheet() {
        characterName = "New Character";
        playerName = "";
        characterClass = "";
        race = "";
        alignment = Alignment.NETRUAL;
        size = Size.MEDIUM;
    }


    // Getters and Setters
    /*
    This is mostly boilerplate, but there are also methods which implement
    logic related to the game rules. For example, rather than store the ability
    modifiers for each class, we can provide getters to derive the ability modifier
    at runtime based on the ability score (as defined in the game rules).

    As a guideline, anything on the character sheet which is calculated by performing
    some kind of math on other values is a candidate for calculating at runtime.
     */

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

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

    private Skill getSkill(String skillName) throws NoSuchElementException {
        if (!skills.containsKey(skillName)) {
            throw new NoSuchElementException(skillName + "was not found in this character's skills");
        }
        return skills.get(skillName);
    }

    public int getSkillRank(String skillName) throws NoSuchElementException {
        return getSkill(skillName).getRank();
    }

    public int getSkillMiscModifier(String skillName) throws NoSuchElementException {
        return getSkill(skillName).getMiscModifier();
    }

    /**
     * Returns the skill modifier of the given skill
     * @param skillname The name of the skill
     * @return The total skill modifier
     * @throws NoSuchElementException if the given skill is not found
     */
    public int getSkillModifer(String skillname) throws NoSuchElementException {
        Skill skill = getSkill(skillname);
        int abilityModifier = 0;
        switch (skill.getKeyAbility()) {
            case STRENGTH:
                abilityModifier = strength;
                break;
            case DEXTERITY:
                abilityModifier = dexterity;
                break;
            case CONSTITUTION:
                abilityModifier = constitution;
                break;
            case INTELLIGENCE:
                abilityModifier = intelligence;
                break;
            case WISDOM:
                abilityModifier = constitution;
                break;
            case CHARISMA:
                abilityModifier = charisma;
                break;
        }
        return abilityModifier + skill.getRank() + skill.getMiscModifier();
    }

    /**
     *
     * @return the armor class size modifier for this character
     */
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

    /**
     * Calculates the total armor class
     * @return the total armor class
     */
    public int getArmorClass() {
        return armorBonus
                + shieldBonus
                + getDexterityModifier()
                + getSizeAttackAndArmorClassModifier()
                + naturalArmor
                + deflectionModifer
                + armorClassMiscModifier;
    }

    public int getFortitudeBaseSave() {
        return fortitudeBaseSave;
    }

    public void setFortitudeBaseSave(int fortitudeBaseSave) {
        this.fortitudeBaseSave = fortitudeBaseSave;
    }

    public int getFortitudeMagicModifier() {
        return fortitudeMagicModifier;
    }

    public void setFortitudeMagicModifier(int fortitudeMagicModifier) {
        this.fortitudeMagicModifier = fortitudeMagicModifier;
    }

    public int getFortitudeMiscModifier() {
        return fortitudeMiscModifier;
    }

    public void setFortitudeMiscModifier(int fortitudeMiscModifier) {
        this.fortitudeMiscModifier = fortitudeMiscModifier;
    }

    public int getReflexBaseSave() {
        return reflexBaseSave;
    }

    public void setReflexBaseSave(int reflexBaseSave) {
        this.reflexBaseSave = reflexBaseSave;
    }

    public int getReflexMagicModifier() {
        return reflexMagicModifier;
    }

    public void setReflexMagicModifier(int reflexMagicModifier) {
        this.reflexMagicModifier = reflexMagicModifier;
    }

    public int getReflexMiscModifier() {
        return reflexMiscModifier;
    }

    public void setReflexMiscModifier(int reflexMiscModifier) {
        this.reflexMiscModifier = reflexMiscModifier;
    }

    public int getWillBaseSave() {
        return willBaseSave;
    }

    public void setWillBaseSave(int willBaseSave) {
        this.willBaseSave = willBaseSave;
    }

    public int getWillMagicModifier() {
        return willMagicModifier;
    }

    public void setWillMagicModifier(int willMagicModifier) {
        this.willMagicModifier = willMagicModifier;
    }

    public int getWillMiscModifier() {
        return willMiscModifier;
    }

    public void setWillMiscModifier(int willMiscModifier) {
        this.willMiscModifier = willMiscModifier;
    }

    /**
     *
     * @return the total Fortitude saving throw bonus
     */
    public int getFortitudeSavingThrow() {
        return fortitudeBaseSave
                + getConstitutionModifer()
                + fortitudeMagicModifier
                + fortitudeMiscModifier;
    }

    /**
     *
     * @return the total Reflex saving throw bonus
     */
    public int getReflexSavingThrow() {
        return reflexBaseSave
                + getDexterityModifier()
                + reflexMagicModifier
                + reflexMiscModifier;
    }

    /**
     *
     * @return the total Will saving throw bonus
     */
    public int getWillSavingThrow() {
        return willBaseSave
                + getWisdom()
                + willMagicModifier
                + willMiscModifier;
    }

    public boolean addFeat(Feat feat) {
        return feats.add(feat);
    }

    public boolean addFeat(String name) {
        Feat feat = new Feat();
        feat.setName(name);
        return feats.add(feat);
    }

    public boolean removeFeat(Feat feat) {
        return feats.remove(feat);
    }

    public Collection<Feat> getFeats() {
        return feats;
    }

    public boolean addSpecialAbility(SpecialAbility ability) {
        return specialAbilities.add(ability);
    }

    public boolean addSpecialAbility(String name) {
        SpecialAbility ability = new SpecialAbility();
        ability.setName(name);
        return specialAbilities.add(ability);
    }

    public boolean removeSpecialAbility(SpecialAbility ability) {
        return specialAbilities.remove(ability);
    }

    public Collection<SpecialAbility> getSpecialAbilities() {
        return specialAbilities;
    }
}
