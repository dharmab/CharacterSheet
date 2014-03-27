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

    public void addToInventory(Item item){
        this.items.add(item);
    }

    public void removeFromInventory(Item item){
        if (items.contains(item)){
            items.remove(item);
        }
        else throw new NullPointerException();
    }

    public void renameInventory(String newName){
        this.name = newName;
    }

    public void modifyItemName(Item item, String newName){
        items.get(this.items.indexOf(item)).setName(newName);
    }

    public void modifyItemWeight(Item item, double weight){
        items.get(this.items.indexOf(item)).setWeight(weight);
    }
}
