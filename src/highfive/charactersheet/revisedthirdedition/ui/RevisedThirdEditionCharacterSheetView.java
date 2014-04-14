package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.CharacterSheetView;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import java.awt.*;

public class RevisedThirdEditionCharacterSheetView extends CharacterSheetView {
    private RevisedThirdEditionCharacterSheet characterSheet;

    private BiographySection generalSection;
    private AbilityScoreSection abilityScoreSection;
    private ArmorClassSection armorClassSection;
    private SavingThrowsSection savingThrowsSection;

    //@todo attack section
    //@todo SpecialAbilitiesSection specialAbilitiesSection;
    //@todo SpellsSection spellsSection;
    //@todo AnimalCompanionSection animalCompanionSection;
    //@todo ArmorSection armorSection;
    //@todo InventorySection inventorySection;
    //@todo FeatsSection featsSection;

    public RevisedThirdEditionCharacterSheetView() {
        characterSheet = new RevisedThirdEditionCharacterSheet();
        generalSection = new BiographySection("Character");
        abilityScoreSection = new AbilityScoreSection("Ability Scores");
        armorClassSection = new ArmorClassSection("Armor Class");
        savingThrowsSection = new SavingThrowsSection("Saving Throws");

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;

        add(generalSection, constraints);
        constraints.gridy++;

        add(abilityScoreSection, constraints);
        constraints.gridy++;

        add(armorClassSection, constraints);
        constraints.gridy++;

        add(savingThrowsSection, constraints);
        constraints.gridy++;

        update();
    }

    public void update() {
        generalSection.update(characterSheet);
        abilityScoreSection.update(characterSheet);
        armorClassSection.update(characterSheet);
        savingThrowsSection.update(characterSheet);
    }


    public CharacterSheet getCharacterSheet() {
        return characterSheet;
    }


    public void setCharacterSheet(CharacterSheet characterSheet) {
        if (characterSheet.getClass().equals(this.getClass())) {
            throw new IllegalArgumentException();
        }
        this.characterSheet = (RevisedThirdEditionCharacterSheet)characterSheet;
    }
}
