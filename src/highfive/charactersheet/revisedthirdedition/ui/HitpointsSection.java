package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class HitpointsSection extends Section {
    private JLabel currentHitpointsLabel;
    private JSpinner currentHitpointsField;
    private JLabel maxHitpointsLabel;
    private JSpinner maxHitpointsField;

    //Added by Archana for missing fields
    private JLabel totalHPLabel;
    private JLabel totalHPValueLabel;
    private JLabel nonlethaldamageLabel;
    private JLabel hpSpeedLabel;
    private JSpinner  nonlethaldamageField;
    private JTextField hpSpeedField;

    private ChangeListener refreshListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            updateParent();

        }
    };

    public HitpointsSection(String title) {
        super(title);
        initializeWidgets();
        assembleWidgets();
    }

    private void assembleWidgets() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(new GridBagLayout());

        //row 0
        // panel.add(totalHPLabel,new CommonFunctions().setGridConstraints(0.5, 0, 0));
        panel.add(maxHitpointsLabel,new CommonFunctions().setGridConstraints(0.5, 1, 0));
        panel.add(currentHitpointsLabel,new CommonFunctions().setGridConstraints(0.5, 2, 0));
        panel.add(nonlethaldamageLabel,new CommonFunctions().setGridConstraints(0.5, 3, 0));
        panel.add(hpSpeedLabel,new CommonFunctions().setGridConstraints(0.5, 4, 0));
        //row 1
        //panel.add(totalHPValueLabel,new CommonFunctions().setGridConstraints(0.5, 0, 1));
        panel.add(maxHitpointsField,new CommonFunctions().setGridConstraints(0.5, 1, 1));
        panel.add(currentHitpointsField,new CommonFunctions().setGridConstraints(0.5, 2, 1));
        panel.add(nonlethaldamageField,new CommonFunctions().setGridConstraints(0.5, 3, 1));
        panel.add(hpSpeedField,new CommonFunctions().setGridConstraints(0.5, 4, 1));

        add(panel);
    }

    private void initializeWidgets() {
        currentHitpointsLabel = new JLabel("Current HP");
        maxHitpointsLabel = new JLabel("Max HP");
        currentHitpointsField = new JSpinner(new SpinnerNumberModel(30, -10, 999, 1));
        currentHitpointsField.addChangeListener(refreshListener);
        maxHitpointsField = new JSpinner(new SpinnerNumberModel(30, 0, 999, 1));
        maxHitpointsField.addChangeListener(refreshListener);

        //Added by Archana for missing fields
        totalHPLabel = new JLabel("Total");
        totalHPValueLabel = new JLabel();
        nonlethaldamageLabel = new JLabel("Nonlethal Damage");
        hpSpeedLabel = new JLabel("Speed");
        nonlethaldamageField = new JSpinner(new SpinnerNumberModel(0,0,10, 1));
        nonlethaldamageField.addChangeListener(refreshListener);
        hpSpeedField = new JTextField();
    }

    @Override
    public void load(CharacterSheet characterSheet) {
        if (!characterSheet.getClass().equals(RevisedThirdEditionCharacterSheet.class)) {
            throw new ClassCastException();
        }
        load((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private void load(RevisedThirdEditionCharacterSheet characterSheet) {
        currentHitpointsField.setValue(characterSheet.getCurrentHitpoints());
        maxHitpointsField.setValue(characterSheet.getMaxHitpoints());

        //Added by Archana for missing fields
        nonlethaldamageField.setValue(characterSheet.getNonlethaldamage());
        hpSpeedField.setText(characterSheet.getHpspeed());
        totalHPValueLabel.setText((String)characterSheet.getTotalhp());
    }

    @Override
    public CharacterSheet update(CharacterSheet characterSheet) {
        if (!characterSheet.getClass().equals(RevisedThirdEditionCharacterSheet.class)) {
            throw new ClassCastException();
        }
        return update((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private RevisedThirdEditionCharacterSheet update (RevisedThirdEditionCharacterSheet characterSheet) {

        int currentHitpoints = (Integer)currentHitpointsField.getValue();
        int maxHitpoints = (Integer)maxHitpointsField.getValue();
        //Added by Archana for missing fields
        int  nonlethaldamage = (Integer)nonlethaldamageField.getValue();
        String hpspeed = hpSpeedField.getText();


        if (currentHitpoints != characterSheet.getCurrentHitpoints()) {
            characterSheet.setCurrentHitpoints(currentHitpoints);
        }

        if (maxHitpoints != characterSheet.getMaxHitpoints()) {
            characterSheet.setMaxHitpoints(maxHitpoints);
        }
        //Added by Archana for missing fields
        if(nonlethaldamage != characterSheet.getNonlethaldamage())
            characterSheet.setNonlethaldamage(nonlethaldamage);
        if(hpspeed != characterSheet.getHpspeed())
            characterSheet.setHpspeed(hpspeed);

        load(characterSheet);

        return characterSheet;
    }


}
