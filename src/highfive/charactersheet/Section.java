package highfive.charactersheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zaid on 4/3/14.
 */
public abstract class Section extends JPanel {
    private JPanel titleBar;
    private JLabel titleLabel;
    private JButton collapseButton;
    private JPanel contentArea;

    public Section(String title) {
        titleBar = new JPanel();
        titleLabel = new JLabel(title);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        collapseButton = new JButton("Collapse");
        collapseButton.setEnabled(true);
        collapseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (contentArea.isVisible()) {
                    contentArea.setVisible(false);
                } else {
                    contentArea.setVisible(true);
                }
            }
        });

        titleBar.setLayout(new BorderLayout());
        titleBar.add(collapseButton, BorderLayout.EAST);
        titleBar.add(titleLabel, BorderLayout.CENTER);

        contentArea = new JPanel();

        this.setLayout(new BorderLayout());
        super.add(titleBar, BorderLayout.NORTH);
        super.add(contentArea, BorderLayout.CENTER);
    }

    public Component addContent(Component comp) {
        return contentArea.add(comp);
    }

    public void setContentLayout(LayoutManager mgr) {
        contentArea.setLayout(mgr);
    }
}
