package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheetView;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import java.awt.*;

public class RevisedThirdEditionCharacterSheetView extends CharacterSheetView {
    private RevisedThirdEditionCharacterSheet characterSheet;

    private BiographySection generalSection;
    private AbilityScoreSection abilityScoreSection;
    private SkillsSection skillsSection;

    //@todo attack section
    //@todo SpecialAbilitiesSection specialAbilitiesSection;
    //@todo SpellsSection spellsSection;
    //@todo AnimalCompanionSection animalCompanionSection;
    //@todo ArmorSection armorSection;
    //@todo InventorySection inventorySection;
    //@todo FeatsSection featsSection;

    public RevisedThirdEditionCharacterSheetView() {
        characterSheet = new RevisedThirdEditionCharacterSheet();
        characterSheet = new RevisedThirdEditionCharacterSheet();
        this.generalSection = new BiographySection("Character");
        this.abilityScoreSection = new AbilityScoreSection("Ability Scores");

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;

        add(generalSection, constraints);
        constraints.gridy++;

        add(abilityScoreSection, constraints);
        constraints.gridy++;

        refresh();
    }

    public void refresh() {
        generalSection.refresh(characterSheet);
        abilityScoreSection.refresh(characterSheet);
    }
}
