package highfive.charactersheet.revisedthirdedition;

import highfive.charactersheet.AbstractSection;
import highfive.charactersheet.CharacterSheetView;

/**
 * Created by Marcus on 4/6/2014.
 */
public class DNDCharacterSheetView extends CharacterSheetView {
    GeneralSection generalSection;
    StatsSection statsSection;
    SkillsSection skillsSection;
    AttackSection attackSection;
    //@todo SpecialAbilitiesSection specialAbilitiesSection;
    //@todo SpellsSection spellsSection;
    //@todo AnimalCompanionSection animalCompanionSection;
    //@todo ArmorSection armorSection;
    //@todo InventorySection inventorySection;
    //@todo FeatsSection featsSection;

    public DNDCharacterSheetView(RevisedThirdEditionCharacterSheet sheet) {
        this.generalSection = new GeneralSection();
        this.statsSection = new StatsSection();
        this.skillsSection = new SkillsSection();
        this.attackSection = new AttackSection();
        //this.specialAbilitiesSection = new SpecialAbiltiesSection();
        //this.spellsSection = new SpellsSection();
        //this.animalCompanionSection = new AnimalCompanionSection();
        //this.armorSection = new ArmorSection();
        //this.inventorySection = new InventorySection();
        //this.featsSection = new FeatsSection();
        
        add(generalSection.buildSection(sheet));
        add(statsSection.buildSection(sheet));
        add(skillsSection.buildSection(sheet));
        add(attackSection.buildSection(sheet));
        //add(specialAbilitiesSection.buildSection(sheet));
        //add(spellsSection.buildSection(sheet));
        //add(animalCompanionSection.buildSection(sheet));
        //add(armorSection.buildSection(sheet));
        //add(inventorySection.buildSection(sheet));
        //add(featsSection.buildSection(sheet));
    }
}
