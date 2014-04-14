package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SavingThrowsSection extends Section {

    private JLabel savingThrowLabel;
    private JLabel totalLabel;
    private JLabel baseSaveLabel;
    private JLabel abilityModifierLabel;
    private JLabel miscModifierLabel;

    private JLabel fortitudeLabel;
    private JLabel fortitudeValueLabel;
    private JSpinner fortitudeBaseSaveBonusField;
    private JLabel constitutionAbilityModifierValueLabel;
    private JSpinner fortitudeMiscModifierValueField;

    private JLabel reflexLabel;
    private JLabel reflexValueLabel;
    private JSpinner reflexBaseSaveBonusField;
    private JLabel dexterityAbilityModifierValueLabel;
    private JSpinner reflexMiscModifierValueField;

    private JLabel willLabel;
    private JLabel willValueLabel;
    private JSpinner willBaseSaveBonusField;
    private JLabel wisdomAbilityModifierValueLabel;
    private JSpinner willMiscModifierValueField;

    private ChangeListener refreshListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            updateParent();

        }
    };

    public SavingThrowsSection(String title) {
        super(title);
        initializeWidgets();
        assembleWidgets();
    }

    private void assembleWidgets() {
        setLayout(new GridLayout(4, 5));
        add(savingThrowLabel);
        add(totalLabel);
        add(baseSaveLabel);
        add(abilityModifierLabel);
        add(miscModifierLabel);

        add(fortitudeLabel);
        add(fortitudeValueLabel);
        add(fortitudeBaseSaveBonusField);
        add(constitutionAbilityModifierValueLabel);
        add(fortitudeMiscModifierValueField);

        add(reflexLabel);
        add(reflexValueLabel);
        add(reflexBaseSaveBonusField);
        add(dexterityAbilityModifierValueLabel);
        add(reflexMiscModifierValueField);

        add(willLabel);
        add(willValueLabel);
        add(willBaseSaveBonusField);
        add(wisdomAbilityModifierValueLabel);
        add(willMiscModifierValueField);
    }

    private void initializeWidgets() {
        savingThrowLabel = new JLabel("Type");
        totalLabel = new JLabel("Total");
        baseSaveLabel = new JLabel("Base Save");
        abilityModifierLabel = new JLabel("Ability Modifier");
        miscModifierLabel = new JLabel("Misc Modifier");

        fortitudeLabel = new JLabel("Fortitude");
        fortitudeValueLabel = new JLabel();
        fortitudeBaseSaveBonusField = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        fortitudeBaseSaveBonusField.addChangeListener(refreshListener);
        constitutionAbilityModifierValueLabel = new JLabel();
        fortitudeMiscModifierValueField = new JSpinner(new SpinnerNumberModel(0, -99, 99, 1));
        fortitudeMiscModifierValueField.addChangeListener(refreshListener);

        reflexLabel = new JLabel("Reflex");
        reflexValueLabel = new JLabel();
        reflexBaseSaveBonusField = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        reflexBaseSaveBonusField.addChangeListener(refreshListener);
        dexterityAbilityModifierValueLabel = new JLabel();
        reflexMiscModifierValueField = new JSpinner(new SpinnerNumberModel(0, -99, 99, 1));
        reflexMiscModifierValueField.addChangeListener(refreshListener);

        willLabel = new JLabel("Will");
        willValueLabel = new JLabel();
        willBaseSaveBonusField = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        willBaseSaveBonusField.addChangeListener(refreshListener);
        wisdomAbilityModifierValueLabel = new JLabel();
        willMiscModifierValueField = new JSpinner(new SpinnerNumberModel(0, -99, 99, 1));
        willMiscModifierValueField.addChangeListener(refreshListener);
    }

    private void updateParent() {
        ((RevisedThirdEditionCharacterSheetView) getParent()).update();
    }

    @Override
    public CharacterSheet update(CharacterSheet characterSheet) {
        return update((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private RevisedThirdEditionCharacterSheet update(RevisedThirdEditionCharacterSheet characterSheet) {
        int fortitudeBaseSaveBonus = (Integer)fortitudeBaseSaveBonusField.getValue();
        int fortitudeMiscModifier = (Integer)fortitudeMiscModifierValueField.getValue();
        int reflexBaseSaveBonus = (Integer)reflexBaseSaveBonusField.getValue();
        int reflexMiscModifier = (Integer)reflexMiscModifierValueField.getValue();
        int willBaseSaveBonus = (Integer)willBaseSaveBonusField.getValue();
        int willMiscModifier = (Integer)willMiscModifierValueField.getValue();

        if (fortitudeBaseSaveBonus != characterSheet.getFortitudeBonus()) {
            characterSheet.setFortitudeBonus(fortitudeBaseSaveBonus);
        }

        if (reflexBaseSaveBonus != characterSheet.getReflexBonus()) {
            characterSheet.setReflexBonus(reflexBaseSaveBonus);
        }

        if  (willBaseSaveBonus != characterSheet.getWillBonus()) {
            characterSheet.setWillBonus(willBaseSaveBonus);
        }

        if (fortitudeMiscModifier != characterSheet.getFortitudeMiscModifier()) {
            characterSheet.setFortitudeMiscModifier(fortitudeMiscModifier);
        }

        if (reflexMiscModifier != characterSheet.getReflexMiscModifier()) {
            characterSheet.setReflexMiscModifier(reflexMiscModifier);
        }

        if (willMiscModifier != characterSheet.getWillMiscModifier()) {
            characterSheet.setWillMiscModifier(willMiscModifier);
        }

        load(characterSheet);

        return characterSheet;
    }

    @Override
    public void load(CharacterSheet characterSheet) {
        load((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private void load(RevisedThirdEditionCharacterSheet characterSheet) {
        fortitudeValueLabel.setText(Integer.toString(characterSheet.getFortitudeSavingThrow()));
        fortitudeBaseSaveBonusField.setValue(characterSheet.getFortitudeBonus());
        constitutionAbilityModifierValueLabel.setText(Integer.toString(characterSheet.getConstitutionModifier()));
        fortitudeMiscModifierValueField.setValue(characterSheet.getFortitudeMiscModifier());

        reflexValueLabel.setText(Integer.toString(characterSheet.getReflexSavingThrow()));
        reflexBaseSaveBonusField.setValue(characterSheet.getReflexBonus());
        dexterityAbilityModifierValueLabel.setText(Integer.toString(characterSheet.getDexterityModifier()));
        reflexMiscModifierValueField.setValue(characterSheet.getReflexMiscModifier());

        willValueLabel.setText(Integer.toString(characterSheet.getWillSavingThrow()));
        willBaseSaveBonusField.setValue(characterSheet.getWillBonus());
        wisdomAbilityModifierValueLabel.setText(Integer.toString(characterSheet.getWisdomModifier()));
        willMiscModifierValueField.setValue(characterSheet.getWillMiscModifier());
    }
}
