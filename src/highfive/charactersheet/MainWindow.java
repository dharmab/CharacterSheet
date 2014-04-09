package highfive.charactersheet;

import highfive.charactersheet.revisedthirdedition.ui.RevisedThirdEditionCharacterSheetView;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private CharacterSheetView characterSheetView;

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

        characterSheetView = new RevisedThirdEditionCharacterSheetView();
        add(characterSheetView);
    }

}