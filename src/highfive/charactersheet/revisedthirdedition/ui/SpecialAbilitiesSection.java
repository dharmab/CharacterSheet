package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;
import highfive.charactersheet.revisedthirdedition.models.SpecialAbility;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashSet;

/**
 * Created by Marcus on 4/16/2014.
 */
public class SpecialAbilitiesSection extends Section{

    private HashSet<SpecialAbility> specialAbilities;

    private ChangeListener refreshListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {

        }
    };

    public SpecialAbilitiesSection(String title) {
        super(title);
    }

    private void rebuild() {
        removeAll();
        setLayout(new GridLayout(specialAbilities.size() + 1, 2));
        add(new JLabel("Special Ability"));
        add(new JLabel("Page"));

        for (SpecialAbility ability : specialAbilities) {
            final SpecialAbility loopAbility = ability;
            final JTextField specialAbilityField = new JTextField(15);
            specialAbilityField.setText(ability.getName());
            final JTextField pageNumberField = new JTextField(3);
            pageNumberField.setText(ability.getPage());

            specialAbilityField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    //empty
                }

                @Override
                public void focusLost(FocusEvent e) {
                    loopAbility.setName(specialAbilityField.getText());
                }
            });

            pageNumberField.addFocusListener(new FocusListener() {
                 @Override
                 public void focusGained(FocusEvent e) {
                     //empty
                 }

                 @Override
                 public void focusLost(FocusEvent e) {
                    loopAbility.setPage(pageNumberField.getText());
                 }
            });

            add(specialAbilityField);
            add(pageNumberField);
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
