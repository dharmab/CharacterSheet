package highfive.charactersheet;

import org.jdesktop.swingx.JXTaskPane;

public abstract class Section extends JXTaskPane {


    public Section(String title) {
        setTitle(title);
    }

    /**
     * When called, this method should sync the characterSheet and the section
     * @param characterSheet The character sheet from the parent view
     * @return A synced character sheet
     */
    public abstract CharacterSheet refresh(CharacterSheet characterSheet);
}
