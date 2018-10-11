package homo.efficio.classloader;

/**
 * @author homo.efficio@gmail.com
 * Created on 2018-10-11.
 */
public class External {

    private Long id;

    private String name;

    private External external;

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

    public External getExternal() {
        return external;
    }

    public void setExternal(External external) {
        this.external = external;
    }
}
