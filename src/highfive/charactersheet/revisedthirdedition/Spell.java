package highfive.charactersheet.revisedthirdedition;

/**
 * Created by Marcus on 3/31/2014.
 */
public class Spell {
    String name;
    String description;
    Integer level;

    public Spell(){
        this.name = "undeclared";
        this.description = "undeclared";
        this.level = 0;
    }

    public Spell(String name, String description, Integer level){
        if (level < 0 || level > 9){
            throw new IllegalArgumentException("Spells must be of level 0-9");
        }
        this.name = name;
        this.description = description;
        this.level = level;
    }

    public Integer getLevel(){
        return this.level;
    }

    public void setLevel(Integer level){
        this.level = level;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }


}
