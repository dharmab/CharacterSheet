package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.Feat;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class FeatsSection extends Section {

    private HashSet<Feat> feats;
    private JButton addFeatButton;
    private JPanel featsPanel;

    public FeatsSection(String title) {
        super(title);
        initializeWidgets();
        assembleWidgets();
    }

    private void initializeWidgets() {
        addFeatButton = new JButton("Add");
        addFeatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addFeatDialog();
            }
        });
        featsPanel = new JPanel();
    }

    private void assembleWidgets() {
        add(featsPanel);
        add(addFeatButton);
    }

    private void editFeatDialog(Feat feat) {
        feats.remove(feat);
        JLabel nameLabel = new JLabel("Feat name:");
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField nameField = new JTextField(feat.getName());
        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel descLabel = new JLabel("Feat description");
        JTextArea descField = new JTextArea(feat.getDescription());
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
            int option = JOptionPane.showConfirmDialog(null, panel, "Edit Feat", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String newFeatName = nameField.getText();
                String newFeatDesc = descField.getText();

                feat.setName(newFeatName);

                if (newFeatDesc == null || newFeatDesc.equals("")) {
                    feat.setDescription("No description provided.");
                } else {
                    feat.setDescription(newFeatDesc);
                }

                if (feat.getName() == null || feat.getName().equals("")) {
                    JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "Feat must have a name.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (feats.contains(feat)) {
                    JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "Feat must have a unique name.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    feats.add(feat);
                    updateParent();
                    showAgain = false;
                }
            } else {
                showAgain = false;
            }
        } while (showAgain);
    }

    private void addFeatDialog() {
        JLabel nameLabel = new JLabel("Feat name:");
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField nameField = new JTextField();
        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextArea descField = new JTextArea();

        JLabel descLabel = new JLabel("Feat description");
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
            int option = JOptionPane.showConfirmDialog(null, panel, "New Feat", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String newFeatName = nameField.getText();
                String newFeatDesc = descField.getText();

                Feat newFeat = new Feat();
                newFeat.setName(newFeatName);

                if (newFeatDesc == null || newFeatDesc.equals("")) {
                    newFeat.setDescription("No description provided.");
                } else {
                    newFeat.setDescription(newFeatDesc);
                }

                if (newFeat.getName() == null || newFeat.getName().equals("")) {
                    JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "New feat must have a name.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (feats.contains(newFeat)) {
                    JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "New feat must have a unique name.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    feats.add(newFeat);
                    updateParent();
                    showAgain = false;
                }
            } else {
                showAgain = false;
            }
        } while (showAgain);
    }

    private void removeFeatDialog(Feat feat) {
        feats.remove(feat);
        updateParent();
    }

    private void rebuild() {
        featsPanel.removeAll();
        featsPanel.setLayout(new BoxLayout(featsPanel, BoxLayout.Y_AXIS));
        for (final Feat feat : feats) {
            JPanel featPanel = new JPanel();
            featPanel.setLayout(new BoxLayout(featPanel, BoxLayout.Y_AXIS));

            JLabel featNameLabel = new JLabel(feat.getName());
            featNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            featPanel.add(featNameLabel);

            JButton editButton = new JButton("Edit");
            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    editFeatDialog(feat);
                }
            });

            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    removeFeatDialog(feat);
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
            featDescriptionText.setText(feat.getDescription());
            featDescriptionText.setEditable(false);
            featDescriptionText.setLineWrap(true);
            featDescriptionText.setAlignmentX(Component.LEFT_ALIGNMENT);

            featPanel.add(featTitlePanel);
            featPanel.add(featDescriptionText);
            featPanel.add(new JLabel("")); // spacing

            featsPanel.add(featPanel);
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
        if (feats != null) {
            characterSheet.setFeats(feats);
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
        feats = (HashSet<Feat>) characterSheet.getFeats();
        rebuild();
    }
}
