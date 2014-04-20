package highfive.charactersheet;

import javax.swing.*;
//This is a test
public class Main {
    public static void main(String[] args) {
        JFrame mainWindow = new MainWindow("Character Sheet");
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
