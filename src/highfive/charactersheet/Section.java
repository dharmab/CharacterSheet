package highfive.charactersheet;

import org.jdesktop.swingx.JXTaskPane;

import javax.swing.*;
import java.awt.*;

public abstract class Section extends JXTaskPane {

    private JPanel contentArea;

    public Section(String title) {
        setTitle(title);
        contentArea = new JPanel();
        add(contentArea);
    }

    public Component addContent(Component comp) {
        return contentArea.add(comp);
    }

    public void setContentLayout(LayoutManager mgr) {
        contentArea.setLayout(mgr);
    }
}
