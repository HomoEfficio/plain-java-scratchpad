package homo.efficio.json.jackson.custom.domain;

import java.util.Set;

/**
 * Created by hanmomhanda on 2016-10-22.
 */
public class FamilyMember {

    private Long id;
    private String name;
    private CellPhone cellPhone;
    private Set<FamilyMember> children;

    public FamilyMember() {
    }

    public FamilyMember(Long id, String name, CellPhone cellPhone, Set<FamilyMember> children) {
        this.id = id;
        this.name = name;
        this.cellPhone = cellPhone;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CellPhone getCellPhone() {
        return cellPhone;
    }

    public Set<FamilyMember> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyMember that = (FamilyMember) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (cellPhone != null ? !cellPhone.equals(that.cellPhone) : that.cellPhone != null) return false;
        return children != null ? children.equals(that.children) : that.children == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (cellPhone != null ? cellPhone.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}
