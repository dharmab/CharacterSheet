package highfive.charactersheet.revisedthirdedition.models;

import java.io.Serializable;
import java.util.HashMap;

public class Inventory implements Serializable {
    private String name;
    private HashMap<Item, Integer> items; //associate items and their quantities

    public Inventory(String name) {
        this.name = name;
    }

    /**
     * Increase the quantity of the specified item by zero or more
     * @param item the item to add to the inventory
     * @param quantity the number of items to add to the inventory. Must be non-negative
     * @throws java.lang.IllegalArgumentException if the quantity is negative
     */
    public void add(Item item, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Can't add a negative quantity. Did you mean to use remove(Item, int)?");
        }
        int oldQuantity;
        if (items.get(item) != null) {
            oldQuantity = items.get(item);
        } else {
            oldQuantity = 0;
        }
        items.put(item, oldQuantity + quantity);
    }

    public void add(Item item) {
        add(item, 1);
    }

    /**
     * Reduces the quantity fo the specified item by zero or more.
     * @param item the item to remove from the inventory
     * @param quantity the number of items to remove from the inventory. Must be non-negative
     * @throws java.lang.IllegalArgumentException if the quantity is negative
     */
    public void remove(Item item, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Can't remove a negative quantity. Did you mean to use add(Item, int)?");
        }
        int oldQuantity;
        if (items.get(item) != null) {
            oldQuantity = items.get(item);
        } else {
            oldQuantity = 0;
        }
        if (quantity >= oldQuantity) {
            items.remove(item);
        } else {
            items.put(item, oldQuantity - quantity);
        }
    }

    /**
     * Reduce the quantity of the specified item by one.
     * @param item the item to remove
     */
    public void remove(Item item) {
        remove(item, 1);
    }


    /**
     * Remove all of the specified item from this inventory
     * @param item the item to remove
     */
    public void removeAll(Item item) {
        items.remove(item);
    }

    public int getQuantity(Item item) {
        return items.get(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
