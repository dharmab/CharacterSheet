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
        setLayout(new GridLayout(skills.size() + 1, 7));
        add(new JLabel("Class Skill"));
        add(new JLabel("Skill Name"));
        add(new JLabel("Key Ability"));
        add(new JLabel("Skill Modifier"));
        add(new JLabel("Ability Modifier"));
        add(new JLabel("Ranks"));
        add(new JLabel("Misc Modifier"));

        for (Map.Entry<String, Skill> entry : skills.entrySet()) {
            final String key = entry.getKey();
            final Skill value = entry.getValue();

            String keyAbility = "N/A";
            int abilityModifier = 0;
            switch (value.getKeyAbility()) {
                case STRENGTH:
                    abilityModifier = strengthModifier;
                    keyAbility = "STR";
                    break;
                case DEXTERITY:
                    abilityModifier = dexterityModifier;
                    keyAbility = "DEX";
                    break;
                case CONSTITUTION:
                    abilityModifier = constitutionModifier;
                    keyAbility = "CON";
                    break;
                case INTELLIGENCE:
                    abilityModifier = intelligenceModifier;
                    keyAbility = "INT";
                    break;
                case WISDOM:
                    abilityModifier = wisdomModifier;
                    keyAbility = "WIS";
                    break;
                case CHARISMA:
                    abilityModifier = charismaModifier;
                    keyAbility = "CHA";
                    break;
            }

            int skillModifier = abilityModifier + value.getRank() + value.getMiscModifier();

            JCheckBox classSkillLabel = new JCheckBox("", value.getIsClassSkill());
            JLabel skillNameLabel = new JLabel(key);
            JLabel keyAbilityLabel = new JLabel(keyAbility);
            JLabel skillModifierLabel = new JLabel(Integer.toString(skillModifier));
            JLabel abilityModifierLabel = new JLabel(Integer.toString(abilityModifier));
            final JSpinner skillRankField = new JSpinner(new SpinnerNumberModel(value.getRank(), 0, 99, 1));
            JSpinner skillMiscModifierField = new JSpinner(new SpinnerNumberModel(value.getMiscModifier(), 0, 99, 1));

            classSkillLabel.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    value.setIsClassSkill(isEnabled());
                }
            });
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

            add(classSkillLabel);
            add(skillNameLabel);
            add(keyAbilityLabel);
            add(skillModifierLabel);
            add(abilityModifierLabel);
            add(skillRankField);
            add(skillMiscModifierField);
        }
    }

    @Override
    public CharacterSheet update(CharacterSheet characterSheet) {
        if (!characterSheet.getClass().equals(RevisedThirdEditionCharacterSheet.class)) {
            throw new ClassCastException();
        }
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
        if (!characterSheet.getClass().equals(RevisedThirdEditionCharacterSheet.class)) {
            throw new ClassCastException();
        }
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
