package highfive.charactersheet;

import highfive.charactersheet.revisedthirdedition.ui.BioSection;
import highfive.charactersheet.revisedthirdedition.ui.StatsSection;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainWindow = new MainWindow("Character Sheet");
        JPanel csv = new CharacterSheetView();

        BioSection bio = new BioSection();
        StatsSection stats = new StatsSection();

        csv.add(bio);
        csv.add(stats);

        mainWindow.add(csv);
        mainWindow.setVisible(true);
    }
}
