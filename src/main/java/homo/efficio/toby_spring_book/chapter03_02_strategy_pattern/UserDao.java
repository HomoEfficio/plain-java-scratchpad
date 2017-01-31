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

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

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
