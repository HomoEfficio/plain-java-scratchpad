package homo.efficio.java8.overriding;

import java.util.Objects;

/**
 * @author homo.efficio@gmail.com
 *         create on 2016-12-05.
 */
public class Animal {

    public void move() {
        System.out.println("Animal moves");
    }

    public void test() {

        Runnable runnable5 = Objects::hashCode;
    }
}
