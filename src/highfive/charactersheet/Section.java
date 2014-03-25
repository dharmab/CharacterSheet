package highfive.charactersheet;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class Section extends JPanel {
    private String title;
    private Icon hide;
    private Icon unhide;

    /**
     * If the section is expanded, vertically collapses the section.
     * This method was referred to in specification as hide(),
     * but hide() is an existing method of JPanel and should not
     * be overwritten.
     */
    public void collapse() {
        throw new NotImplementedException();
    }

    /**
     * If the section is collapsed, vertically expands the section.
     * This method was referred to in specification as unhide().
     * See the javadoc for hide()
     */
    public void expand() {
        throw new NotImplementedException();
    }
}
