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
        setLayout(new GridLayout(2, 2));
        add(currentHitpointsLabel);
        add(maxHitpointsLabel);
        add(currentHitpointsField);
        add(maxHitpointsField);

    }

    private void initializeWidgets() {
        currentHitpointsLabel = new JLabel("Current HP");
        maxHitpointsLabel = new JLabel("Max HP");
        currentHitpointsField = new JSpinner(new SpinnerNumberModel(30, -10, 999, 1));
        currentHitpointsField.addChangeListener(refreshListener);
        maxHitpointsField = new JSpinner(new SpinnerNumberModel(30, 0, 999, 1));
        maxHitpointsField.addChangeListener(refreshListener);
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

        if (currentHitpoints != characterSheet.getCurrentHitpoints()) {
            characterSheet.setCurrentHitpoints(currentHitpoints);
        }

        if (maxHitpoints != characterSheet.getMaxHitpoints()) {
            characterSheet.setMaxHitpoints(maxHitpoints);
        }

        load(characterSheet);

        return characterSheet;
    }


}
