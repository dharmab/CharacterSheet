package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheetView;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import java.awt.*;

/**
 * Created by Marcus on 4/6/2014.
 */
public class RevisedThirdEditionCharacterSheetView extends CharacterSheetView {
    private RevisedThirdEditionCharacterSheet characterSheet;

    private BiographySection generalSection;
    private StatsSection statsSection;
    private SkillsSection skillsSection;
    private SampleSection sampleSection;

    //@todo attack section
    //@todo SpecialAbilitiesSection specialAbilitiesSection;
    //@todo SpellsSection spellsSection;
    //@todo AnimalCompanionSection animalCompanionSection;
    //@todo ArmorSection armorSection;
    //@todo InventorySection inventorySection;
    //@todo FeatsSection featsSection;

    public RevisedThirdEditionCharacterSheetView() {
        characterSheet = new RevisedThirdEditionCharacterSheet();
        this.sampleSection = new SampleSection("Sample");
        this.generalSection = new BiographySection("Character");
        this.statsSection = new StatsSection("Stats");

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;

        add(generalSection, constraints);
        constraints.gridy++;

        add(statsSection, constraints);
        constraints.gridy++;

        refresh();
    }

    public void refresh() {
        generalSection.refresh(characterSheet);
        statsSection.refresh(characterSheet);
    }
}
