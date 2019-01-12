package homo.efficio.classloader.external;

import homo.efficio.classloader.internal.Internal;

/**
 * @author homo.efficio@gmail.com
 * Created on 2018-10-11.
 */
public class External {

    private Long id;

    private String name;

    private Internal internal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Internal getInternal() {
        return internal;
    }

    public void setInternal(Internal internal) {
        this.internal = internal;
    }
}
