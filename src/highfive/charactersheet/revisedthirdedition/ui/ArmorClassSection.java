package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by zaid on 4/10/14.
 */
public class ArmorClassSection extends Section {
    private JLabel armorClassLabel;
    private JLabel armorBonusLabel;
    private JLabel shieldBonusLabel;
    private JLabel dexterityModifierLabel;
    private JLabel sizeModifierLabel;
    private JLabel miscModifierLabel;

    private JLabel armorClassValueLabel;
    private JSpinner armorBonusField;
    private JSpinner shieldBonusField;
    private JLabel dexterityModifierValueLabel;
    private JLabel sizeModifierValueLabel;
    private JSpinner miscModifierField;

    private ChangeListener refreshListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            refreshParent();

        }
    };


    private void refreshParent() {
        ((RevisedThirdEditionCharacterSheetView) getParent()).refresh();
    }

    public ArmorClassSection(String title) {
        super(title);
        initializeWidgets();
        assembleWidgets();
    }


    private void initializeWidgets() {
        armorClassLabel = new JLabel("Total");
        armorBonusLabel = new JLabel("Armor Bonus");
        shieldBonusLabel = new JLabel("Shield Bonus");
        dexterityModifierLabel = new JLabel("DEX Modifier");
        sizeModifierLabel = new JLabel("Size Modifier");
        miscModifierLabel = new JLabel("Misc Modifier");

        armorClassValueLabel = new JLabel("0");
        armorBonusField = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        armorBonusField.addChangeListener(refreshListener);
        shieldBonusField = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        shieldBonusField.addChangeListener(refreshListener);
        dexterityModifierValueLabel = new JLabel("0");
        sizeModifierValueLabel = new JLabel("0");
        miscModifierField = new JSpinner(new SpinnerNumberModel(0, -99, 99, 1));
        miscModifierField.addChangeListener(refreshListener);
    }


    private void assembleWidgets() {
        setLayout(new GridLayout(2, 6));
        add(armorClassLabel);
        add(armorBonusLabel);
        add(shieldBonusLabel);
        add(dexterityModifierLabel);
        add(sizeModifierLabel);
        add(miscModifierLabel);

        add(armorClassValueLabel);
        add(armorBonusField);
        add(shieldBonusField);
        add(dexterityModifierValueLabel);
        add(sizeModifierValueLabel);
        add(miscModifierField);
    }

    @Override
    public CharacterSheet refresh(CharacterSheet characterSheet) {
        return refresh((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private RevisedThirdEditionCharacterSheet refresh(RevisedThirdEditionCharacterSheet characterSheet) {
        int armorBonus = (Integer) armorBonusField.getValue();
        int shieldBonus = (Integer) shieldBonusField.getValue();
        int miscModifier = (Integer) miscModifierField.getValue();

        if (armorBonus != characterSheet.getArmorBonus()) {
            characterSheet.setArmorBonus(armorBonus);
        }

        if (shieldBonus != characterSheet.getShieldBonus()) {
            characterSheet.setShieldBonus(shieldBonus);
        }

        if (miscModifier != characterSheet.getArmorClassMiscModifier()) {
            characterSheet.setArmorClassMiscModifier(miscModifier);
        }

        armorClassValueLabel.setText(Integer.toString(characterSheet.getArmorClass()));
        armorBonusField.setValue(characterSheet.getArmorBonus());
        shieldBonusField.setValue(characterSheet.getShieldBonus());
        dexterityModifierLabel.setText((Integer.toString(characterSheet.getDexterityModifier())));
        sizeModifierValueLabel.setText(Integer.toString(characterSheet.getSizeModifier()));
        miscModifierField.setValue(characterSheet.getArmorClassMiscModifier());

        return characterSheet;
    }
}
