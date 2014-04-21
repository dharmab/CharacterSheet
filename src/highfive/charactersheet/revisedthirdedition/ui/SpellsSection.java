package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;
import highfive.charactersheet.revisedthirdedition.models.SpellBook;
import org.jdesktop.swingx.VerticalLayout;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcus on 4/18/2014.
 */
public class SpellsSection extends Section {
    private HashMap<String, SpellBook> spellBooks;
    private int spellFailure;

    public SpellsSection(String title) {
        super(title);
    }

    private void rebuild() {
        removeAll();
        setLayout(new GridLayout(0, 1));
        JButton addSpellBookButton = new JButton("Add New Spellbook");
        addSpellBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newSpellBookFrame = createSpellbookFrame();
                newSpellBookFrame.setVisible(true);
                updateParent();
            }
        });
        for (Map.Entry<String, SpellBook> entry : spellBooks.entrySet()) {
            final String key = entry.getKey();
            final SpellBook value = entry.getValue();
            final JPanel spellsPerDayPanel = new JPanel(new GridLayout(0, 1));
            final JPanel spellsPerDayTable = new JPanel(new GridLayout(0, 2));
            final JPanel preparedSpellsPanel;
            final JPanel domainSpellsPanel;
            final JPanel specialtySchoolPanel;
            final JPanel spellFailureFieldPanel;
            final JButton deleteSpellBookButton = new JButton("Delete Above Spellbook");
            deleteSpellBookButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    spellBooks.remove(key);
                    updateParent();
                }
            });
            add(new JLabel(key));
            for (int i = 0; i < 10; i++) {
                final int n = i;
                spellsPerDayTable.add(new JLabel(Integer.toString(i)));
                final JTextField spellsPerDayNumber = new JTextField();
                spellsPerDayNumber.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        //nothing
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        value.setSpellsPerDay(n, Integer.parseInt(spellsPerDayNumber.getText()));
                    }
                });
                spellsPerDayTable.add(spellsPerDayNumber);
                final JButton seeListButton = new JButton("See List");
                seeListButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JPanel spellBookDialogBox = createSpellDialogBox();
                        updateParent();
                    }
                });
            }
            spellsPerDayPanel.add(new JLabel("Spells Known"));
            spellsPerDayPanel.add(spellsPerDayTable);
            add(spellsPerDayPanel);
            if (value.hasPreparedSpells()) {
                preparedSpellsPanel = new JPanel(new VerticalLayout());
                JPanel preparedSpellsTablePanel = new JPanel(new GridLayout(10, 4));
                for (int i = 0; i < 10; i++) {
                    final int n = i;
                    spellsPerDayTable.add(new JLabel(Integer.toString(n)));
                }
                preparedSpellsPanel.add(preparedSpellsTablePanel);
                add(preparedSpellsPanel);
            }
            if (value.hasDomains()) {
                domainSpellsPanel = new JPanel(new GridLayout(0, 10));
                //@TODO create domain panel
                add(domainSpellsPanel);
            }
            if (value.hasSpecialtySchools()) {
                specialtySchoolPanel = new JPanel(new GridLayout(0, 10));
                //@TODO create specialty panel
                add(specialtySchoolPanel);
            }
            if (value.hasSpellFailure()) {
                spellFailureFieldPanel = new JPanel(new GridLayout(0, 10));
                //@TODO create spell failure panel
                add(spellFailureFieldPanel);
            }
            add(deleteSpellBookButton);
        }
        add(addSpellBookButton);
    }

    @Override
    public CharacterSheet update(CharacterSheet characterSheet) {
        if (!characterSheet.getClass().equals(RevisedThirdEditionCharacterSheet.class)) {
            throw new ClassCastException();
        }
        return update((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private RevisedThirdEditionCharacterSheet update(RevisedThirdEditionCharacterSheet characterSheet) {
        if (spellBooks != null) {
            characterSheet.setSpellBooks(spellBooks);
            characterSheet.setSpellFailure(spellFailure);
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
        spellBooks = characterSheet.getSpellBooks();
        spellFailure = characterSheet.getSpellFailure();
        rebuild();
    }

    private JPanel createSpellDialogBox() {
        //@TODO
        return new JPanel();
    }

    private JFrame createSpellbookFrame() {
        final JFrame spellBookFrame = new JFrame("Add New Spellbook");
        spellBookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        final JLabel spellbookNameLabel = new JLabel("What would you like to call this spellbook?");
        final JTextField spellbookName = new JTextField();
        final JCheckBox preparedSpellsBox = new JCheckBox("Does it prepare spells? (divine casting and wizards)");
        final JCheckBox domainsBox = new JCheckBox("Does it have domains? (clerics)");
        final JCheckBox specialtySchoolBox = new JCheckBox("Does it have a specialty/prohibed school? (wizards)");
        final JCheckBox arcaneSpellFailureBox = new JCheckBox("Does it have arcane spell failure? (arcane casting)");
        JButton doneButton = new JButton("Create");
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spellBooks.put(spellbookName.getText(), new SpellBook(
                        preparedSpellsBox.isSelected(),
                        domainsBox.isSelected(),
                        specialtySchoolBox.isSelected(),
                        arcaneSpellFailureBox.isSelected()
                ));
                updateParent();
                spellBookFrame.dispose();
            }
        });
        panel.add(spellbookNameLabel);
        panel.add(spellbookName);
        panel.add(new JLabel("How does your character cast spells?"));
        panel.add(preparedSpellsBox);
        panel.add(domainsBox);
        panel.add(specialtySchoolBox);
        panel.add(arcaneSpellFailureBox);
        panel.add(doneButton);
        spellBookFrame.add(panel);
        return spellBookFrame;
    }
}
