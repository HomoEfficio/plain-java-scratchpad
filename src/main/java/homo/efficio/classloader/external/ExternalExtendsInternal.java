package homo.efficio.classloader.external;

import homo.efficio.classloader.internal.Internal;

/**
 * @author homo.efficio@gmail.com
 * Created on 2018-10-11.
 */
public class ExternalExtendsInternal extends Internal {

    private Long id;

    private String name;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
