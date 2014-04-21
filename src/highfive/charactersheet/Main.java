package highfive.charactersheet;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainWindow = new MainWindow("Character Sheet");
        mainWindow.setVisible(true);
        mainWindow.setSize(870,630);
        mainWindow.setLocation(230,40);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
