package homo.efficio.toby_spring_book.chapter03_02_strategy_pattern;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author homo.efficio@gmail.com
 *         created on 2017. 1. 29.
 */
public class UserDao {

    private DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
