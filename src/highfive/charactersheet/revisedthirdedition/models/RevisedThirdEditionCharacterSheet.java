package highfive.charactersheet.revisedthirdedition.models;

import highfive.charactersheet.CharacterSheet;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class RevisedThirdEditionCharacterSheet extends CharacterSheet implements Serializable {

    // Biographical info
    private String characterName;
    private String playerName;
    private String characterClass;
    private String race;
    private Alignment alignment;
    private Size size;
    private int level;
    private String deity;

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
    private int naturalArmor;
    private int deflectionModifier;
    private int armorClassMiscModifier;

    private int touchArmorClass;
    private int flatFootedArmorClass;

    private int damageReduction;

    // Hit points
    private int maxHitpoints;
    private int currentHitpoints;

    private int speed;
    private int initiativeMiscModifier;

    // Factors for calculating saving throws
    private int fortitudeBonus;
    private int fortitudeMagicModifier;
    private int fortitudeMiscModifier;

    private int reflexBonus;
    private int reflexMagicModifier;
    private int reflexMiscModifier;

    private int willBonus;
    private int willMagicModifier;
    private int willMiscModifier;

    // Base attack modifier
    private int baseAttack;

    // Skills
    private HashMap<String, Skill> skills;

    //Inventory
    private HashMap<String, Inventory> inventories;

    //Spells
    private HashMap<String, SpellBook> spellbooks;
    private int spellsave;
    private int spellFailure;

    //Languages
    private HashSet<String> languages;

    //Feats
    private HashSet<Feat> feats;

    //Special Abilities
    private HashSet<SpecialAbility> specialAbilities;

    public RevisedThirdEditionCharacterSheet() {
        characterName = "New Character";
        playerName = "";
        characterClass = "";
        race = "";
        alignment = Alignment.NEUTRAL;
        size = Size.MEDIUM;
        inventories = new HashMap<String, Inventory>();
        createDefaultInventory();
        skills = new HashMap<String, Skill>();
        populateSkills();
        spellbooks = new HashMap<String, SpellBook>();
        languages = new HashSet<String>();
        addLanguage("Common");
        feats = new HashSet<Feat>();
        specialAbilities = new HashSet<SpecialAbility>();
        deity = "";
    }

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public String getDeity() {
        return deity;
    }

    public void setDeity(String deity) {
        this.deity = deity;
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

    public int getConstitutionModifier() {
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

    public int getMaxHitpoints() {
        return maxHitpoints;
    }

    public void setMaxHitpoints(int maxHitpoints) {
        this.maxHitpoints = maxHitpoints;
    }

    public int getCurrentHitpoints() {
        return currentHitpoints;
    }

    public void setCurrentHitpoints(int currentHitpoints) {
        this.currentHitpoints = currentHitpoints;
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
     *
     * @return the total initiative
     */
    public int getInitiative() {
        return getDexterityModifier() + initiativeMiscModifier;
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


    /**
     * @return the armor class size modifier for this character
     */
    public int getSizeModifier() {
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
     *
     * @return the total armor class
     */
    public int getArmorClass() {
        return armorBonus
                + shieldBonus
                + getDexterityModifier()
                + getSizeModifier()
                + naturalArmor
                + deflectionModifier
                + armorClassMiscModifier;
    }

    public int getTouchArmorClass() {
        return touchArmorClass;
    }

    public void setTouchArmorClass(int touchArmorClass) {
        this.touchArmorClass = touchArmorClass;
    }

    public int getFlatFootedArmorClass() {
        return flatFootedArmorClass;
    }

    public void setFlatFootedArmorClass(int flatFootedArmorClass) {
        this.flatFootedArmorClass = flatFootedArmorClass;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
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
     * @return the total Fortitude saving throw bonus
     */
    public int getFortitudeSavingThrow() {
        return fortitudeBonus
                + getConstitutionModifier()
                + fortitudeMagicModifier
                + fortitudeMiscModifier;
    }

    /**
     * @return the total Reflex saving throw bonus
     */
    public int getReflexSavingThrow() {
        return reflexBonus
                + getDexterityModifier()
                + reflexMagicModifier
                + reflexMiscModifier;
    }

    /**
     * @return the total Will saving throw bonus
     */
    public int getWillSavingThrow() {
        return willBonus
                + getWisdomModifier()
                + willMagicModifier
                + willMiscModifier;
    }

    public void setFeats(HashSet<Feat> feats) {
        this.feats = feats;
    }

    public boolean addFeat(Feat feat) {
        return feats.add(feat);
    }

    public boolean addFeat(String name) {
        Feat feat = new Feat();
        feat.setName(name);
        return addFeat(feat);
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

    public int getDeflectionModifier() {
        return deflectionModifier;
    }

    public void setDeflectionModifier(int deflectionModifier) {
        this.deflectionModifier = deflectionModifier;
    }

    public int getArmorClassMiscModifier() {
        return armorClassMiscModifier;
    }

    public void setArmorClassMiscModifier(int armorClassMiscModifier) {
        this.armorClassMiscModifier = armorClassMiscModifier;
    }

    public HashMap<String, Skill> getSkillsAsHashMap() {
        return skills;
    }

    public void setSkills(HashMap<String, Skill> skills) {
        this.skills = skills;
    }

    /**
     * Creates a 2 default inventories, "Gear" and "Money"
     */
    private void createDefaultInventory() {
        inventories.put("Gear", new Inventory("Gear"));
        inventories.put("Money", new Inventory("Money"));
    }

    /**
     * Adds an Inventory to the sheet
     * @param key the name of the Inventory. The parameter will also name the Inventory
     */
    public void addInventory(String key) {
        inventories.put(key, new Inventory(key));
    }

    /**
     * Deletes an Inventory from the sheet, removing all items with it.
     * @param key the name of the Inventory
     */
    public void deleteInventory(String key) {
        inventories.remove(key);
    }

    /**
     * Three-parameter version
     * Adds an item to a specified Inventory
     * @param inventory  the key of the Inventory to add the item to
     * @param itemName   item's name
     * @param itemWeight item's weight
     */
    public void addToInventory(String inventory, String itemName, double itemWeight) {
        addToInventory(inventory, new Item(itemName, itemWeight));
    }

    /**
     * 2-parameter version
     * Adds an item to a specified Inventory
     * @param key  the key of the Inventory to add the item to
     * @param item item's name
     */
    public void addToInventory(String key, Item item) {
        if (inventories.containsKey(key)) {
            Inventory inv = inventories.get(key);
            inv.add(item);
            inventories.put(key, inv);
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

    private Skill getSkill(String skillName) throws NoSuchElementException {
        if (!skills.containsKey(skillName)) {
            throw new NoSuchElementException(skillName + "was not found in this character's skills");
        }
        return skills.get(skillName);
    }

    /**
     * Adds a new skill to the list of skills
     * @param name the name of the skill to use as the key
     * @param newSkill the new skill to add
     */
    public void addSkill(String name, Skill newSkill) {
        skills.put(name, newSkill);
    }

    public int getSkillRank(String skillName) throws NoSuchElementException {
        return getSkill(skillName).getRank();
    }

    public int getSkillMiscModifier(String skillName) throws NoSuchElementException {
        return getSkill(skillName).getMiscModifier();
    }

    /**
     * Returns the skill modifier of the given skill
     *
     * @param skillName The name of the skill
     * @return The total skill modifier
     * @throws NoSuchElementException if the given skill is not found
     */
    public int getSkillModifier(String skillName) throws NoSuchElementException {
        Skill skill = getSkill(skillName);
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
                abilityModifier = wisdom;
                break;
            case CHARISMA:
                abilityModifier = charisma;
                break;
        }
        return abilityModifier + skill.getRank() + skill.getMiscModifier();
    }

    public Collection<String> getLanguages() {
        return languages;
    }

    public boolean addLanguage(String language) {
        return languages.add(language);
    }

    public boolean removeLanguage(String language) {
        return languages.remove(language);
    }
}
