package highfive.charactersheet.revisedthirdedition.models;

import java.io.Serializable;

public class Feat implements Serializable {
    private String name;
    private String description;

    public Feat() {
        name = "New Feat";
        description = "";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feat feat = (Feat) o;

        return !(name != null ? !name.equals(feat.name) : feat.name != null);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
