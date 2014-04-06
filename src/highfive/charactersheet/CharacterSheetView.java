package highfive.charactersheet;

import javax.swing.*;


public class CharacterSheetView extends JPanel
{
    CharacterSheet characterSheet;
    AbstractSection[] sections;

    public CharacterSheetView()
    {
        super();
    }

    public CharacterSheetView(AbstractSection[] sections, CharacterSheet characterSheet) {
        super();
        this.sections = sections;
        this.characterSheet = characterSheet;
    }
}
