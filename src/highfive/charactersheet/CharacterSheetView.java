package highfive.charactersheet;

import javax.swing.*;


public abstract class CharacterSheetView extends JPanel
{

    public CharacterSheetView()
    {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public abstract void refresh();
}
