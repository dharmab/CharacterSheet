package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class AbilityScoreSection extends Section {
    private JLabel abilityNameLabel;
    private JLabel abilityScoreLabel;
    private JLabel abilityModifierLabel;

    private JLabel strengthLabel;
    private JLabel dexterityLabel;
    private JLabel constitutionLabel;
    private JLabel intelligenceLabel;
    private JLabel wisdomLabel;
    private JLabel charismaLabel;

    private JSpinner strengthField;
    private JSpinner dexterityField;
    private JSpinner constitutionField;
    private JSpinner intelligenceField;
    private JSpinner wisdomField;
    private JSpinner charismaField;

    private JLabel strengthModifierLabel;
    private JLabel dexterityModifierLabel;
    private JLabel constitutionModifierLabel;
    private JLabel intelligenceModifierLabel;
    private JLabel wisdomModifierLabel;
    private JLabel charismaModifierLabel;

    private ChangeListener refreshListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            updateParent();

        }
    };

    public AbilityScoreSection(String title) {
        super(title);
        initializeWidgets();
        assembleWidgets();
    }


    private void initializeWidgets() {
        abilityNameLabel = new JLabel("Ability Name");
        abilityScoreLabel = new JLabel("Ability Score");
        abilityModifierLabel = new JLabel("Ability Modifier");

        strengthLabel = new JLabel("STR");
        dexterityLabel = new JLabel("DEX");
        constitutionLabel = new JLabel("CON");
        intelligenceLabel = new JLabel("INT");
        wisdomLabel = new JLabel("WIS");
        charismaLabel = new JLabel("CHA");

        strengthField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        strengthField.addChangeListener(refreshListener);
        dexterityField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        dexterityField.addChangeListener(refreshListener);
        constitutionField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        constitutionField.addChangeListener(refreshListener);
        intelligenceField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        intelligenceField.addChangeListener(refreshListener);
        wisdomField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        wisdomField.addChangeListener(refreshListener);
        charismaField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        charismaField.addChangeListener(refreshListener);

        strengthModifierLabel = new JLabel();
        dexterityModifierLabel = new JLabel();
        constitutionModifierLabel = new JLabel();
        intelligenceModifierLabel = new JLabel();
        wisdomModifierLabel = new JLabel();
        charismaModifierLabel = new JLabel();
    }

    private void assembleWidgets() {
        setLayout(new GridLayout(7, 6));
        add(abilityNameLabel);
        add(abilityScoreLabel);
        add(abilityModifierLabel);

        add(strengthLabel);
        add(strengthField);
        add(strengthModifierLabel);

        add(dexterityLabel);
        add(dexterityField);
        add(dexterityModifierLabel);

        add(constitutionLabel);
        add(constitutionField);
        add(constitutionModifierLabel);

        add(intelligenceLabel);
        add(intelligenceField);
        add(intelligenceModifierLabel);

        add(wisdomLabel);
        add(wisdomField);
        add(wisdomModifierLabel);

        add(charismaLabel);
        add(charismaField);
        add(charismaModifierLabel);
    }

    @Override
    public CharacterSheet update(CharacterSheet characterSheet) {
        if (!characterSheet.getClass().equals(RevisedThirdEditionCharacterSheet.class)) {
            throw new ClassCastException();
        }
        return update((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private RevisedThirdEditionCharacterSheet update(RevisedThirdEditionCharacterSheet characterSheet) {
        int strengthScore = (Integer) strengthField.getValue();
        int dexterityScore = (Integer) dexterityField.getValue();
        int constitutionScore = (Integer) constitutionField.getValue();
        int intelligenceScore = (Integer) intelligenceField.getValue();
        int wisdomScore = (Integer) wisdomField.getValue();
        int charismaScore = (Integer) charismaField.getValue();

        if (strengthScore != characterSheet.getStrength()) {
            characterSheet.setStrength(strengthScore);
        }

        if (dexterityScore != characterSheet.getDexterity()) {
            characterSheet.setDexterity(dexterityScore);
        }

        if (constitutionScore != characterSheet.getConstitution()) {
            characterSheet.setConstitution(constitutionScore);
        }

        if (intelligenceScore != characterSheet.getIntelligence()) {
            characterSheet.setIntelligence(intelligenceScore);
        }

        if (wisdomScore != characterSheet.getWisdom()) {
            characterSheet.setWisdom(wisdomScore);
        }

        if (charismaScore != characterSheet.getCharisma()) {
            characterSheet.setCharisma(charismaScore);
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
        strengthField.setValue(characterSheet.getStrength());
        dexterityField.setValue(characterSheet.getDexterity());
        constitutionField.setValue(characterSheet.getConstitution());
        intelligenceField.setValue(characterSheet.getIntelligence());
        wisdomField.setValue(characterSheet.getWisdom());
        charismaField.setValue(characterSheet.getCharisma());

        strengthModifierLabel.setText(Integer.toString(characterSheet.getStrengthModifier()));
        dexterityModifierLabel.setText(Integer.toString(characterSheet.getDexterityModifier()));
        constitutionModifierLabel.setText(Integer.toString(characterSheet.getConstitutionModifier()));
        intelligenceModifierLabel.setText(Integer.toString(characterSheet.getIntelligenceModifier()));
        wisdomModifierLabel.setText(Integer.toString(characterSheet.getWisdomModifier()));
        charismaModifierLabel.setText(Integer.toString(characterSheet.getCharismaModifier()));
    }
}
