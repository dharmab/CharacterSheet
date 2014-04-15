package highfive.charactersheet;

import org.jdesktop.swingx.JXTaskPane;

public abstract class Section extends JXTaskPane {

    public Section(String title) {
        super();
        setTitle(title);
    }

    /**
     * This method should write the data displayed to the user
     * to the backing model and then call load()
     * @param characterSheet The character sheet from the parent view
     * @return A synced character sheet
     */
    public abstract CharacterSheet update(CharacterSheet characterSheet);

    /**
     * This method should read the data from the backing model
     * and then display it to the user
     * @param characterSheet The character sheet from the parent view
     */
    public abstract void load(CharacterSheet characterSheet);

    /**
     * This method should call the update() method of the parent
     * view, which cascades down to each section.
     */
    protected void updateParent() {
        ((CharacterSheetView)getParent()).update();
    }
}
