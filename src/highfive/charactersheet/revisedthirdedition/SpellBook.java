package highfive.charactersheet.revisedthirdedition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Marcus on 3/29/2014.
 */
public class SpellBook {
    /*  Bard, Sorcerer: have a spellBook, spellsPerDay
        Cleric: has a spellBook, spellsPerDay, preparedSpells, domainSpells, and domains
        Druid, Paladin, Ranger: have a spellBook, spellsPerDay, preparedSpells
        Wizard: has a spellBook, spellsPerDay, preparedSpells, specialtySchool, prohibitedSchool
    */
    private HashMap<String, Spell> spellBook; //a.k.a. spells known
    private HashMap<Integer, Integer> spellsPerDay;
    private HashMap<String, Spell> preparedSpells;
    private String[] domains; //when a character has domains, there are always exactly two
    private HashMap<String, Spell> domainSpells;
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
        spellBook = new HashMap<String, Spell>();
        spellsPerDay = new HashMap<Integer, Integer>();
        preparedSpells = new HashMap<String, Spell>();
        domains = new String[2];
        domainSpells = new HashMap<String, Spell>();
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
        spellBook = new HashMap<String, Spell>();
        spellsPerDay = new HashMap<Integer, Integer>();
        if (hasPreparedSpells) {
            preparedSpells = new HashMap<String, Spell>();
        }
        if (hasDomains) {
            domains = new String[2];
            domainSpells = new HashMap<String, Spell>();
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

    /**
     * Adds to the spellbook, a.k.a. spells known
     * @param spell The spell to be added
     */
    public void addToSpellbook(Spell spell) {
        if (spellBook.containsKey(spell.getName())) {
            throw new IllegalArgumentException("That spell is already in this spellbook");
        }
        spellBook.put(spell.getName(), spell);
    }

    public void deleteFromSpellbook(Spell spell) {
        if (!spellBook.containsKey(spell.getName())) {
            throw new IllegalArgumentException("That spell is not in this spellbook");
        }
        spellBook.remove(spell.getName());
    }

    public void addToDomainSpellbook(Spell spell) {
        if (domainSpells.containsKey(spell.getName())) {
            throw new IllegalArgumentException("That spell is already in this spellbook");
        }
        domainSpells.put(spell.getName(), spell);
    }

    public void deleteFromDomainSpellbook(Spell spell) {
        if (!domainSpells.containsKey(spell.getName())) {
            throw new IllegalArgumentException("That spell is not in this spellbook");
        }
        domainSpells.remove(spell.getName());
    }

    public void addtoPreparedSpells(Spell spell) {
        spellBook.put(spell.getName(), spell);
    }

    public void removeFromPreparedSpells(Spell spell) {
        spellBook.remove(spell);
    }

    /**
     * @return a 2D array with all the spellbook spells in their appropriate levels
     */
    public Spell[][] getSpellbookAsTable() {
        ArrayList<Spell> spellCollection = (ArrayList)this.spellBook.values();
        Spell[][] table = new Spell[10][];
        ArrayList<Spell> tempTable = new ArrayList<Spell>();
        for (int i = 0; i < 10; i++){
            for (Spell spell: spellCollection){
                if (spell.getLevel() == i) {
                    tempTable.add(spell);
                    spellCollection.remove(spell);//ensures no duplicate spells
                }
                table[i] = (Spell[])tempTable.toArray();
                tempTable.clear();
            }
        }
        return table;
    }

    /**
     * @return a 2D array with all the domain spells in their appropriate levels
     */
    public Spell[][] getDomainSpellsAsTable() {
        ArrayList<Spell> spellCollection = (ArrayList)this.domainSpells.values();
        Spell[][] table = new Spell[10][];
        ArrayList<Spell> tempTable = new ArrayList<Spell>();
        for (int i = 0; i < 10; i++){
            for (Spell spell: spellCollection){
                if (spell.getLevel() == i) {
                    tempTable.add(spell);
                    spellCollection.remove(spell);//ensures no duplicate spells
                }
                table[i] = (Spell[])tempTable.toArray();
                tempTable.clear();
            }
        }
        return table;
    }

    /**
     * @return a 2D array with all the prepared spells in their appropriate levels
     */
    public Spell[][] getPreparedSpellsAsTable() {
        ArrayList<Spell> spellCollection = (ArrayList)this.preparedSpells.values();
        Spell[][] table = new Spell[10][];
        ArrayList<Spell> tempTable = new ArrayList<Spell>();
        for (int i = 0; i < 10; i++){
            for (Spell spell: spellCollection){
                if (spell.getLevel() == i) {
                    tempTable.add(spell);
                    spellCollection.remove(spell);//ensures no duplicate spells
                }
                table[i] = (Spell[])tempTable.toArray();
                tempTable.clear();
            }
        }
        return table;
    }

    public void setDomains(String domain1, String domain2) {
        this.domains = new String[]{domain1, domain2};
    }

    public String[] getDomains() {
        return this.domains;
    }

    public boolean hasPreparedSpells(){
        return this.hasPreparedSpells;
    }

    public boolean hasDomains() {
        return this.hasDomains;
    }

    public boolean hasSpecialtySchools() {
        return this.hasSpecialtySchools;
    }

    public boolean hasSpellFailure() {
        return this.hasSpellFailure;
    }
}
