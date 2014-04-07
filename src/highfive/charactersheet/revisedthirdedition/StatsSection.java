package highfive.charactersheet.revisedthirdedition;

import highfive.charactersheet.AbstractSection;
import highfive.charactersheet.CharacterSheet;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


/**
 * @author archana
 */
public class StatsSection extends AbstractSection
{
    static JPanel topPanel = new JPanel();
    JPanel innerPanel = new JPanel(new GridLayout(1, 1));

    @Override
    public JPanel buildSection(CharacterSheet sheet)
    {
        JPanel panel1 = getSkillsSection();
        JPanel panel2 = getHPSection();

        JPanel finalPanel = new JPanel(new BorderLayout());
        finalPanel.setLayout(new GridLayout(2, 0));
        finalPanel.add(panel1);
        finalPanel.add(panel2);

        JPanel topPanel = getSectionPanel("Stats", finalPanel);
        return topPanel;
    }

    private JPanel getSkillsSection()
    {
        JPanel pane = new JPanel(new BorderLayout());
        int numberOfRows = 7;
        int numberOfColumns = 5;
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

        TextField field_str1 = new TextField(5);
        TextField field_str2 = new TextField(5);
        TextField field_strscore = new TextField(5);
        TextField field_strmodifier = new TextField(5);
        TextField field_dex1 = new TextField(5);
        TextField field_dex2 = new TextField(5);
        TextField field_dexscore = new TextField(5);
        TextField field_dexmodifier = new TextField(5);
        TextField field_con1 = new TextField(5);
        TextField field_con2 = new TextField(5);
        TextField field_conscore = new TextField(5);
        TextField field_conmodifier = new TextField(5);
        TextField field_int1 = new TextField(5);
        TextField field_int2 = new TextField(5);
        TextField field_intscore = new TextField(5);
        TextField field_intmodifier = new TextField(5);
        TextField field_wis1 = new TextField(5);
        TextField field_wis2 = new TextField(5);
        TextField field_wisscore = new TextField(5);
        TextField field_wismodifier = new TextField(5);
        TextField field_cha1 = new TextField(5);
        TextField field_cha2 = new TextField(5);
        TextField field_chascore = new TextField(5);
        TextField field_chamodifier = new TextField(5);

        pane.add(new JLabel("Ability Name"));
        pane.add(new JLabel("Ability Score"));
        pane.add(new JLabel("Ability Modifier"));
        pane.add(new JLabel("Temporary Score"));
        pane.add(new JLabel("Temporary Modifier"));

        pane.add(label1);
        pane.add(field_str1);
        pane.add(field_str2);
        pane.add(field_strscore);
        pane.add(field_strmodifier);

        pane.add(label2);
        pane.add(field_dex1);
        pane.add(field_dex2);
        pane.add(field_dexscore);
        pane.add(field_dexmodifier);

        pane.add(label3);
        pane.add(field_con1);
        pane.add(field_con2);
        pane.add(field_conscore);
        pane.add(field_conmodifier);

        pane.add(label4);
        pane.add(field_int1);
        pane.add(field_int2);
        pane.add(field_intscore);
        pane.add(field_intmodifier);

        pane.add(label5);
        pane.add(field_wis1);
        pane.add(field_wis2);
        pane.add(field_wisscore);
        pane.add(field_wismodifier);

        pane.add(label6);
        pane.add(field_cha1);
        pane.add(field_cha2);
        pane.add(field_chascore);
        pane.add(field_chamodifier);

        return pane;
    }

