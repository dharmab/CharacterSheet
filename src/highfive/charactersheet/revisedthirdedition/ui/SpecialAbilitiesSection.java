package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;
import highfive.charactersheet.revisedthirdedition.models.SpecialAbility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;


public class SpecialAbilitiesSection extends Section{

    private HashSet<SpecialAbility> specialAbilities;
    private JButton addSpecialAbilityButton;
    private JPanel specialAbilitiesPanel;


    public SpecialAbilitiesSection(String title) {
        super(title);
        initializeWidgets();
        assembleWidgets();
    }

    private void initializeWidgets() {
        addSpecialAbilityButton = new JButton("Add");
        addSpecialAbilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addSpecialAbilityDialog();
            }
        });
        specialAbilitiesPanel = new JPanel();
    }

    private void assembleWidgets() {
        add(specialAbilitiesPanel);
        add(addSpecialAbilityButton);
    }

    private void editSpecialAbilityDialog(SpecialAbility specialAbility) {
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField nameField = new JTextField(specialAbility.getName());
        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel descLabel = new JLabel("Description");
        descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea descField = new JTextArea(specialAbility.getDescription());
        descField.setColumns(40);
        descField.setRows(30);
        descField.setLineWrap(true);
        descField.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(descLabel);
        panel.add(descField);

        boolean showAgain = true;
        do {
            int option = JOptionPane.showConfirmDialog(null, panel, "Edit Special Ability", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String newName = nameField.getText();
                String newDesc = descField.getText();

                SpecialAbility newSpecialAbility = new SpecialAbility();
                newSpecialAbility.setName(newName);

                if (newDesc == null || newDesc.equals("")) {
                    newSpecialAbility.setDescription("No description provided.");
                } else {
                    newSpecialAbility.setDescription(newDesc);
                }

                if (newSpecialAbility.getName() == null || newSpecialAbility.getName().equals("")) {
                    JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "Special ability must have a name.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (specialAbilities.contains(newSpecialAbility)) {
                    JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "Special ability must have a unique name.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    specialAbilities.add(newSpecialAbility);
                    updateParent();
                    showAgain = false;
                }
            } else {
                showAgain = false;
            }
        } while (showAgain);
    }

    private void addSpecialAbilityDialog() {
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField nameField = new JTextField();
        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextArea descField = new JTextArea();

        JLabel descLabel = new JLabel("Description");
        descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        descField.setColumns(40);
        descField.setRows(30);
        descField.setLineWrap(true);
        descField.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(descLabel);
        panel.add(descField);

        boolean showAgain = true;
        do {
            int option = JOptionPane.showConfirmDialog(null, panel, "New Special Ability", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String newName = nameField.getText();
                String newDesc = descField.getText();

                SpecialAbility newSpecialAbility = new SpecialAbility();
                newSpecialAbility.setName(newName);

                if (newDesc == null || newDesc.equals("")) {
                    newSpecialAbility.setDescription("No description provided.");
                } else {
                    newSpecialAbility.setDescription(newDesc);
                }

                if (newSpecialAbility.getName() == null || newSpecialAbility.getName().equals("")) {
                    JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "New special ability must have a name.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (specialAbilities.contains(newSpecialAbility)) {
                    JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "New special ability must have a unique name.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    specialAbilities.add(newSpecialAbility);
                    updateParent();
                    showAgain = false;
                }
            } else {
                showAgain = false;
            }
        } while (showAgain);
    }

    private void removeSpecialAbilityDialog(SpecialAbility specialAbility) {
        specialAbilities.remove(specialAbility);
        updateParent();
    }

    private void rebuild() {
        specialAbilitiesPanel.removeAll();
        specialAbilitiesPanel.setLayout(new BoxLayout(specialAbilitiesPanel, BoxLayout.Y_AXIS));
        for (final SpecialAbility specialAbility : specialAbilities) {
            JPanel featPanel = new JPanel();
            featPanel.setLayout(new BoxLayout(featPanel, BoxLayout.Y_AXIS));

            JLabel featNameLabel = new JLabel(specialAbility.getName());
            featNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            featPanel.add(featNameLabel);

            JButton editButton = new JButton("Edit");
            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    editSpecialAbilityDialog(specialAbility);
                }
            });

            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    removeSpecialAbilityDialog(specialAbility);
                }
            });

            JPanel buttonsPanel = new JPanel();
            buttonsPanel.add(editButton);
            buttonsPanel.add(removeButton);

            JPanel featTitlePanel = new JPanel(new BorderLayout());
            featTitlePanel.add(buttonsPanel, BorderLayout.EAST);
            featTitlePanel.add(featNameLabel, BorderLayout.WEST);
            featTitlePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

            JTextArea featDescriptionText = new JTextArea();
            featDescriptionText.setText(specialAbility.getDescription());
            featDescriptionText.setEditable(false);
            featDescriptionText.setLineWrap(true);
            featDescriptionText.setAlignmentX(Component.LEFT_ALIGNMENT);

            featPanel.add(featTitlePanel);
            featPanel.add(featDescriptionText);
            featPanel.add(new JLabel("")); // spacing

            specialAbilitiesPanel.add(featPanel);
        }
    }

    @Override
    public CharacterSheet update(CharacterSheet characterSheet) {
        if (!characterSheet.getClass().equals(RevisedThirdEditionCharacterSheet.class)) {
            throw new ClassCastException();
        }
        return update((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private RevisedThirdEditionCharacterSheet update(RevisedThirdEditionCharacterSheet characterSheet) {
        if (specialAbilities != null) {
            characterSheet.setSpecialAbilities(specialAbilities);
        }
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
        specialAbilities = characterSheet.getSpecialAbilities();
        rebuild();
    }
}
