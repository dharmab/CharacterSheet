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

public class AttackSection extends Section {
    private JLabel attackLabel;
    private JLabel attackbonusLabel;
    private JLabel damageLabel;
    private JLabel criticalLabel;
    private JLabel rangeLabel;
    private JLabel typeLabel;
    private JLabel notesLabel;
    private JLabel sizeLabel;

    private JTextField attackField;
    private JTextField attackbonusField;
    private JTextField damageField;
    private JTextField criticalField;
    private JTextField rangeField;
    private JTextField typeField;
    private JTextField notesField;
    //private JComboBox sizeField;

    private String[] ALIGNMENTS = {
            "Lawful Good", "Lawful Neutral", "Lawful Evil",
            "Neutral Good", "Neutral", "Neutral Evil",
            "Chaotic Good", "Chaotic Neutral", "Chaotic Evil"
    };

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
            updateParent();
        }
    };

    private ActionListener actionRefreshListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            updateParent();
        }
    };

    private ChangeListener changeRefreshListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            updateParent();
        }
    };

    public AttackSection(String title) {
        super(title);
        initializeWidgets();
        assembleWidgets();
    }

    private void initializeWidgets() {
        attackLabel = new JLabel("Attack");
        attackbonusLabel = new JLabel("Attack Bonus");
        damageLabel = new JLabel("Damage");
        criticalLabel = new JLabel("Critical");
        rangeLabel = new JLabel("Range");
        typeLabel = new JLabel("Type");
        notesLabel = new JLabel("Notes");
        //sizeLabel = new JLabel("Size");

        attackField = new JTextField(5);
        attackField.addFocusListener(FocusRefreshListener);
        attackbonusField = new JTextField(5);
        attackbonusField.addFocusListener(FocusRefreshListener);
        damageField = new JTextField(5);
        damageField.addFocusListener(FocusRefreshListener);
        criticalField = new JTextField(5);
        criticalField.addFocusListener(FocusRefreshListener);
        rangeField = new JTextField(5);
        rangeField.addFocusListener(FocusRefreshListener);
        typeField = new JTextField(5);
        typeField.addFocusListener(FocusRefreshListener);
        notesField = new JTextField(5);
        notesField.addFocusListener(FocusRefreshListener);
        //sizeField = new JComboBox(SIZES);
        //sizeField.setSelectedItem("Medium");
        //sizeField.addActionListener(actionRefreshListener);
    }

    private void assembleWidgets() {
        add(attackLabel);
        add(attackField);
        add(attackbonusLabel);
        add(attackbonusField);
        add(damageLabel);
        add(damageField);
        add(criticalLabel);
        add(criticalField);
        add(rangeLabel);
        add(rangeField);
        add(typeLabel);
        add(typeField);
        add(notesLabel);
        add(notesField);
        //add(sizeLabel);
        //add(sizeField);
    }

    @Override
    public CharacterSheet update(CharacterSheet characterSheet) {
        return update((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private RevisedThirdEditionCharacterSheet update(RevisedThirdEditionCharacterSheet characterSheet) {
        String attackValue = attackField.getText();
        String attackBonus = attackbonusField.getText();
        String damageValue = damageField.getText();
        String criticalValue= criticalField.getText();
        String range = rangeField.getText();
        //Alignment alignment = parseAlignment((String)typeField.getSelectedItem());
        String notes = notesField.getText();
        //Size size = parseSize((String)sizeField.getSelectedItem());

        //to be implemented
        /*
        if (!characterSheet.getCharacterName().equals(attackValue)) {
            characterSheet.setCharacterName(attackValue);
        }

        if (!characterSheet.getPlayerName().equals(attackBonus)) {
            characterSheet.setPlayerName(attackBonus);
        }

        if (!characterSheet.getCharacterClass().equals(damageValue)) {
            characterSheet.setCharacterClass(damageValue);
        }

        if (characterSheet.getLevel() != criticalValue) {
            characterSheet.setLevel(criticalValue);
        }

        if (!characterSheet.getRace().equals(range)) {
            characterSheet.setRace(range);
        }


        if (!characterSheet.getDeity().equals(notes)) {
            characterSheet.setDeity(notes);
        }

        //if (characterSheet.getSize() != size) {
         //   characterSheet.setSize(size);
        //}

        */

        load(characterSheet);

        return characterSheet;
    }


    @Override
    public void load(CharacterSheet characterSheet) {
        load((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private void load(RevisedThirdEditionCharacterSheet characterSheet) {
        //need to be implemented

        /*
        attackField.setText(characterSheet.getCharacterName());
        attackbonusField.setText(characterSheet.getPlayerName());
        damageField.setText(characterSheet.getCharacterClass());
        criticalField.setValue(characterSheet.getLevel());
        rangeField.setText(characterSheet.getRace());
        typeField.setSelectedItem(parseAlignment(characterSheet.getAlignment()));
        notesField.setText(characterSheet.getDeity());

        */

        //sizeField.setSelectedItem(parseSize(characterSheet.getSize()));
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
