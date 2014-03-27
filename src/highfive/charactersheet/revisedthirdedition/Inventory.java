package highfive.charactersheet.revisedthirdedition;

import java.util.ArrayList;

/**
 * Created by Marcus on 3/27/2014.
 */
public class Inventory {
    private String name;
    private ArrayList<Item> items;

    public Inventory(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    public Inventory(){
        this.name = "Gear";
        this.items = new ArrayList<Item>();
    }
}
