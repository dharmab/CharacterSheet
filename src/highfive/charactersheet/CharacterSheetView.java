package highfive.charactersheet;

import highfive.charactersheet.revisedthirdedition.RevisedThirdEditionCharacterSheet;

import javax.swing.*;


public class CharacterSheetView extends JPanel
{
    CharacterSheet characterSheet;

    public CharacterSheetView()
    {
        super();
        this.characterSheet = new RevisedThirdEditionCharacterSheet();
    }

    public CharacterSheetView(CharacterSheet characterSheet) {
        super();
        this.characterSheet = characterSheet;
    }
}
