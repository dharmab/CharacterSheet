package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.Feat;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import javax.swing.*;
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
        JTextField nameField = new JTextField();
        JTextArea descField = new JTextArea();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Feat name:"));
        panel.add(nameField);
        panel.add(new JLabel("Feat description"));
        panel.add(descField);

        boolean showAgain = false;
        do {
            int option = JOptionPane.showConfirmDialog(null, panel, "New Feat", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                Feat newFeat = new Feat();
                newFeat.setName(nameField.getText());
                newFeat.setDescription(descField.getText());

                if (feats.contains(newFeat)) {
                    JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "New feat must have a unique name.", "Error", JOptionPane.ERROR_MESSAGE);
                    showAgain = true;
                } else {
                    feats.add(newFeat);
                    updateParent();
                    showAgain = false;
                }
            }
        } while (showAgain);
    }


    private void rebuild() {
        featPanel.removeAll();
        for (Feat feat : feats) {
            JPanel featCard = new JPanel();
            featCard.setLayout(new BoxLayout(featCard, BoxLayout.Y_AXIS));

            JLabel featNameLabel = new JLabel(feat.getName());
            featCard.add(featNameLabel);

            JTextArea featDescriptionText = new JTextArea();
            featDescriptionText.setText(feat.getDescription());
            featDescriptionText.setEditable(false);
            featCard.add(featDescriptionText);

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
