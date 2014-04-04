package highfive.charactersheet.revisedthirdedition.models;

/**
 * Created by Marcus on 3/27/2014.
 */
public class Item {
    private String name;
    private double weight;

    public Item(){
        this.name = "Undefined";
        this.weight = 0.0;
    }

    public Item(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
