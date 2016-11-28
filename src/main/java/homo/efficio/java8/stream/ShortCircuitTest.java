package homo.efficio.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author omwomw@sk.com
 *         created on 2016. 11. 29.
 */
public class ShortCircuitTest {

    public static void main(String[] args) {

        List<String> sList = Arrays.asList(
                "I", "am", "studying", "Java8", "in","a", "bus", "from", "scratch"
        );

        Stream<String> stream = sList.stream()
                .filter(s -> {
                    System.out.println("filter-----");
                    System.out.println(s);
                    return s.length() > 3;
                })
                .map(s -> {
                    System.out.println("            map=======");
                    System.out.println("            " + s);
                    return s.toUpperCase();
                })
                .limit(2);
        System.out.println(stream.collect(Collectors.toList()));

        // 루핑을 모두 돌고 나서 2개만 추리는게 아니라
        // 2개 까지만 루핑을 돌고 루핑을 끝낸다
        // 외부 반복에서의 break 와 같다.
    }
}
