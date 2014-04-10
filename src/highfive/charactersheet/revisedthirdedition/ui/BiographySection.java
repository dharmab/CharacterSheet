package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;

import javax.swing.*;

public class BiographySection extends Section
{
    private JLabel characterNameLabel;
    private JLabel playerNameLabel;
    private JLabel classLabel;
    private JLabel levelLabel;
    private JLabel raceLabel;
    private JLabel alighmentLabel;
    private JLabel deityLabel;
    private JLabel sizeLabel;

    private JTextField characterNameField;
    private JTextField playerNameField;
    private JTextField classField;
    private JSpinner levelField;
    private JTextField raceField;
    private JComboBox alignmentField;
    private String[] ALIGNMENTS = {
            "Lawful Good", "Lawful Neutral", "Lawful Evil",
            "Neutral Good", "Neutral", "Neutral Evil",
            "Chaotic Good", "Chaotic Neutral", "Chaotic Evil"
    };
    private JTextField deityField;
    private JComboBox sizeField;
    private String[] SIZES = {
            "Fine",
            "Diminutive",
            "Tiny",
            "Small",
            "Medium",
            "Large",
            "Huge",
            "Gargantuan",
            "Colossal"
    };

    public BiographySection(String title) {
        super(title);
        initializeWidgets();
        assembleWidgets();
    }

    private void initializeWidgets() {
        characterNameLabel = new JLabel("Character Name");
        playerNameLabel = new JLabel("Player Name");
        classLabel = new JLabel("Class");
        levelLabel = new JLabel("Level");
        raceLabel = new JLabel("Race");
        alighmentLabel = new JLabel("Alignment");
        deityLabel = new JLabel("Deity");
        sizeLabel = new JLabel("Size");

        characterNameField = new JTextField(5);
        playerNameField = new JTextField(5);
        classField = new JTextField(5);
        levelField = new JSpinner();
        raceField = new JTextField(5);
        alignmentField = new JComboBox(ALIGNMENTS);
        alignmentField.setEditable(false);
        deityField = new JTextField(5);
        sizeField = new JComboBox(SIZES);
    }

    private void assembleWidgets() {
        add(characterNameLabel);
        add(characterNameField);
        add(playerNameLabel);
        add(playerNameField);
        add(classLabel);
        add(classField);
        add(levelLabel);
        add(levelField);
        add(raceLabel);
        add(raceField);
        add(alighmentLabel);
        add(alignmentField);
        add(deityLabel);
        add(deityField);
        add(sizeLabel);
        add(sizeField);
    }

    @Override
    public CharacterSheet refresh(CharacterSheet characterSheet) {
        return null;
    }
}
