package highfive.charactersheet.revisedthirdedition.ui;

import java.awt.*;

public class CommonFunctions {

    public static GridBagConstraints setGridConstraints(double weight,int column,int row)
    {
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = weight;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = column;
        c.gridy = row;
        c.insets = new Insets(1,2,1,2);
        //c.CENTER = 10;

        return c;
    }

    public static String htmlFormatText(String line1,String line2)
    {
        String text =  "<html> "+
                "<body>"+
                "<label>"+line1+"</label>"+
                "<br><label>"+line2+"</label>"+
                "</body>"+
                "</html>";
        return text;
    }

}
