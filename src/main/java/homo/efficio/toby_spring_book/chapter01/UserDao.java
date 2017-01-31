package homo.efficio.toby_spring_book.chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author homo.efficio@gmail.com
 *         created on 2017. 1. 29.
 */
public class UserDao {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost~~~", "id", "password");
    }

    public void update(User user) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement("update user set password = ? where id = ?");
        ps.setString(1, user.getPassword());
        ps.setString(2, user.getId());

        ps.executeUpdate();

        ps.close();
        c.close();
    }
}
