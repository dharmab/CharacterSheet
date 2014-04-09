package highfive.charactersheet;

import javax.swing.*;


public class CharacterSheetView extends JPanel
{
    private CharacterSheet characterSheet;

    public CharacterSheetView()
    {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
}
