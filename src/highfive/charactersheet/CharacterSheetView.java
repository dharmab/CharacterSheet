package highfive.charactersheet;

import highfive.charactersheet.revisedthirdedition.StatsSection;

import javax.swing.*;


public class CharacterSheetView  extends JFrame
{
    CharacterSheetView()
    {
        JMenu file = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem exitItem = new JMenuItem("Exit");

        file.add(newItem);
        file.add(loadItem);
        file.add(exitItem);

        JMenuBar bar = new JMenuBar();
        bar.add(file);
        setJMenuBar(bar);
    }

    public static void mainPanel()
    {

    }

    public static void main(String[] args)
    {
        CharacterSheetView f = new CharacterSheetView();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StatsSection statspanel = new StatsSection();
        f.setSize(600,600);
        f.setLocation(300,50);
        f.setVisible(true);
    }


}
