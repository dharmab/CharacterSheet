package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.Alignment;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;
import highfive.charactersheet.revisedthirdedition.models.Size;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
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
    //Added by Archana for missing fields
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel heightLabel;
    private JLabel weightLabel;
    private JLabel eyesLabel;
    private JLabel hairLabel;
    private JLabel skinLabel;

    private JSpinner ageField;
    private JTextField genderField;
    private JSpinner heightField;
    private JSpinner weightField;
    private JTextField eyesField;
    private JTextField hairField;
    private JTextField skinField;

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

        //Added by Archana for missing fields
        ageLabel = new JLabel("Age");
        genderLabel = new JLabel("Gender");
        heightLabel = new JLabel("Height");
        weightLabel = new JLabel("Weight");
        eyesLabel = new JLabel("Eyes");
        hairLabel = new JLabel("Hair");
        skinLabel = new JLabel("Skin");
        ageField = new JSpinner(new SpinnerNumberModel(14, 14, 300, 1));//value,min,max,stepsize
        ageField.addFocusListener(FocusRefreshListener);
        genderField = new JTextField(5);
        genderField.addFocusListener(FocusRefreshListener);
        heightField = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        heightField.addFocusListener(FocusRefreshListener);
        weightField = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        weightField.addFocusListener(FocusRefreshListener);
        eyesField = new JTextField(5);
        eyesField.addFocusListener(FocusRefreshListener);
        hairField = new JTextField(5);
        hairField.addFocusListener(FocusRefreshListener);
        skinField = new JTextField(5);
        skinField.addFocusListener(FocusRefreshListener);
    }

    private void assembleWidgets() {
        add(designPanel());
    }

    @Override
    public CharacterSheet update(CharacterSheet characterSheet) {
        if (!characterSheet.getClass().equals(RevisedThirdEditionCharacterSheet.class)) {
            throw new ClassCastException();
        }
        return update((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private RevisedThirdEditionCharacterSheet update(RevisedThirdEditionCharacterSheet characterSheet) {
        String characterName = characterNameField.getText();
        String playerName = playerNameField.getText();
        String characterClass = classField.getText();
        int level = (Integer) levelField.getValue();
        String race = raceField.getText();
        Alignment alignment = parseAlignment((String)alignmentField.getSelectedItem());
        String deity = deityField.getText();
        Size size = parseSize((String)sizeField.getSelectedItem());

        // Added by Archana
        int age = (Integer) ageField.getValue();
        String gender =  genderField.getText();
        int height = (Integer)heightField.getValue();
        int weight =  (Integer) weightField.getValue();
        String eyes = eyesField.getText();
        String hair = hairField.getText();
        String skin = skinField.getText();

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

        //Added by Archana
        if(characterSheet.getAge() != age)
            characterSheet.setAge(age);
        if(characterSheet.getGender() != gender)
            characterSheet.setGender(gender);
        if(characterSheet.getHeight() != height)
            characterSheet.setHeight(height);
        if(characterSheet.getWeight() != weight)
            characterSheet.setWeight(weight);
        if(characterSheet.getEyes() != eyes)
            characterSheet.setEyes(eyes);
        if(characterSheet.getHair() != hair)
            characterSheet.setHair(hair);
        if(characterSheet.getSkin() != skin)
            characterSheet.setSkin(skin);

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
        characterNameField.setText(characterSheet.getCharacterName());
        playerNameField.setText(characterSheet.getPlayerName());
        classField.setText(characterSheet.getCharacterClass());
        levelField.setValue(characterSheet.getLevel());
        raceField.setText(characterSheet.getRace());
        alignmentField.setSelectedItem(parseAlignment(characterSheet.getAlignment()));
        deityField.setText(characterSheet.getDeity());
        sizeField.setSelectedItem(parseSize(characterSheet.getSize()));

        // Added by Archana
        ageField.setValue(characterSheet.getAge());
        genderField.setText(characterSheet.getGender());
        heightField.setValue(characterSheet.getHeight());
        weightField.setValue(characterSheet.getWeight());
        eyesField.setText(characterSheet.getEyes());
        hairField.setText(characterSheet.getHair());
        skinField.setText(characterSheet.getSkin());
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

    private JPanel designPanel()
    {
        //----------------------------------------START OF NAME PANEL----------------------------------------------------------
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setLayout(new GridBagLayout());

        //row 0
        panel1.add(characterNameLabel,new CommonFunctions().setGridConstraints(0.5, 0, 0));
        panel1.add(playerNameLabel,new CommonFunctions().setGridConstraints(0.5, 1, 0));
        //row 1
        panel1.add(characterNameField,new CommonFunctions().setGridConstraints(0.5, 0, 1));
        panel1.add(playerNameField,new CommonFunctions().setGridConstraints(0.5, 1, 1));

        //----------------------------------------END OF NAME PANEL-------------------------------------------------------------

        //----------------------------------------START OF CLASS PANEL----------------------------------------------------------
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setLayout(new GridBagLayout());

        //row 0
        panel2.add(classLabel,new CommonFunctions().setGridConstraints(0.5, 0, 0));
        panel2.add(levelLabel,new CommonFunctions().setGridConstraints(0.5, 1, 0));
        panel2.add(raceLabel,new CommonFunctions().setGridConstraints(0.5, 2, 0));
        panel2.add(alignmentLabel,new CommonFunctions().setGridConstraints(0.5, 3, 0));
        panel2.add(deityLabel,new CommonFunctions().setGridConstraints(0.5, 4, 0));
        //row 1
        panel2.add(classField,new CommonFunctions().setGridConstraints(0.5, 0, 1));
        panel2.add(levelField,new CommonFunctions().setGridConstraints(0.5, 1, 1));
        panel2.add(raceField,new CommonFunctions().setGridConstraints(0.5, 2, 1));
        panel2.add(alignmentField,new CommonFunctions().setGridConstraints(0.5, 3, 1));
        panel2.add(deityField,new CommonFunctions().setGridConstraints(0.5, 4, 1));

        //----------------------------------------END OF CLASS PANEL----------------------------------------------------------

        //----------------------------------------START OF SIZE PANEL----------------------------------------------------------
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setLayout(new GridBagLayout());

        //row 0
        panel3.add(sizeLabel,new CommonFunctions().setGridConstraints(0.5, 0, 0));
        panel3.add(ageLabel,new CommonFunctions().setGridConstraints(0.5, 1, 0));
        panel3.add(genderLabel,new CommonFunctions().setGridConstraints(0.5, 2, 0));
        panel3.add(heightLabel,new CommonFunctions().setGridConstraints(0.5, 3, 0));
        panel3.add(weightLabel,new CommonFunctions().setGridConstraints(0.5, 4, 0));
        panel3.add(eyesLabel,new CommonFunctions().setGridConstraints(0.5, 5, 0));
        panel3.add(hairLabel,new CommonFunctions().setGridConstraints(0.5, 6, 0));
        panel3.add(skinLabel,new CommonFunctions().setGridConstraints(0.5, 7, 0));

        //row 1
        panel3.add(sizeField,new CommonFunctions().setGridConstraints(0.5, 0, 1));
        panel3.add(ageField,new CommonFunctions().setGridConstraints(0.5, 1, 1));
        panel3.add(genderField,new CommonFunctions().setGridConstraints(0.5, 2, 1));
        panel3.add(heightField,new CommonFunctions().setGridConstraints(0.5, 3, 1));
        panel3.add(weightField,new CommonFunctions().setGridConstraints(0.5, 4, 1));
        panel3.add(eyesField,new CommonFunctions().setGridConstraints(0.5, 5, 1));
        panel3.add(hairField,new CommonFunctions().setGridConstraints(0.5, 6, 1));
        panel3.add(skinField,new CommonFunctions().setGridConstraints(0.5, 7, 1));

        //----------------------------------------END OF CLASS PANEL----------------------------------------------------------

        JPanel finalPanel = new JPanel(new BorderLayout());
        finalPanel.setLayout(new GridLayout(3, 0));
        finalPanel.add(panel1);
        finalPanel.add(panel2);
        finalPanel.add(panel3);

        return finalPanel;
    }

}
