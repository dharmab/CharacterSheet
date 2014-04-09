package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheetView;

/**
 * Created by Marcus on 4/6/2014.
 */
public class RevisedThirdEditionCharacterSheetView extends CharacterSheetView {
    private GeneralSection generalSection;
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
        this.sampleSection = new SampleSection("Sample");
        //this.generalSection = new GeneralSection("Character");
        this.statsSection = new StatsSection("Stats");
        //this.skillsSection = new SkillsSection("Skills");
        //this.specialAbilitiesSection = new SpecialAbiltiesSection();
        //this.spellsSection = new SpellsSection();
        //this.animalCompanionSection = new AnimalCompanionSection();
        //this.armorSection = new ArmorSection();
        //this.inventorySection = new InventorySection();
        //this.featsSection = new FeatsSection();

        add(sampleSection);
        //add(generalSection);
        add(statsSection);
        //add(skillsSection);
        //add(specialAbilitiesSection.buildSection(sheet));
        //add(spellsSection.buildSection(sheet));
        //add(animalCompanionSection.buildSection(sheet));
        //add(armorSection.buildSection(sheet));
        //add(inventorySection.buildSection(sheet));
        //add(featsSection.buildSection(sheet));
    }
}
