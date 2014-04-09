package highfive.charactersheet.revisedthirdedition.models;

public class Feat {
    private String name;
    private String description;
    private String page;

    public Feat() {
        name = "New Feat";
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

        Feat feat = (Feat) o;

        return !(name != null ? !name.equals(feat.name) : feat.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
