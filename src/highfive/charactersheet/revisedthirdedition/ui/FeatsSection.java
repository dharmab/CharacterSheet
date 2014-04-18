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
    private JPanel featPanel;

    public FeatsSection(String title) {
        super(title);
        initializeWidgets();
        assembleWidgets();
    }

    private void assembleWidgets() {
        add(featPanel);
        add(addFeatButton);
    }

    private void initializeWidgets() {
        addFeatButton = new JButton("Add");
        addFeatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addFeatDialog();
            }
        });
        featPanel = new JPanel();
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

    private void rebuild() {
        featPanel.removeAll();
        featPanel.setLayout(new BoxLayout(featPanel, BoxLayout.Y_AXIS));
        for (Feat feat : feats) {
            JPanel featCard = new JPanel();
            featCard.setLayout(new BoxLayout(featCard, BoxLayout.Y_AXIS));

            JLabel featNameLabel = new JLabel(feat.getName());
            featNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            featCard.add(featNameLabel);

            JTextArea featDescriptionText = new JTextArea();
            featDescriptionText.setText(feat.getDescription());
            featDescriptionText.setEditable(false);
            featDescriptionText.setLineWrap(true);
            featDescriptionText.setAlignmentX(Component.LEFT_ALIGNMENT);
            featCard.add(featDescriptionText);
            featCard.add(new JLabel("")); // spacing

            featPanel.add(featCard);
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
