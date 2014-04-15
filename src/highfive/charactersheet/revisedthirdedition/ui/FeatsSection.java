package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.Feat;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;

public class FeatsSection extends Section {

    private HashSet<Feat> feats;
    private JButton addFeatButton;
    private JButton editFeatButton;
    private JComboBox<String> featComboBox;
    private JPanel cardPanel;
    private ItemListener cardListener = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            CardLayout layout = (CardLayout) cardPanel.getLayout();
            layout.show(cardPanel, (String) itemEvent.getItem());
        }
    };

    public FeatsSection(String title) {
        super(title);
        initializeWidgets();
        assembleWidgets();
    }

    private void assembleWidgets() {
        add(featComboBox);
        add(addFeatButton);
        add(editFeatButton);
        add(cardPanel);
    }

    private void initializeWidgets() {
        addFeatButton = new JButton("Add");
        editFeatButton = new JButton("Edit");
        featComboBox = new JComboBox<String>();
        featComboBox.addItemListener(cardListener);
        cardPanel = new JPanel(new CardLayout());
    }

    private void rebuild() {
        featComboBox.removeAllItems();
        cardPanel.removeAll();
        for (Feat feat : feats) {
            featComboBox.addItem(feat.getName());

            JPanel card = new JPanel();

            JLabel featNameLabel = new JLabel(feat.getName());
            card.add(featNameLabel);

            JTextArea featDescriptionText = new JTextArea();
            featDescriptionText.setText(feat.getDescription());
            featDescriptionText.setEditable(false);
            card.add(featDescriptionText);

            cardPanel.add(feat.getName(), card);
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
