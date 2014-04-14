package highfive.charactersheet.revisedthirdedition.models;

import java.util.HashMap;

public class WildShape {
    String name;
    int additionalStrength;
    int additionalDexterity;
    int additionalConstitution;
    int naturalArmorBonus;
    Size size;
    HashMap<String, SpecialAbility> specialAbilities;

    public WildShape() {
        this.name = "Untitled Form";
        this.additionalStrength = 0;
        this.additionalDexterity = 0;
        this.additionalConstitution = 0;
        this.naturalArmorBonus = 0;
        this.size = Size.MEDIUM;
        this.specialAbilities = new HashMap<String, SpecialAbility>();
    }

    public WildShape(String name) {
        this.name = name;
        this.additionalStrength = 0;
        this.additionalDexterity = 0;
        this.additionalConstitution = 0;
        this.naturalArmorBonus = 0;
        this.size = Size.MEDIUM;
        this.specialAbilities = new HashMap<String, SpecialAbility>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdditionalStrength() {
        return additionalStrength;
    }

    public void setAdditionalStrength(int additionalStrength) {
        this.additionalStrength = additionalStrength;
    }

    public int getAdditionalDexterity() {
        return additionalDexterity;
    }

    public void setAdditionalDexterity(int additionalDexterity) {
        this.additionalDexterity = additionalDexterity;
    }

    public int getAdditionalConstitution() {
        return additionalConstitution;
    }

    public void setAdditionalConstitution(int additionalConstitution) {
        this.additionalConstitution = additionalConstitution;
    }

    public int getNaturalArmorBonus() {
        return naturalArmorBonus;
    }

    public void setNaturalArmorBonus(int naturalArmorBonus) {
        this.naturalArmorBonus = naturalArmorBonus;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void addSpecialAbility(String name, SpecialAbility specialAbility) {
        specialAbilities.put(name, specialAbility);
    }

    public void removeSpecialAbility(String name) {
        if (!specialAbilities.containsKey(name)) {
            throw new IllegalArgumentException("Special ability not present in HashMap");
        }
        specialAbilities.remove(name);
    }

    public HashMap<String, SpecialAbility> getSpecialAbilities() {
        return this.specialAbilities;
    }
}
