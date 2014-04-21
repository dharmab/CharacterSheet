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
        setLayout(new GridLayout(spellBooks.size() + 1, 1));
        for (Map.Entry<String, SpellBook> entry : spellBooks.entrySet()) {
            final String key = entry.getKey();
            final SpellBook value = entry.getValue();
            final JPanel spellsPerDayPanel = new JPanel(new VerticalLayout());
            final JPanel spellsPerDayTable = new JPanel(new GridLayout(10, 2));
            final JPanel preparedSpellsPanel;
            final JPanel domainSpellsPanel;
            final JPanel specialtySchoolPanel;
            final JPanel spellFailureFieldPanel;
            for (int i = 0; i < 10; i++) {
                final int n = i;
                spellsPerDayTable.add(new JLabel(Integer.toString(i)));
                final JTextField spellsPerDayNumber = new JTextField(3);
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
                        JPanel spellBookDiaglogBox = createSpellDialogBox();
                    }
                });
            }
            spellsPerDayPanel.add(new JLabel("Spell Book"));
            spellsPerDayPanel.add(spellsPerDayTable);
            add(spellsPerDayPanel);
            if (value.hasPreparedSpells() == true) {
                preparedSpellsPanel = new JPanel(new VerticalLayout());
                //@TODO create prepared spells panel
                add(preparedSpellsPanel);
            }
            if (value.hasDomains()) {
                domainSpellsPanel = new JPanel(new VerticalLayout());
                //@TODO create domain panel
                add(domainSpellsPanel);
            }
            if (value.hasSpecialtySchools()) {
                specialtySchoolPanel = new JPanel(new VerticalLayout());
                //@TODO create specialty panel
                add(specialtySchoolPanel);
            }
            if (value.hasSpellFailure()) {
                spellFailureFieldPanel = new JPanel(new VerticalLayout());
                //@TODO create spell failure panel
                add(spellFailureFieldPanel);
            }
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
}
