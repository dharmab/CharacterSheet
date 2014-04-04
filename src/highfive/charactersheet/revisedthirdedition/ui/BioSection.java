package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.Section;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zaid on 4/3/14.
 */
public class BioSection extends Section {
    private JLabel characterNameLabel = new JLabel("Name: ");
    private JTextField characterNameField;

    private JLabel playerNameLabel  = new JLabel("Player: ");
    private JTextField playerNameField;

    public BioSection() {
        super("Character");
        this.setContentLayout(new GridBagLayout());

        characterNameField = new JTextField("Character name");
        characterNameField.setMinimumSize(new Dimension(150, 15));
        characterNameField.setEditable(true);
        playerNameField = new JTextField("Player name");
        playerNameField.setMinimumSize(new Dimension(150, 15));
        playerNameField.setEditable(true);

        this.addContent(characterNameLabel);
        this.addContent(characterNameField);
        this.addContent(playerNameLabel);
        this.addContent(playerNameField);
    }
}
