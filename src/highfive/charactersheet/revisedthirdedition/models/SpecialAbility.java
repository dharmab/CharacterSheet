package highfive.charactersheet.revisedthirdedition.models;


import java.io.Serializable;

public class SpecialAbility implements Serializable {
    private String name;
    private String description;
    private String page;

    public SpecialAbility() {
        name = "New Special Ability";
        description = "";
        page = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialAbility ability = (SpecialAbility) o;

        return !(name != null ? !name.equals(ability.name) : ability.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
