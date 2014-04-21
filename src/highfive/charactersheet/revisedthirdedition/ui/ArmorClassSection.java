package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

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

    //Added by Archana for missing fields
    private JLabel naturalarmorLabel;
    private JLabel deflectionmodifierLabel;
    private JLabel damagereductionLabel;

    private JSpinner naturalarmorField;
    private JSpinner deflectionmodifierField;
    private JSpinner damagereductionField;

    private JLabel touchLabel;
    private JLabel flatfootedLabel;
    private JLabel initiativeLabel;
    private JLabel initiativetotalLabel;
    private JLabel initiativetotalValueLabel;
    private JLabel initiativedexmodifierLabel;
    private JLabel initiativemismodifierLabel;

    private JLabel touchValueLabel;
    private JLabel flatfootedValueLabel;
    private JSpinner initiativedexmodifierField;
    private JSpinner initiativemismodifierField;

    private ChangeListener refreshListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            updateParent();

        }
    };

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

        //Added by Archana for missing fields
        naturalarmorLabel = new JLabel("Natural Armor");
        deflectionmodifierLabel = new JLabel("Deflection Modifier");
        damagereductionLabel = new JLabel("Damage Reduction");

        naturalarmorField = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        naturalarmorField.addChangeListener(refreshListener);
        deflectionmodifierField = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        deflectionmodifierField.addChangeListener(refreshListener);
        damagereductionField = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        damagereductionField.addChangeListener(refreshListener);

        touchLabel = new JLabel("Touch");
        flatfootedLabel = new JLabel("Flat-footed");

        touchValueLabel =  new JLabel();
        flatfootedValueLabel =  new JLabel();

        initiativeLabel = new JLabel("        Initiative");
        initiativetotalLabel = new JLabel("Total");
        initiativetotalValueLabel = new JLabel();
        initiativedexmodifierLabel = new JLabel("Dex Modifier");
        initiativemismodifierLabel = new JLabel("Misc Modifier");
        initiativedexmodifierField = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        initiativedexmodifierField.addChangeListener(refreshListener);
        initiativemismodifierField = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        initiativemismodifierField.addChangeListener(refreshListener);
    }


    private void assembleWidgets() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(new GridBagLayout());

        //row 0
        panel.add(armorClassLabel,new CommonFunctions().setGridConstraints(0.5, 0, 0));
        panel.add(new JLabel(),new CommonFunctions().setGridConstraints(0.5, 1, 0));
        panel.add(armorBonusLabel,new CommonFunctions().setGridConstraints(0.5, 2, 0));
        panel.add(shieldBonusLabel,new CommonFunctions().setGridConstraints(0.5, 3, 0));
        panel.add(dexterityModifierLabel,new CommonFunctions().setGridConstraints(0.5, 4, 0));
        panel.add(sizeModifierLabel,new CommonFunctions().setGridConstraints(0.5, 5, 0));
        panel.add(naturalarmorLabel,new CommonFunctions().setGridConstraints(0.5, 6, 0));
        panel.add(deflectionmodifierLabel,new CommonFunctions().setGridConstraints(0.5, 7, 0));
        panel.add(miscModifierLabel,new CommonFunctions().setGridConstraints(0.5, 8, 0));
        panel.add(damagereductionLabel,new CommonFunctions().setGridConstraints(0.5, 9, 0));
        //row 1
        panel.add(armorClassValueLabel,new CommonFunctions().setGridConstraints(0.5, 0, 1));
        panel.add(new JLabel("+10"),new CommonFunctions().setGridConstraints(0.5, 1, 1));
        panel.add(armorBonusField,new CommonFunctions().setGridConstraints(0.5, 2, 1));
        panel.add(shieldBonusField,new CommonFunctions().setGridConstraints(0.5, 3, 1));
        panel.add(dexterityModifierValueLabel,new CommonFunctions().setGridConstraints(0.5, 4, 1));
        panel.add(sizeModifierValueLabel,new CommonFunctions().setGridConstraints(0.5, 5, 1));
        panel.add(naturalarmorField,new CommonFunctions().setGridConstraints(0.5, 6, 1));
        panel.add(deflectionmodifierField,new CommonFunctions().setGridConstraints(0.5, 7, 1));
        panel.add(miscModifierField,new CommonFunctions().setGridConstraints(0.5, 8, 1));
        panel.add(damagereductionField,new CommonFunctions().setGridConstraints(0.5, 9, 1));
        //row 3
        panel.add(touchLabel,new CommonFunctions().setGridConstraints(0.5, 0, 2));
        panel.add(flatfootedLabel,new CommonFunctions().setGridConstraints(0.5, 1, 2));
        panel.add(new JLabel(),new CommonFunctions().setGridConstraints(0.5, 2, 2));
        panel.add(new JLabel(),new CommonFunctions().setGridConstraints(0.5, 3, 2));
        panel.add(initiativetotalLabel,new CommonFunctions().setGridConstraints(0.5, 4, 2));
        panel.add(initiativedexmodifierLabel,new CommonFunctions().setGridConstraints(0.5, 5, 2));
        panel.add(initiativemismodifierLabel,new CommonFunctions().setGridConstraints(0.5, 6, 2));
        //row 4
        panel.add(touchValueLabel,new CommonFunctions().setGridConstraints(0.5, 0, 3));
        panel.add(flatfootedValueLabel,new CommonFunctions().setGridConstraints(0.5, 1, 3));
        panel.add(new JLabel(),new CommonFunctions().setGridConstraints(0.5, 2, 2));
        panel.add(initiativeLabel,new CommonFunctions().setGridConstraints(0.5, 3, 3));
        panel.add(initiativetotalValueLabel,new CommonFunctions().setGridConstraints(0.5, 4, 3));
        panel.add(initiativedexmodifierField,new CommonFunctions().setGridConstraints(0.5, 5, 3));
        panel.add(initiativemismodifierField,new CommonFunctions().setGridConstraints(0.5, 6, 3));

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
        int armorBonus = (Integer) armorBonusField.getValue();
        int shieldBonus = (Integer) shieldBonusField.getValue();
        int miscModifier = (Integer) miscModifierField.getValue();

        //Added by Archana for missing fields
        int naturalarmor = (Integer) naturalarmorField.getValue();
        int deflectionmodifier =(Integer) deflectionmodifierField.getValue();
        int damagereduction = (Integer)damagereductionField.getValue();
        //int touch = (Integer) touchField.getValue();
        //int flatfooted = (Integer) flatfootedField.getValue();
        int initiativedex = (Integer)initiativedexmodifierField.getValue();
        int initiativemisc = (Integer) initiativemismodifierField.getValue();

        if (armorBonus != characterSheet.getArmorBonus()) {
            characterSheet.setArmorBonus(armorBonus);
        }

        if (shieldBonus != characterSheet.getShieldBonus()) {
            characterSheet.setShieldBonus(shieldBonus);
        }

        if (miscModifier != characterSheet.getArmorClassMiscModifier()) {
            characterSheet.setArmorClassMiscModifier(miscModifier);
        }

        //Added by Archana for missing fields
        if(naturalarmor != characterSheet.getNaturalArmor())
            characterSheet.setNaturalArmor(naturalarmor);
        if(deflectionmodifier != characterSheet.getDeflectionModifier())
            characterSheet.setDeflectionModifier(deflectionmodifier);
        if(damagereduction != characterSheet.getDamageReduction())
            characterSheet.setDamageReduction(damagereduction);
        /*if(touch !=characterSheet.getTouchArmorClass() )
            characterSheet.setTouchArmorClass(touch);
        if(flatfooted != characterSheet.getFlatFootedArmorClass())
            characterSheet.setFlatFootedArmorClass(flatfooted);*/
        if(initiativemisc != characterSheet.getInitiativeMiscModifier())
            characterSheet.setInitiativeMiscModifier(initiativemisc);

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
        armorClassValueLabel.setText(Integer.toString(characterSheet.getArmorClass()));
        armorBonusField.setValue(characterSheet.getArmorBonus());
        shieldBonusField.setValue(characterSheet.getShieldBonus());
        dexterityModifierValueLabel.setText((Integer.toString(characterSheet.getDexterityModifier())));
        sizeModifierValueLabel.setText(Integer.toString(characterSheet.getSizeModifier()));
        miscModifierField.setValue(characterSheet.getArmorClassMiscModifier());

        //Added by Archana for missing fields
        naturalarmorField.setValue(characterSheet.getNaturalArmor());
        deflectionmodifierField.setValue(characterSheet.getDeflectionModifier());
        damagereductionField.setValue(characterSheet.getDamageReduction());
        touchValueLabel.setText(Integer.toString(characterSheet.getTouchArmorClass()));
        flatfootedValueLabel.setText(Integer.toString(characterSheet.getFlatFootedArmorClass()));
        initiativedexmodifierField.setValue(characterSheet.getDexterityModifier());
        initiativemismodifierField.setValue(characterSheet.getInitiativeMiscModifier());
        initiativetotalValueLabel.setText(characterSheet.getTotalInitiative());
    }
}
