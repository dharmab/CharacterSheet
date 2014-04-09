package highfive.charactersheet;

import highfive.charactersheet.revisedthirdedition.ui.BioSection;
import highfive.charactersheet.revisedthirdedition.ui.StatsSection;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainWindow = new MainWindow("Character Sheet");
        JPanel csv = new CharacterSheetView();
        mainWindow.add(csv);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
