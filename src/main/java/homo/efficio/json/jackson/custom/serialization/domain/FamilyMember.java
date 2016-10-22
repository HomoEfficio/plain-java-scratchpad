package homo.efficio.json.jackson.custom.serialization.domain;

import java.util.Set;

/**
 * Created by hanmomhanda on 2016-10-22.
 */
public class FamilyMember {

    private Long id;
    private String name;
    private CellPhone cellPhone;
    private Set<FamilyMember> children;

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
}
