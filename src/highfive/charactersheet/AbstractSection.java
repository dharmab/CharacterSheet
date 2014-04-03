package highfive.charactersheet;


import javax.swing.JPanel;
import org.jdesktop.swingx.JXTaskPane;

public class AbstractSection
{
    JXTaskPane taskPane;

    public JPanel getSectionPanel(String title,JPanel sectionPanel)
    {
        JPanel panel = new JPanel();
        //JXTaskPaneContainer container = new JXTaskPaneContainer();
        taskPane = new JXTaskPane();
        taskPane.setTitle(title);
        taskPane.add(sectionPanel);
        panel.add(taskPane);
        return panel;
    }
}
