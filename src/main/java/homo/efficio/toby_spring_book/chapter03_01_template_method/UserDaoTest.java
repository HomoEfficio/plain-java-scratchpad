package homo.efficio.toby_spring_book.chapter03_01_template_method;


import java.sql.SQLException;

/**
 * @author omwomw@sk.com
 *         created on 2017. 1. 29.
 */
public class UserDaoTest {

    public static void main(String[] args) throws SQLException {

        UserDao userDao = new AUserDao();

        User user = new User();
        user.setId("homo.efficio");
        user.setPassword("Spring3.1");
        user.setEmail("homo.efficio@gmail.com");

        userDao.update(user);
    }
}
