package homo.efficio.toby_spring_book.chapter01;

import java.sql.SQLException;

/**
 * @author omwomw@sk.com
 *         created on 2017. 1. 29.
 */
public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDao();

        User user = new User();
        user.setId("homo.efficio");
        user.setPassword("Spring3.1");
        user.setEmail("homo.efficio@gmail.com");

        userDao.update(user);
    }
}
