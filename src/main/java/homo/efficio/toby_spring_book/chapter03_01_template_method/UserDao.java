package homo.efficio.toby_spring_book.chapter03_01_template_method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author omwomw@sk.com
 *         created on 2017. 1. 29.
 */
public abstract class UserDao {

    public abstract Connection getConnection();

    public void update(User user) throws SQLException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement("update user set password = ? where id = ?");
        ps.setString(1, user.getPassword());
        ps.setString(2, user.getId());

        ps.executeUpdate();

        ps.close();
        c.close();
    }
}
