package highfive.charactersheet.revisedthirdedition;

import highfive.charactersheet.AbstractSection;

import javax.swing.*;
import java.awt.*;

/**
 * @author archana
 */
public class StatsSection extends AbstractSection
{
    static JPanel topPanel = new JPanel();
    JPanel innerPanel = new JPanel(new GridLayout(1, 1));


    public JPanel buildStatsSection()
    {
        JPanel pane = new JPanel(new BorderLayout());
        int numberOfRows = 6;
        int numberOfColumns = 3;
        pane.setLayout(new GridLayout(numberOfRows, numberOfColumns));
        JLabel label1 = new JLabel("STR");
        label1.setToolTipText("Strength");
        JLabel label2 = new JLabel("DEX");
        label2.setToolTipText("Dexterity");
        JLabel label3 = new JLabel("CON");
        label3.setToolTipText("Constitution");
        JLabel label4 = new JLabel("INT");
        label4.setToolTipText("Intelligence");
        JLabel label5 = new JLabel("WIS");
        label5.setToolTipText("Wisdom");
        JLabel label6 = new JLabel("CHA");
        label6.setToolTipText("Charisma");

        TextField field_str1 = new TextField();
        TextField field_str2 = new TextField();
        TextField field_dex1 = new TextField();
        TextField field_dex2 = new TextField();
        TextField field_con1 = new TextField();
        TextField field_con2 = new TextField();
        TextField field_int1 = new TextField();
        TextField field_int2 = new TextField();
        TextField field_wis1 = new TextField();
        TextField field_wis2 = new TextField();
        TextField field_cha1 = new TextField();
        TextField field_cha2 = new TextField();

        pane.add(label1);
        pane.add(field_str1);
        pane.add(field_str2);

        pane.add(label2);
        pane.add(field_dex1);
        pane.add(field_dex2);

        pane.add(label3);
        pane.add(field_con1);
        pane.add(field_con2);

        pane.add(label4);
        pane.add(field_int1);
        pane.add(field_int2);

        pane.add(label5);
        pane.add(field_wis1);
        pane.add(field_wis2);

        pane.add(label6);
        pane.add(field_cha1);
        pane.add(field_cha2);

        return pane;
    }

    public JPanel getStatsSetion()
    {
        JPanel topPanel = getSectionPanel("Stats", buildStatsSection());
        return topPanel;
    }
}
