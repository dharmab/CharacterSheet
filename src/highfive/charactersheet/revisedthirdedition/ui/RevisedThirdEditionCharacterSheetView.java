package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.CharacterSheetView;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import java.awt.*;
import java.util.ArrayList;

public class RevisedThirdEditionCharacterSheetView extends CharacterSheetView {
    private RevisedThirdEditionCharacterSheet characterSheet;

    private BiographySection biographySection;
    private AbilityScoreSection abilityScoreSection;
    private HitpointsSection hitpointsSection;
    private ArmorClassSection armorClassSection;
    private SavingThrowsSection savingThrowsSection;
    private SkillsSection skillSection;
    private AttackSection attackSection;
    private FeatsSection featsSection;
    private SpecialAbilitiesSection specialAbilitiesSection;
    private InventorySection inventorySection;
    //@todo SpellsSection spellsSection;
    //@todo AnimalCompanionSection animalCompanionSection;
    //@todo ArmorSection armorSection;

    public RevisedThirdEditionCharacterSheetView() {
        characterSheet = new RevisedThirdEditionCharacterSheet();
        biographySection = new BiographySection("Character");
        abilityScoreSection = new AbilityScoreSection("Ability Scores");
        hitpointsSection = new HitpointsSection("Hit Points");
        armorClassSection = new ArmorClassSection("Armor Class");
        savingThrowsSection = new SavingThrowsSection("Saving Throws");
        skillSection = new SkillsSection("Skills");
        attackSection = new AttackSection("Attack");
        featsSection = new FeatsSection("Feats");
        specialAbilitiesSection = new SpecialAbilitiesSection("Special Abilities");
        inventorySection = new InventorySection("Inventory", "General");

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;

        for (Section section : getSectionsAsArrayList()) {
            add(section, constraints);
            constraints.gridy++;
        }

        update();
    }

    private ArrayList<Section> getSectionsAsArrayList() {
        ArrayList<Section> arrayList = new ArrayList<Section>();

        arrayList.add(biographySection);
        arrayList.add(abilityScoreSection);
        arrayList.add(hitpointsSection);
        arrayList.add(armorClassSection);
        arrayList.add(savingThrowsSection);
        arrayList.add(skillSection);
        arrayList.add(attackSection);
        arrayList.add(featsSection);
        arrayList.add(specialAbilitiesSection);
        arrayList.add(inventorySection);
        return arrayList;
    }

    public void update() {
        for (Section section : getSectionsAsArrayList()) {
            section.update(characterSheet);
        }
    }

    public void load() {
        for (Section section : getSectionsAsArrayList()) {
            section.load(characterSheet);
        }
    }

    public CharacterSheet getCharacterSheet() {
        return characterSheet;
    }


    public void setCharacterSheet(CharacterSheet characterSheet) {
        if (characterSheet.getClass().equals(this.getClass())) {
            throw new IllegalArgumentException();
        }
        this.characterSheet = (RevisedThirdEditionCharacterSheet) characterSheet;
    }
}
