package highfive.charactersheet.revisedthirdedition;

import java.util.HashMap;

/**
 * Created by Marcus on 3/29/2014.
 */
public class SpellBook {
    /*  Bard, Sorcerer: have a spellBook, spellsPerDay
        Cleric: has a spellBook, spellsPerDay, preparedSpells, domainSpells, and domains
        Druid, Paladin, Ranger: have a spellBook, spellsPerDay, preparedSpells
        Wizard: has a spellBook, spellsPerDay, preparedSpells, specialtySchool, prohibitedSchool
    */
    private HashMap<Integer, String[]> spellBook; //a.k.a. spells known
    private HashMap<Integer, Integer> spellsPerDay;
    private HashMap<Integer, String[]> preparedSpells;
    private String[] domains; //when a character has domains, there are always exactly two
    private HashMap<Integer, String[]> domainSpells;
    private String specialtySchool;
    private String prohibitedSchool;

    private boolean hasPreparedSpells;
    private boolean hasDomains;
    private boolean hasSpecialtySchools;
    private boolean hasSpellFailure;

    /**
     * Default constructor, initializes all spellbook fields
     */
    public SpellBook(){
        spellBook = new HashMap<Integer, String[]>();
        spellsPerDay = new HashMap<Integer, Integer>();
        preparedSpells = new HashMap<Integer, String[]>();
        domains = new String[2];
        domainSpells = new HashMap<Integer, String[]>();
        specialtySchool = "Undeclared";
        prohibitedSchool = "Undeclared";
        hasPreparedSpells = true;
        hasDomains = true;
        hasSpecialtySchools = true;
        hasSpellFailure = true;
    }

    /**
     * Parameterized constructor
     * @param hasPreparedSpells i.e. divine casting classes and wizards
     * @param hasDomains i.e. clerics
     * @param hasSpecialtySchools i.e. wizards
     * @param hasSpellFailure i.e. arcane casting classes
     */
    public SpellBook(boolean hasPreparedSpells, boolean hasDomains,
                     boolean hasSpecialtySchools, boolean hasSpellFailure) {
        spellBook = new HashMap<Integer, String[]>();
        spellsPerDay = new HashMap<Integer, Integer>();
        if (hasPreparedSpells) {
            preparedSpells = new HashMap<Integer, String[]>();
        }
        if (hasDomains) {
            domains = new String[2];
            domainSpells = new HashMap<Integer, String[]>();
        }
        if (hasSpecialtySchools) {
            specialtySchool = "Undeclared";
            prohibitedSchool = "Undeclared";
        }
        this.hasPreparedSpells = hasPreparedSpells;
        this.hasDomains = hasDomains;
        this.hasSpecialtySchools = hasSpecialtySchools;
        this.hasSpellFailure = hasSpellFailure;
    }


}
