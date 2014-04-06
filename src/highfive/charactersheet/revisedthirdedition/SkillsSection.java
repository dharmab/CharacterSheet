package highfive.charactersheet.revisedthirdedition;

import highfive.charactersheet.AbstractSection;

import javax.swing.*;
import java.awt.*;
import java.util.AbstractSet;
import java.util.HashMap;

/**
 * Created by Marcus on 4/3/2014.
 */
public class SkillsSection extends AbstractSection{
    private JPanel topPanel = new JPanel();
    private JPanel skillsPanel = new JPanel(new GridLayout(0, 7));
    RevisedThirdEditionCharacterSheet characterSheet;
    AbstractSet<String> skillNames;
    HashMap<String, Skill> skillsTable;

    public SkillsSection(RevisedThirdEditionCharacterSheet characterSheet) {
        this.characterSheet = characterSheet;
        this.skillNames = (AbstractSet<String>)characterSheet.getSkillsAsHashMap().keySet();
        this.skillsTable = characterSheet.getSkillsAsHashMap();
    }

    /**
     * Fills the Skills section with appropriate data, and returns it as a JPanel
     * @return the Skills section as a JPanel
     */
    @Override
    public JPanel buildSection() {
        topPanel.removeAll();
        skillsPanel.removeAll();
        skillsPanel.add(new JLabel("Class Skill"));
        skillsPanel.add(new JLabel("Skill Name"));
        skillsPanel.add(new JLabel("Key Ability"));
        skillsPanel.add(new JLabel("Skill Modifier"));
        skillsPanel.add(new JLabel("Ability Modifier"));
        skillsPanel.add(new JLabel("Ranks"));
        skillsPanel.add(new JLabel("Misc Modifier"));
        for (String skill : skillNames) {
            skillsPanel.add(new JCheckBox("", skillsTable.get(skill).getIsClassSkill()));
            skillsPanel.add(new JLabel(skill));
            switch(skillsTable.get(skill).getKeyAbility()) {
                case STRENGTH:
                    skillsPanel.add(new JLabel("STR"));
                    break;
                case DEXTERITY:
                    skillsPanel.add(new JLabel("DEX"));
                    break;
                case CONSTITUTION:
                    skillsPanel.add(new JLabel("CON"));
                    break;
                case INTELLIGENCE:
                    skillsPanel.add(new JLabel("INT"));
                    break;
                case WISDOM:
                    skillsPanel.add(new JLabel("WIS"));
                    break;
                case CHARISMA:
                    skillsPanel.add(new JLabel("CHA"));
                    break;
                default:
                    skillsPanel.add(new JLabel("N/A"));
                    break;
            }
            skillsPanel.add(new JLabel(Integer.toString(characterSheet.getSkillModifier(skill))));
            switch(skillsTable.get(skill).getKeyAbility()) {
                case STRENGTH:
                    skillsPanel.add(new JLabel(Integer.toString(characterSheet.getStrengthModifier())));
                    break;
                case DEXTERITY:
                    skillsPanel.add(new JLabel(Integer.toString(characterSheet.getDexterityModifier())));
                    break;
                case CONSTITUTION:
                    skillsPanel.add(new JLabel(Integer.toString(characterSheet.getConstitutionModifier())));
                    break;
                case INTELLIGENCE:
                    skillsPanel.add(new JLabel(Integer.toString(characterSheet.getIntelligenceModifier())));
                    break;
                case WISDOM:
                    skillsPanel.add(new JLabel(Integer.toString(characterSheet.getWisdomModifier())));
                    break;
                case CHARISMA:
                    skillsPanel.add(new JLabel(Integer.toString(characterSheet.getCharismaModifier())));
                    break;
                default:
                    skillsPanel.add(new JLabel("N/A"));
                    break;
            }
            skillsPanel.add(new JTextField(skillsTable.get(skill).getRank()));
            skillsPanel.add(new JTextField(skillsTable.get(skill).getMiscModifier()));
        }
        topPanel.add(skillsPanel);
        return topPanel;
    }
}
