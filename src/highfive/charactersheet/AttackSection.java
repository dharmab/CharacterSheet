package highfive.charactersheet;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author archana
 */
public class AttackSection extends AbstractSection
{
    static JPanel topPanel = new JPanel();
    JPanel innerPanel = new JPanel(new GridLayout(1, 1));


    public JPanel buildStatsSection()
    {
        JPanel pane = new JPanel(new BorderLayout());
        pane.setLayout(new GridLayout(0, 1));
        JLabel label1 = new JLabel("ATK");
        label1.setToolTipText("Attack");
        JLabel label2 = new JLabel("Gear");
        label2.setToolTipText("Gear");

        TextField field_str1 = new TextField();
        TextField field_str2 = new TextField();

        pane.add(label1);
        pane.add(field_str1);

        pane.add(label2);
        pane.add(field_str2);


        return pane;
    }

    public JPanel getAttackSetion()
    {
        JPanel topPanel = getSectionPanel("Stats", buildStatsSection());
        return topPanel;
    }

    public static void main(String[] args)
    {
        AttackSection s = new AttackSection();
        CharacterSheetView f = new CharacterSheetView();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(s.getAttackSetion());
        f.setSize(600,600);
        f.setLocation(300,50);
        f.setVisible(true);
    }
}
