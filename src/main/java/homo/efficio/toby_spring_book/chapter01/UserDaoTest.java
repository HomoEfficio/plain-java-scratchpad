package homo.efficio.toby_spring_book.chapter01;

/**
 * @author homo.efficio@gmail.com
 *         created on 2017. 1. 29.
 */
public class UserDaoTest {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        User user = new User();
        user.setId("homo.efficio");
        user.setPassword("Spring3.1");
        user.setEmail("homo.efficio@gmail.com");

        userDao.crud1(user);
    }
}