    private JPanel getHPSection()
    {
        //----------------------------------------START OF HP PANEL------------------- ---------------------------------------
        JPanel paneHP = new JPanel(new BorderLayout());
        paneHP.setLayout(new GridBagLayout());

        JLabel label1 = new JLabel("HP");
        label1.setToolTipText("Hit Points");

        TextField field_totalHP = new TextField(5);
        TextField field_currentHP = new TextField(5);
        TextField field_lethaldamage = new TextField(5);
        TextField field_speed = new TextField(5);

        paneHP.add(new JLabel(""),setGridConstraints(0.5, 0, 0));
        paneHP.add(new JLabel("Total"),setGridConstraints(0.5, 1, 0));
        paneHP.add(new JLabel("Wound/Current HP "),setGridConstraints(0.5, 2, 0));
        paneHP.add(new JLabel("Nonlethal Damage"),setGridConstraints(0.5, 3, 0));
        paneHP.add(new JLabel("Speed"),setGridConstraints(0.5, 4, 0));

        paneHP.add(label1,setGridConstraints(0.9, 0, 1));
        paneHP.add(field_totalHP,setGridConstraints(0.8, 1, 1));
        paneHP.add(field_currentHP,setGridConstraints(0.7, 2, 1));
        paneHP.add(field_lethaldamage,setGridConstraints(0.6, 3, 1));
        paneHP.add(field_speed,setGridConstraints(0.8, 4, 1));

        //--------------------------------------------END OF HP PANEL-----------------------------------------------------------

        //---------------------------------------------START OF AC PANEL--------------------------------------------------------

        JPanel paneAC = new JPanel(new BorderLayout());
        paneAC.setLayout(new GridBagLayout());

        JLabel label2 = new JLabel("AC");
        label2.setToolTipText("Armor Class");

        TextField field_totalAC = new TextField(6);
        TextField field_armorbonus = new TextField(6);
        TextField field_shieldbonus = new TextField(6);
        TextField field_dexmodfier = new TextField(6);
        TextField field_sizemodifer = new TextField(6);
        TextField field_naturalmodifier = new TextField(6);
        TextField field_deflectionmodifier = new TextField(6);
        TextField field_miscmodifier = new TextField(6);
        TextField field_damageredution = new TextField(15);

        paneAC.add(label2,setGridConstraints(0.5, 0, 0));
        paneAC.add(field_totalAC,setGridConstraints(0.5, 1, 0));
        paneAC.add(new JLabel("="),setGridConstraints(0.5, 2, 0));
        paneAC.add(new JLabel("10"),setGridConstraints(0.5, 3, 0));
        paneAC.add(new JLabel("+"),setGridConstraints(0.5, 4, 0));
        paneAC.add(field_armorbonus,setGridConstraints(0.5, 5, 0));
        paneAC.add(new JLabel("+"),setGridConstraints(0.5, 6, 0));
        paneAC.add(field_shieldbonus,setGridConstraints(0.5, 7, 0));
        paneAC.add(new JLabel("+"),setGridConstraints(0.5, 8, 0));
        paneAC.add(field_dexmodfier,setGridConstraints(0.5, 9, 0));
        paneAC.add(new JLabel("+"),setGridConstraints(0.5, 10, 0));
        paneAC.add(field_sizemodifer,setGridConstraints(0.5, 11, 0));
        paneAC.add(new JLabel("+"),setGridConstraints(0.5, 12, 0));
        paneAC.add(field_naturalmodifier,setGridConstraints(0.5, 13, 0));
        paneAC.add(new JLabel("+"),setGridConstraints(0.5, 14, 0));
        paneAC.add(field_deflectionmodifier,setGridConstraints(0.5, 15, 0));
        paneAC.add(new JLabel("+"),setGridConstraints(0.5, 16, 0));
        paneAC.add(field_miscmodifier,setGridConstraints(0.5, 17, 0));
        paneAC.add(new JLabel(htmlFormatText("Damage", "Reduction")),setGridConstraints(0.5, 18, 0));

        paneAC.add(new JLabel(),setGridConstraints(0.5, 0, 1));
        paneAC.add(new JLabel("Total"),setGridConstraints(0.5, 1, 1));
        paneAC.add(new JLabel(),setGridConstraints(0.5, 2, 1));
        paneAC.add(new JLabel("10"),setGridConstraints(0.5, 3, 1));
        paneAC.add(new JLabel(),setGridConstraints(0.5, 4, 1));
        paneAC.add(new JLabel("Armor Bonus"),setGridConstraints(0.5, 5, 1));
        paneAC.add(new JLabel(),setGridConstraints(0.5, 6, 1));
        paneAC.add(new JLabel("Shield Bonus"),setGridConstraints(0.5, 7, 1));
        paneAC.add(new JLabel(),setGridConstraints(0.5, 8, 1));
        paneAC.add(new JLabel("Dex Modifier"),setGridConstraints(0.5, 9, 1));
        paneAC.add(new JLabel(),setGridConstraints(0.5, 10, 1));
        paneAC.add(new JLabel("Size Modifier"),setGridConstraints(0.5, 11, 1));
        paneAC.add(new JLabel(),setGridConstraints(0.5, 12, 1));
        paneAC.add(new JLabel("Natural Armor"),setGridConstraints(0.5, 13, 1));
        paneAC.add(new JLabel(),setGridConstraints(0.5, 14, 1));
        paneAC.add(new JLabel("Deflection Modifier"),setGridConstraints(0.5, 15, 1));
        paneAC.add(new JLabel(),setGridConstraints(0.5, 16, 1));
        paneAC.add(new JLabel("Misc Modifier"),setGridConstraints(0.5, 17, 1));
        paneAC.add(field_damageredution,setGridConstraints(0.5, 18, 1));
        //---------------------------------------- END OF AC PANEL -------------------------------------------------------------

        //---------------------------------------- START OF TOUCH PANEL -------------------------------------------------------------

        JPanel paneTOUCH = new JPanel(new BorderLayout());
        paneTOUCH.setLayout(new GridBagLayout());

        JLabel label_touch = new JLabel("TOUCH");
        label_touch.setToolTipText("Armor Class");
        JLabel label_flatfoot = new JLabel("FLAT-FOOTED");
        label_flatfoot.setToolTipText("Armor Class");
        JLabel label_initiative = new JLabel("INITIATIVE");
        label_initiative.setToolTipText("Modifier");

        TextField field_touch = new TextField(6);
        TextField field_flatfoot = new TextField(6);
        TextField field_initiativetotal = new TextField(6);
        TextField field_initiativedexmodfier = new TextField(6);
        TextField field_initiativemiscmodifier = new TextField(6);

        paneTOUCH.add(label_touch,setGridConstraints(0.5, 0, 0));
        paneTOUCH.add(field_touch,setGridConstraints(0.5, 1, 0));
        paneTOUCH.add(label_flatfoot,setGridConstraints(0.5, 2, 0));
        paneTOUCH.add(field_flatfoot,setGridConstraints(0.5, 3, 0));
        paneTOUCH.add(label_initiative,setGridConstraints(0.5, 4, 0));
        paneTOUCH.add(field_initiativetotal,setGridConstraints(0.5, 5, 0));
        paneTOUCH.add(field_initiativedexmodfier,setGridConstraints(0.5, 6, 0));
        paneTOUCH.add(field_initiativemiscmodifier,setGridConstraints(0.5, 7, 0));

        paneTOUCH.add(new JLabel(),setGridConstraints(0.5, 0, 1));
        paneTOUCH.add(new JLabel(),setGridConstraints(0.5, 1, 1));
        paneTOUCH.add(new JLabel(),setGridConstraints(0.5, 2, 1));
        paneTOUCH.add(new JLabel(),setGridConstraints(0.5, 3, 1));
        paneTOUCH.add(new JLabel(),setGridConstraints(0.5, 4, 1));
        paneTOUCH.add(new JLabel("Total"),setGridConstraints(0.5, 5, 1));
        paneTOUCH.add(new JLabel(htmlFormatText("Dex","Modifier")),setGridConstraints(0.5, 6, 1));
        paneTOUCH.add(new JLabel(htmlFormatText("Misc","Modifier")),setGridConstraints(0.5, 7, 1));

        //---------------------------------------- END OF TOUCH PANEL -------------------------------------------------------------

        JPanel finalPanel = new JPanel(new BorderLayout());
        finalPanel.setLayout(new GridLayout(3, 0));
        finalPanel.add(paneHP);
        finalPanel.add(paneAC);
        finalPanel.add(paneTOUCH);

        return finalPanel;
    }

    public GridBagConstraints setGridConstraints(double weight,int column,int row)
    {
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = weight;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = column;
        c.gridy = row;
        //c.CENTER = 10;

        return c;
    }

    public String htmlFormatText(String line1,String line2)
    {
        String text =  "<html> "+
                "<body>"+
                "<label>"+line1+"</label>"+
                "<br><label>"+line2+"</label>"+
                "</body>"+
                "</html>";
        return text;
    }
    public JPanel getStatsSection()
    {
        JPanel topPanel = getSectionPanel("Stats", buildSection(new RevisedThirdEditionCharacterSheet()));
        return topPanel;
    }
}
