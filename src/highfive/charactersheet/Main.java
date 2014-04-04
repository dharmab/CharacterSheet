package highfive.charactersheet;

import highfive.charactersheet.revisedthirdedition.StatsSection;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        StatsSection statsSection = new StatsSection();

        CharacterSheetView characterSheetView = new CharacterSheetView();
        characterSheetView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        characterSheetView.add(statsSection.getStatsSetion());
        characterSheetView.setSize(600, 600);
        characterSheetView.setLocation(300, 50);
        characterSheetView.setVisible(true);

        JFrame mainWindow = new MainWindow("Character Sheet");
        mainWindow.add(characterSheetView);
        mainWindow.setVisible(true);
    }
}
