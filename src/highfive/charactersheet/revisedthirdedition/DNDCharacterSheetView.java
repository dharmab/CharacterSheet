package highfive.charactersheet.revisedthirdedition;

import highfive.charactersheet.AbstractSection;
import highfive.charactersheet.CharacterSheetView;

/**
 * Created by Marcus on 4/6/2014.
 */
public class DNDCharacterSheetView extends CharacterSheetView {
    //@todo GeneralSection generalSection;
    StatsSection statsSection;
    SkillsSection skillsSection;
    AttackSection attackSection;
    //@todo SpecialAbilitiesSection specialAbilitiesSection;
    //@todo SpellsSection spellsSection;
    //@todo AnimalCompanionSection animalCompanionSection;
    //@todo ArmorSection armorSection;
    //@todo InventorySection inventorySection;
    //@todo FeatsSection featsSection;

    public DNDCharacterSheetView(RevisedThirdEditionCharacterSheet sheet, AbstractSection[] sections) {
        for (AbstractSection s : sections) {
            this.add(s.buildSection(sheet));
        }
    }
}
