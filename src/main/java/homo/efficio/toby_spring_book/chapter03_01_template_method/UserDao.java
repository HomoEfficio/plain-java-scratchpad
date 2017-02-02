package homo.efficio.toby_spring_book.chapter03_01_template_method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author homo.efficio@gmail.com
 *         created on 2017. 1. 29.
 */
public abstract class UserDao {

    public abstract Connection getConnection();

    public void crud1(User user) {

        Connection c = getConnection();
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement("update user set password = ? where id = ?");
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) {}
            }
            if (c != null) {
                try { c.close(); } catch (SQLException e) {}
            }
        }
    }
}
