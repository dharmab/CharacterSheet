package highfive.charactersheet;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private CharacterSheetView characterSheetView;

    public MainWindow(String title) throws HeadlessException {
        super(title);
    }
}
