package homo.efficio.toby_spring_book.chapter03_02_strategy_pattern;

/**
 * @author homo.efficio@gmail.com
 *         created on 2017. 1. 29.
 */
public class User {

    private String id;

    private String password;

    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
