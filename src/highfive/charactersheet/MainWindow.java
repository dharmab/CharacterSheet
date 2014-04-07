package highfive.charactersheet;

import highfive.charactersheet.revisedthirdedition.*;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow(String title) throws HeadlessException {
        super(title);
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

        add(getTestSheet());
    }

    public JPanel getTestSheet() {
        RevisedThirdEditionCharacterSheet testSheet = new RevisedThirdEditionCharacterSheet();
        DNDCharacterSheetView testView = new DNDCharacterSheetView(testSheet);
        return testView;
    }
}