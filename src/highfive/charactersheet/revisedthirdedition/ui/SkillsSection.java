package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;
import highfive.charactersheet.revisedthirdedition.models.Skill;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SkillsSection extends Section {

    private HashMap<String, Skill> skills;
    private int strengthModifier;
    private int dexterityModifier;
    private int constitutionModifier;
    private int wisdomModifier;
    private int intelligenceModifier;
    private int charismaModifier;

    private ChangeListener refreshListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            updateParent();
        }
    };


    public SkillsSection(String title) {
        super(title);
    }

    private void rebuild() {
        removeAll();
        setLayout(new GridLayout(skills.size() + 1, 5));
        add(new JLabel("Skill Name"));
        add(new JLabel("Skill Modifier"));
        add(new JLabel("Ability Modifier"));
        add(new JLabel("Ranks"));
        add(new JLabel("Misc Modifier"));

        for (Map.Entry<String, Skill> entry : skills.entrySet()) {
            final String key = entry.getKey();
            final Skill value = entry.getValue();

            int abilityModifier = 0;
            switch (value.getKeyAbility()) {
                case STRENGTH:
                    abilityModifier = strengthModifier;
                    break;
                case DEXTERITY:
                    abilityModifier = dexterityModifier;
                    break;
                case CONSTITUTION:
                    abilityModifier = constitutionModifier;
                    break;
                case INTELLIGENCE:
                    abilityModifier = intelligenceModifier;
                    break;
                case WISDOM:
                    abilityModifier = wisdomModifier;
                    break;
                case CHARISMA:
                    abilityModifier = charismaModifier;
                    break;
            }

            int skillModifier = abilityModifier + value.getRank() + value.getMiscModifier();

            JLabel skillNameLabel = new JLabel(key);
            JLabel skillModifierLabel = new JLabel(Integer.toString(skillModifier));
            JLabel abilityModifierLabel = new JLabel(Integer.toString(abilityModifier));
            final JSpinner skillRankField = new JSpinner(new SpinnerNumberModel(value.getRank(), 0, 99, 1));
            JSpinner skillMiscModifierField = new JSpinner(new SpinnerNumberModel(value.getMiscModifier(), 0, 99, 1));

            skillRankField.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent changeEvent) {
                    value.setRank((Integer) ((JSpinner) changeEvent.getSource()).getValue());
                    skills.put(key, value);
                    updateParent();
                }
            });
            skillMiscModifierField.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent changeEvent) {
                    value.setMiscModifier((Integer) ((JSpinner) changeEvent.getSource()).getValue());
                    skills.put(key, value);
                    updateParent();
                }
            });

            add(skillNameLabel);
            add(skillModifierLabel);
            add(abilityModifierLabel);
            add(skillRankField);
            add(skillMiscModifierField);
        }
    }

    private void updateParent() {
        ((RevisedThirdEditionCharacterSheetView) getParent()).update();
    }

    @Override
    public CharacterSheet update(CharacterSheet characterSheet) {
        return update((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private RevisedThirdEditionCharacterSheet update(RevisedThirdEditionCharacterSheet characterSheet) {
        if (skills != null) {
            characterSheet.setSkills(skills);
        }
        load(characterSheet);
        return characterSheet;
    }

    @Override
    public void load(CharacterSheet characterSheet) {
        load((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private void load(RevisedThirdEditionCharacterSheet characterSheet) {
        skills = characterSheet.getSkillsAsHashMap();
        strengthModifier = characterSheet.getStrengthModifier();
        dexterityModifier = characterSheet.getDexterityModifier();
        constitutionModifier = characterSheet.getConstitutionModifier();
        intelligenceModifier = characterSheet.getIntelligenceModifier();
        wisdomModifier = characterSheet.getIntelligenceModifier();
        charismaModifier = characterSheet.getWisdomModifier();
        rebuild();
    }
}
