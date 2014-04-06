package highfive.charactersheet;

import highfive.charactersheet.revisedthirdedition.DNDCharacterSheetView;
import highfive.charactersheet.revisedthirdedition.RevisedThirdEditionCharacterSheet;

import javax.swing.*;

public class Main {
    static JFrame mainWindow;

    public static void main(String[] args) {
        mainWindow = new MainWindow("Character Sheet");
        mainWindow.setSize(600,600);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
