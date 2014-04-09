package highfive.charactersheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zaid on 4/3/14.
 */
public class InfoWidget extends JPanel {
    private JLabel label;
    private JPanel staticPanel;
    private JButton collapseButton;
    private JPanel dynamicPanel;

    public InfoWidget(JLabel label) {
        this.label = label;
        staticPanel = new JPanel();
        collapseButton = new JButton("Collapse");
        collapseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (dynamicPanel.isVisible()) {
                    dynamicPanel.setVisible(false);
                } else {
                    dynamicPanel.setVisible(true);
                }
            }
        });
        dynamicPanel = new JPanel();

        this.add(label);
        this.add(staticPanel);
        this.add(collapseButton);
        this.add(dynamicPanel);
    }

    public Component addStaticContent(Component comp) {
        return staticPanel.add(comp);
    }

    public Component addDynamicContent(Component comp) {
        return dynamicPanel.add(comp);
    }
}
