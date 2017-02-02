package homo.efficio.toby_spring_book.chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.SocketHandler;

/**
 * @author homo.efficio@gmail.com
 *         created on 2017. 1. 29.
 */
public class UserDao {

    public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost~~~", "id", "password");
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
