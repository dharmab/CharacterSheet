package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.CharacterSheetView;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import java.awt.*;

public class RevisedThirdEditionCharacterSheetView extends CharacterSheetView {
    private RevisedThirdEditionCharacterSheet characterSheet;

    private BiographySection generalSection;
    private AbilityScoreSection abilityScoreSection;
    private HitpointsSection hitpointsSection;
    private ArmorClassSection armorClassSection;
    private SavingThrowsSection savingThrowsSection;
    private SkillsSection skillSection;
    private AttackSection attackSection;

    //@todo attack section
    //@todo SpecialAbilitiesSection specialAbilitiesSection;
    //@todo SpellsSection spellsSection;
    //@todo AnimalCompanionSection animalCompanionSection;
    //@todo AnimalCompanionSection animalCompanionSection;
    //@todo ArmorSection armorSection;
    //@todo InventorySection inventorySection;
    //@todo FeatsSection featsSection;

    public RevisedThirdEditionCharacterSheetView() {
        characterSheet = new RevisedThirdEditionCharacterSheet();
        generalSection = new BiographySection("Character");
        abilityScoreSection = new AbilityScoreSection("Ability Scores");
        hitpointsSection = new HitpointsSection("Hit Points");
        armorClassSection = new ArmorClassSection("Armor Class");
        savingThrowsSection = new SavingThrowsSection("Saving Throws");
        skillSection = new SkillsSection("Skills");
        attackSection = new AttackSection("Attack");

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;

        add(generalSection, constraints);
        constraints.gridy++;

        add(abilityScoreSection, constraints);
        constraints.gridy++;

        add(hitpointsSection, constraints);
        constraints.gridy++;

        add(armorClassSection, constraints);
        constraints.gridy++;

        add(savingThrowsSection, constraints);
        constraints.gridy++;

        add(skillSection, constraints);
        constraints.gridy++;

        add(attackSection,constraints);
        constraints.gridy++;

        update();
    }

    public void update() {
        generalSection.update(characterSheet);
        abilityScoreSection.update(characterSheet);
        hitpointsSection.update(characterSheet);
        armorClassSection.update(characterSheet);
        savingThrowsSection.update(characterSheet);
        skillSection.update(characterSheet);
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
