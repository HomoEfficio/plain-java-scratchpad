package homo.efficio.toby_spring_book.chapter03_01_template_method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author homo.efficio@gmail.com
 *         created on 2017. 1. 30.
 */
public class AUserDao extends UserDao {

    @Override
    public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost~~~", "id", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }
}
