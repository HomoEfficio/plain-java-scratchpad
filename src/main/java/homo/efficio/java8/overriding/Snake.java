package homo.efficio.java8.overriding;

import java.io.IOException;

/**
 * @author homo.efficio@gmail.com
 *         create on 2016-12-05.
 */
public class Snake extends Animal {

    @Override
//    public void move() throws IOException {  // 스펙 8.4.8.3에 보면 throws 절 호환성도 필요
    private void move() {  // 스펙 8.4.8.3에 보면 throws 절 호환성도 필요
        System.out.println("Snake crawls.");
    }
}
