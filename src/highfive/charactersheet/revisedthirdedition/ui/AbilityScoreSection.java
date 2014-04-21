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

    //Added by Archana for missing fields

    private JLabel temporayScoreLabel;
    private JLabel temporaryModifierLabel;

    private JSpinner tempstrengthField;
    private JSpinner tempdexterityField;
    private JSpinner tempconstitutionField;
    private JSpinner tempintelligenceField;
    private JSpinner tempwisdomField;
    private JSpinner tempcharismaField;

    private JLabel tempstrengthModifierLabel;
    private JLabel tempdexterityModifierLabel;
    private JLabel tempconstitutionModifierLabel;
    private JLabel tempintelligenceModifierLabel;
    private JLabel tempwisdomModifierLabel;
    private JLabel tempcharismaModifierLabel;

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

        //Added by Archana for missing fields

        temporayScoreLabel = new JLabel("Temporary Score");
        temporaryModifierLabel = new JLabel("Temporary Modifier");

        tempstrengthField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        tempstrengthField.addChangeListener(refreshListener);
        tempdexterityField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        tempdexterityField.addChangeListener(refreshListener);
        tempconstitutionField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        tempconstitutionField.addChangeListener(refreshListener);
        tempintelligenceField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        tempintelligenceField.addChangeListener(refreshListener);
        tempwisdomField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        tempwisdomField.addChangeListener(refreshListener);
        tempcharismaField = new JSpinner(new SpinnerNumberModel(8, 1, 99, 1));
        tempcharismaField.addChangeListener(refreshListener);

        tempstrengthModifierLabel =  new JLabel();
        tempdexterityModifierLabel = new JLabel();
        tempconstitutionModifierLabel = new JLabel();
        tempintelligenceModifierLabel = new JLabel();
        tempwisdomModifierLabel = new JLabel();
        tempcharismaModifierLabel = new JLabel();
    }

    private void assembleWidgets() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(new GridBagLayout());

        //row 0
        panel.add(abilityNameLabel,new CommonFunctions().setGridConstraints(0.5, 0, 0));
        panel.add(abilityScoreLabel,new CommonFunctions().setGridConstraints(0.5, 1, 0));
        panel.add(abilityModifierLabel,new CommonFunctions().setGridConstraints(0.5, 2, 0));
        panel.add(temporayScoreLabel,new CommonFunctions().setGridConstraints(0.5, 3, 0));
        panel.add(temporaryModifierLabel,new CommonFunctions().setGridConstraints(0.5, 4, 0));
        //row 1
        panel.add(strengthLabel,new CommonFunctions().setGridConstraints(0.5, 0, 1));
        panel.add(strengthField,new CommonFunctions().setGridConstraints(0.5, 1, 1));
        panel.add(strengthModifierLabel,new CommonFunctions().setGridConstraints(0.5, 2, 1));
        panel.add(tempstrengthField,new CommonFunctions().setGridConstraints(0.5, 3, 1));
        panel.add(tempstrengthModifierLabel,new CommonFunctions().setGridConstraints(0.5, 4, 1));
        //row 2
        panel.add(dexterityLabel,new CommonFunctions().setGridConstraints(0.5, 0, 2));
        panel.add(dexterityField,new CommonFunctions().setGridConstraints(0.5, 1, 2));
        panel.add(dexterityModifierLabel,new CommonFunctions().setGridConstraints(0.5, 2, 2));
        panel.add(tempdexterityField,new CommonFunctions().setGridConstraints(0.5, 3, 2));
        panel.add(tempdexterityModifierLabel,new CommonFunctions().setGridConstraints(0.5, 4, 2));
        //row 3
        panel.add(constitutionLabel,new CommonFunctions().setGridConstraints(0.5, 0, 3));
        panel.add(constitutionField,new CommonFunctions().setGridConstraints(0.5, 1, 3));
        panel.add(constitutionModifierLabel,new CommonFunctions().setGridConstraints(0.5, 2, 3));
        panel.add(tempconstitutionField,new CommonFunctions().setGridConstraints(0.5, 3, 3));
        panel.add(tempconstitutionModifierLabel,new CommonFunctions().setGridConstraints(0.5, 4, 3));
        //row 4
        panel.add(intelligenceLabel,new CommonFunctions().setGridConstraints(0.5, 0, 4));
        panel.add(intelligenceField,new CommonFunctions().setGridConstraints(0.5, 1, 4));
        panel.add(intelligenceModifierLabel,new CommonFunctions().setGridConstraints(0.5, 2, 4));
        panel.add(tempintelligenceField,new CommonFunctions().setGridConstraints(0.5, 3, 4));
        panel.add(tempintelligenceModifierLabel,new CommonFunctions().setGridConstraints(0.5, 4, 4));
        //row 5
        panel.add(wisdomLabel,new CommonFunctions().setGridConstraints(0.5, 0, 5));
        panel.add(wisdomField,new CommonFunctions().setGridConstraints(0.5, 1, 5));
        panel.add(wisdomModifierLabel,new CommonFunctions().setGridConstraints(0.5, 2, 5));
        panel.add(tempwisdomField,new CommonFunctions().setGridConstraints(0.5, 3, 5));
        panel.add(tempwisdomModifierLabel,new CommonFunctions().setGridConstraints(0.5, 4, 5));
        //row 5
        panel.add(charismaLabel,new CommonFunctions().setGridConstraints(0.5, 0, 6));
        panel.add(charismaField,new CommonFunctions().setGridConstraints(0.5, 1, 6));
        panel.add(charismaModifierLabel,new CommonFunctions().setGridConstraints(0.5, 2, 6));
        panel.add(tempcharismaField,new CommonFunctions().setGridConstraints(0.5, 3, 6));
        panel.add(tempcharismaModifierLabel,new CommonFunctions().setGridConstraints(0.5, 4, 6));

        add(panel);
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

        // Added by Archana for missing fields
        int tempstrengthScore = (Integer) tempstrengthField.getValue();
        int tempdexterityScore = (Integer) tempdexterityField.getValue();
        int tempconstitutionScore = (Integer) tempconstitutionField.getValue();
        int tempintelligenceScore = (Integer) tempintelligenceField.getValue();
        int tempwisdomScore = (Integer) tempwisdomField.getValue();
        int tempcharismaScore = (Integer) tempcharismaField.getValue();

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

        // Added by Archana for missing fields
        if(tempstrengthScore != characterSheet.getTempstrength())
            characterSheet.setTempstrength(tempstrengthScore);
        if(tempdexterityScore != characterSheet.getTempdexterity())
            characterSheet.setTempdexterity(tempdexterityScore);
        if(tempconstitutionScore != characterSheet.getTempconstitution())
            characterSheet.setTempconstitution(tempconstitutionScore);
        if(tempintelligenceScore != characterSheet.getTempintelligence())
            characterSheet.setTempintelligence(tempintelligenceScore);
        if(tempwisdomScore != characterSheet.getTempwisdom())
            characterSheet.setTempwisdom(tempwisdomScore);
        if(tempcharismaScore != characterSheet.getTempcharisma())
            characterSheet.setTempcharisma(tempcharismaScore);

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

        //Added by Archana for missing fields
        tempstrengthField.setValue(characterSheet.getTempstrength());
        tempdexterityField.setValue(characterSheet.getTempdexterity());
        tempconstitutionField.setValue(characterSheet.getTempconstitution());
        tempintelligenceField.setValue(characterSheet.getTempintelligence());
        tempwisdomField.setValue(characterSheet.getTempwisdom());
        tempcharismaField.setValue(characterSheet.getTempcharisma());

        tempstrengthModifierLabel.setText(Integer.toString(characterSheet.getTempstrengthModifier()));
        tempdexterityModifierLabel.setText(Integer.toString(characterSheet.getTempdexterityModifier()));
        tempconstitutionModifierLabel.setText(Integer.toString(characterSheet.getTempconstitutionModifier()));
        tempintelligenceModifierLabel.setText(Integer.toString(characterSheet.getTempintelligenceModifier()));
        tempwisdomModifierLabel.setText(Integer.toString(characterSheet.getTempwisdomModifier()));
        tempcharismaModifierLabel.setText(Integer.toString(characterSheet.getTempcharismaModifier()));
    }
}
