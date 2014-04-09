package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;

import javax.swing.*;
import java.awt.*;

/**
 * A sample character sheet section to illustrate implementation
 */
public class SampleSection extends Section {

    private JLabel label;
    private JTextField textField;

    /**
     * Constructor assembles the content pane
     */
    public SampleSection(String title) {
        super(title); // Call the superclass constructor to set up the JXTaskPane
        initializeWidgets();
        assemblePanel();
    }

    private void initializeWidgets() {
        label = new JLabel("Sample Label");
        textField = new JTextField();
        textField.setMinimumSize(new Dimension(20, 50));
    }

    private void assemblePanel() {
        add(label);
        add(textField);
    }

    @Override
    public CharacterSheet refresh(CharacterSheet characterSheet) {
        return null;
    }
}
