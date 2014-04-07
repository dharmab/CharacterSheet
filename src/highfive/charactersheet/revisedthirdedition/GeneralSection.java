package highfive.charactersheet.revisedthirdedition;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.AbstractSection;
import javax.swing.*;
import java.awt.*;

/**
 * Created by archana on 4/6/2014.
 */
public class GeneralSection extends AbstractSection
{

    @Override
    public JPanel buildSection(CharacterSheet sheet)
    {
        JPanel finalPanel = new JPanel(new BorderLayout());
        finalPanel.setLayout(new GridLayout(0, 0));
        finalPanel.add(demographicDetailsPanel());

        JPanel topPanel = getSectionPanel("General Details", finalPanel);
        return topPanel;
    }

    private static JPanel demographicDetailsPanel()
    {
        //----------------------------------------START OF NAME PANEL----------------------------------------------------------
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setLayout(new GridBagLayout());

        TextField field_charname = new TextField(10);
        TextField field_playername = new TextField(10);

        //row 0
        panel1.add(field_charname,new CommonFunctions().setGridConstraints(0.5, 0, 0));
        panel1.add(field_playername,new CommonFunctions().setGridConstraints(0.5, 1, 0));
        //row 1
        panel1.add(new JLabel("Character Name"),new CommonFunctions().setGridConstraints(0.5, 0, 1));
        panel1.add(new JLabel("Player"),new CommonFunctions().setGridConstraints(0.5, 0, 1));

        //----------------------------------------END OF NAME PANEL-------------------------------------------------------------

        //----------------------------------------START OF CLASS PANEL----------------------------------------------------------
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setLayout(new GridBagLayout());

        TextField field_classnlevel = new TextField(10);
        TextField field_race = new TextField(10);
        TextField field_alignment = new TextField(10);
        TextField field_deity = new TextField(10);

        //row 0
        panel2.add(field_classnlevel,new CommonFunctions().setGridConstraints(0.5, 0, 0));
        panel2.add(field_race,new CommonFunctions().setGridConstraints(0.5, 1, 0));
        panel2.add(field_alignment,new CommonFunctions().setGridConstraints(0.5, 2, 0));
        panel2.add(field_deity,new CommonFunctions().setGridConstraints(0.5, 3, 0));
        //row 1
        panel2.add(new JLabel("Class and Level"),new CommonFunctions().setGridConstraints(0.5, 0, 1));
        panel2.add(new JLabel("Race"),new CommonFunctions().setGridConstraints(0.5, 1, 1));
        panel2.add(new JLabel("Alignment"),new CommonFunctions().setGridConstraints(0.5, 2, 1));
        panel2.add(new JLabel("Deity"),new CommonFunctions().setGridConstraints(0.5, 3, 1));

        //----------------------------------------END OF CLASS PANEL----------------------------------------------------------

        //----------------------------------------START OF SIZE PANEL----------------------------------------------------------
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setLayout(new GridBagLayout());

        TextField field_size = new TextField(10);
        TextField field_age = new TextField(5);
        TextField field_gender = new TextField(5);
        TextField field_height = new TextField(5);
        TextField field_weight = new TextField(5);
        TextField field_eyes = new TextField(5);
        TextField field_hair = new TextField(5);
        TextField field_skin = new TextField(5);

        //row 0
        panel3.add(field_size,new CommonFunctions().setGridConstraints(0.5, 0, 0));
        panel3.add(field_age,new CommonFunctions().setGridConstraints(0.5, 1, 0));
        panel3.add(field_gender,new CommonFunctions().setGridConstraints(0.5, 2, 0));
        panel3.add(field_height,new CommonFunctions().setGridConstraints(0.5, 3, 0));
        panel3.add(field_weight,new CommonFunctions().setGridConstraints(0.5, 4, 0));
        panel3.add(field_eyes,new CommonFunctions().setGridConstraints(0.5, 5, 0));
        panel3.add(field_hair,new CommonFunctions().setGridConstraints(0.5, 6, 0));
        panel3.add(field_height,new CommonFunctions().setGridConstraints(0.5, 7, 0));

        //row 1
        panel3.add(new JLabel("Size"),new CommonFunctions().setGridConstraints(0.5, 0, 1));
        panel3.add(new JLabel("Age"),new CommonFunctions().setGridConstraints(0.5, 1, 1));
        panel3.add(new JLabel("Gender"),new CommonFunctions().setGridConstraints(0.5, 2, 1));
        panel3.add(new JLabel("Height"),new CommonFunctions().setGridConstraints(0.5, 3, 1));
        panel3.add(new JLabel("Weight"),new CommonFunctions().setGridConstraints(0.5, 4, 1));
        panel3.add(new JLabel("Eyes"),new CommonFunctions().setGridConstraints(0.5, 5, 1));
        panel3.add(new JLabel("Hair"),new CommonFunctions().setGridConstraints(0.5, 6, 1));
        panel3.add(new JLabel("Skin"),new CommonFunctions().setGridConstraints(0.5, 7, 1));

        //----------------------------------------END OF CLASS PANEL----------------------------------------------------------

        JPanel finalPanel = new JPanel(new BorderLayout());
        finalPanel.setLayout(new GridLayout(3, 0));
        finalPanel.add(panel1);
        finalPanel.add(panel2);
        finalPanel.add(panel3);

        return finalPanel;
    }
}
