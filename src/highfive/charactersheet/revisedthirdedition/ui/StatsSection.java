package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.Section;

import javax.swing.*;

/**
 * Created by zaid on 4/3/14.
 */
public class StatsSection extends Section {
    private JLabel strengthLabel = new JLabel("STR");
    private JTextField strengthAbilityScore = new JTextField();
    private JLabel strengthAbilityModifier = new JLabel();

    private JLabel dexterityLabel = new JLabel("DEX");
    private JTextField dexterityAbilityScore = new JTextField();
    private JLabel dexterityAbilityModifier = new JLabel();

    private JLabel constitutionLabel = new JLabel("CON");
    private JTextField constitutionAbilityScore = new JTextField();
    private JLabel constitutionAbilityModifier = new JLabel();

    private JLabel intelligenceLabel = new JLabel("INT");
    private JTextField intelligenceAbilityScore = new JTextField();
    private JLabel intelligenceAbilityModifier = new JLabel();

    private JLabel wisdomLabel = new JLabel("WIS");
    private JTextField wisdomAbilityScore = new JTextField();
    private JLabel wisdomAbilityModifier = new JLabel();

    private JLabel charismaLabel = new JLabel("CHA");
    private JTextField charismaAbilityScore = new JTextField();
    private JLabel charismaAbilityModifier = new JLabel();

    public StatsSection() {
        super("Ability Scores");
        this.addContent(strengthLabel);
        this.addContent(strengthAbilityScore);
        this.addContent(strengthAbilityModifier);

        this.addContent(dexterityLabel);
        this.addContent(dexterityAbilityScore);
        this.addContent(dexterityAbilityModifier);

        this.addContent(constitutionLabel);
        this.addContent(constitutionAbilityScore);
        this.addContent(constitutionAbilityModifier);

        this.addContent(intelligenceLabel);
        this.addContent(intelligenceAbilityScore);
        this.addContent(intelligenceAbilityModifier);

        this.addContent(wisdomLabel);
        this.addContent(wisdomAbilityScore);
        this.addContent(wisdomAbilityModifier);

        this.addContent(charismaLabel);
        this.addContent(charismaAbilityScore);
        this.addContent(charismaAbilityModifier);

    }
}
