package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.Alignment;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;
import highfive.charactersheet.revisedthirdedition.models.Size;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BiographySection extends Section {
    private JLabel characterNameLabel;
    private JLabel playerNameLabel;
    private JLabel classLabel;
    private JLabel levelLabel;
    private JLabel raceLabel;
    private JLabel alignmentLabel;
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

    private FocusListener FocusRefreshListener = new FocusListener() {
        @Override
        public void focusGained(FocusEvent focusEvent) {

        }

        @Override
        public void focusLost(FocusEvent focusEvent) {
            refreshParent();
        }
    };

    private ActionListener actionRefreshListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            refreshParent();
        }
    };

    private ChangeListener changeRefreshListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            refreshParent();
        }
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
        alignmentLabel = new JLabel("Alignment");
        deityLabel = new JLabel("Deity");
        sizeLabel = new JLabel("Size");

        characterNameField = new JTextField(5);
        characterNameField.addFocusListener(FocusRefreshListener);
        playerNameField = new JTextField(5);
        playerNameField.addFocusListener(FocusRefreshListener);
        classField = new JTextField(5);
        classField.addFocusListener(FocusRefreshListener);
        levelField = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        levelField.addChangeListener(changeRefreshListener);
        raceField = new JTextField(5);
        raceField.addFocusListener(FocusRefreshListener);
        alignmentField = new JComboBox(ALIGNMENTS);
        alignmentField.setEditable(false);
        alignmentField.setSelectedItem("Neutral");
        alignmentField.addActionListener(actionRefreshListener);
        deityField = new JTextField(5);
        deityField.addFocusListener(FocusRefreshListener);
        sizeField = new JComboBox(SIZES);
        sizeField.setSelectedItem("Medium");
        sizeField.addActionListener(actionRefreshListener);
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
        add(alignmentLabel);
        add(alignmentField);
        add(deityLabel);
        add(deityField);
        add(sizeLabel);
        add(sizeField);
    }

    private void refreshParent() {
        ((RevisedThirdEditionCharacterSheetView)this.getParent()).refresh();
    }

    @Override
    public CharacterSheet refresh(CharacterSheet characterSheet) {
        return refresh((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private RevisedThirdEditionCharacterSheet refresh(RevisedThirdEditionCharacterSheet characterSheet) {
        String characterName = characterNameField.getText();
        String playerName = playerNameField.getText();
        String characterClass = classField.getText();
        int level = (Integer) levelField.getValue();
        String race = raceField.getText();
        Alignment alignment = parseAlignment((String)alignmentField.getSelectedItem());
        String deity = deityField.getText();
        Size size = parseSize((String)sizeField.getSelectedItem());

        if (!characterSheet.getCharacterName().equals(characterName)) {
            characterSheet.setCharacterName(characterName);
        }

        if (!characterSheet.getPlayerName().equals(playerName)) {
            characterSheet.setPlayerName(playerName);
        }

        if (!characterSheet.getCharacterClass().equals(characterClass)) {
            characterSheet.setCharacterClass(characterClass);
        }

        if (characterSheet.getLevel() != level) {
            characterSheet.setLevel(level);
        }

        if (!characterSheet.getRace().equals(race)) {
            characterSheet.setRace(race);
        }

        if (!characterSheet.getAlignment().equals(alignment)) {
            characterSheet.setAlignment(alignment);
        }

        if (!characterSheet.getDeity().equals(deity)) {
            characterSheet.setDeity(deity);
        }

        if (characterSheet.getSize() != size) {
            characterSheet.setSize(size);
        }

        characterNameField.setText(characterSheet.getCharacterName());
        playerNameField.setText(characterSheet.getPlayerName());
        classField.setText(characterSheet.getCharacterClass());
        levelField.setValue(characterSheet.getLevel());
        raceField.setText(characterSheet.getRace());
        alignmentField.setSelectedItem(parseAlignment(characterSheet.getAlignment()));
        deityField.setText(characterSheet.getDeity());
        sizeField.setSelectedItem(parseSize(size));

        return characterSheet;
    }

    private Alignment parseAlignment(String s) {
        if (s.equals("Lawful Good")) {
            return Alignment.LAWFUL_GOOD;
        } else if (s.equals("Lawful Neutral")) {
            return Alignment.LAWFUL_NEUTRAL;
        } else if (s.equals("Lawful Evil")) {
            return Alignment.LAWFUL_EVIL;
        } else if (s.equals("Neutral Good")) {
            return Alignment.NEUTRAL_GOOD;
        } else if (s.equals("Neutral")) {
            return Alignment.NEUTRAL;
        } else if (s.equals("Neutral Evil")) {
            return Alignment.NEUTRAL_EVIL;
        } else if (s.equals("Chaotic Good")) {
            return Alignment.CHAOTIC_GOOD;
        } else if (s.equals("Chaotic Neutral")) {
            return Alignment.CHAOTIC_NEUTRAL;
        } else if (s.equals("Chaotic Evil")) {
            return Alignment.CHAOTIC_EVIL;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String parseAlignment(Alignment alignment) {
        switch (alignment) {
            case LAWFUL_GOOD:
                return "Lawful Good";
            case LAWFUL_NEUTRAL:
                return "Lawful Neutral";
            case LAWFUL_EVIL:
                return "Lawful Evil";
            case NEUTRAL_GOOD:
                return "Neutral Good";
            case NEUTRAL:
                return "Neutral";
            case NEUTRAL_EVIL:
                return "Neutral Evil";
            case CHAOTIC_GOOD:
                return "Chaotic Good";
            case CHAOTIC_NEUTRAL:
                return "Chaotic Neutral";
            case CHAOTIC_EVIL:
                return "Chaotic Evil";
            default:
                throw new IllegalArgumentException();
        }
    }

    private Size parseSize(String s) {
        if (s.equals("Fine")) {
            return Size.FINE;
        } else if (s.equals("Diminutive")) {
            return Size.DIMINUTIVE;
        } else if (s.equals("Tiny")) {
            return Size.TINY;
        } else if (s.equals("Small")) {
            return Size.SMALL;
        } else if (s.equals("Medium")) {
            return Size.MEDIUM;
        } else if (s.equals("Large")) {
            return Size.LARGE;
        } else if (s.equals("Huge")) {
            return Size.HUGE;
        } else if (s.equals("Gargantuan")) {
            return Size.GARGANTUAN;
        } else if (s.equals("Colossal")) {
            return Size.COLOSSAL;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String parseSize(Size size) {
        switch(size) {
            case FINE:
                return "Fine";
            case DIMINUTIVE:
                return "Diminutive";
            case TINY:
                return "Tiny";
            case SMALL:
                return "Small";
            case MEDIUM:
                return "Medium";
            case LARGE:
                return "Large";
            case HUGE:
                return "Huge";
            case GARGANTUAN:
                return "Gargantuan";
            case COLOSSAL:
                return "Colossal";
            default:
                throw new IllegalArgumentException();
        }
    }
}
